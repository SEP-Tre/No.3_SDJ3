package via.sdj3.grpcslaughterhouse.service;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import via.sdj3.grpcslaughterhouse.model.Animal;
import via.sdj3.grpcslaughterhouse.model.Part;
import via.sdj3.grpcslaughterhouse.model.Product;
import via.sdj3.grpcslaughterhouse.model.Tray;
import via.sdj3.grpcslaughterhouse.protobuf.*;
import via.sdj3.grpcslaughterhouse.repository.AnimalRepository;
import via.sdj3.grpcslaughterhouse.repository.PartRepository;
import via.sdj3.grpcslaughterhouse.repository.ProductRepository;
import via.sdj3.grpcslaughterhouse.repository.TrayRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;


@GRpcService
public class SlaughterhouseImpl extends SlaughterhouseServiceGrpc.SlaughterhouseServiceImplBase {
    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private PartRepository partRepository;
    @Autowired
    private TrayRepository trayRepository;
    @Autowired
    private ProductRepository productRepository;

    private static Animal getAnimal(AnimalMsg request) {
        Animal animalToSave = new Animal();
        animalToSave.setWeight(request.getWeight());
        animalToSave.setAnimal_type(request.getType());
        animalToSave.setAnimal_id(request.getId());
        animalToSave.setConverted(request.getIsConverted());
        return animalToSave;
    }

    @Override
    public void registerAnimal(AnimalMsg request, StreamObserver<AnimalMsg> responseObserver) {
        Animal animalToSave = getAnimal(request);
        if (!animalToSave.isConverted()) {
            Animal savedAnimal = animalRepository.save(animalToSave);
            AnimalMsg savedAnimalMsg = AnimalMsg.newBuilder()
                    .setId(savedAnimal.getAnimal_id())
                    .setWeight(savedAnimal.getWeight())
                    .setType(savedAnimal.getAnimal_type())
                    .setIsConverted(false)
                    .build();
            responseObserver.onNext(savedAnimalMsg);
            responseObserver.onCompleted();
        } else {
            throw new IllegalArgumentException("You can't register an animal that has already been converted");
        }
    }

    @Override
    public void cutAnimal(AnimalMsg request, StreamObserver<PartList> responseObserver) {
        // TODO update animal to isConverted
        Animal animalToSave = getAnimal(request);
        if (!animalToSave.isConverted()) {
            PartList partList = convertAnimalIntoParts(animalToSave);
            responseObserver.onNext(partList);
            responseObserver.onCompleted();
        } else {
            throw new IllegalArgumentException("This animal is already converted. Please do not cut it into tiny pieces");
        }
    }

    @Override
    public void packIntoTray(PartList request, StreamObserver<TrayList> responseObserver) {
        //Getting all the types which are in the PartList
        //Calculating the total weight for each type
        ArrayList<String> types = new ArrayList<>();
        HashMap<String, Float> allWeightsForType = new HashMap<>();
        HashMap<String, ArrayList<PartMsg>> allPartsByType = new HashMap<>();
        request.getPartsList().forEach(partMsg ->
        {
            String partName = partMsg.getPartName();
            Float weight = partMsg.getWeight();
            if (!types.contains(partName)) {
                types.add(partName);
            }
            if (!allWeightsForType.containsKey(partName)) {
                allWeightsForType.put(partName, weight);
                ArrayList<PartMsg> newPartsMsgs = new ArrayList<>();
                newPartsMsgs.add(partMsg);
                allPartsByType.put(partName, newPartsMsgs);

            } else {
                Float oldWeight = allWeightsForType.get(partName);
                Float newWeight = oldWeight + weight;
                allWeightsForType.replace(partName, newWeight);

                ArrayList<PartMsg> newPartMsgs = allPartsByType.get(partName);
                newPartMsgs.add(partMsg);
                allPartsByType.replace(partName, newPartMsgs);
            }
        });
        System.out.println(types);
        System.out.println(allWeightsForType);
        System.out.println(allPartsByType);

        //Creating the trays from each
        ArrayList<Tray> availableTrays = new ArrayList<>();
        ArrayList<TrayMsg> trayMsgs = new ArrayList<>();
        types.forEach(type ->
        {
            Tray tray = new Tray();
            tray.setWeightCapacity(allWeightsForType.get(type));
            tray.setPartName(type);
            ArrayList<Part> parts = new ArrayList<>();
            ArrayList<PartMsg> partMsgs = new ArrayList<>();
            //Creating the ArrayList<TrayMsg> in parallel
            allPartsByType.get(type).forEach(partMsg ->
            {
                AnimalMsg animalMsg = partMsg.getAnimal();
                Animal animal = new Animal(animalMsg.getId(), animalMsg.getWeight(), animalMsg.getType(), true);
                Part part = new Part(animal, type, partMsg.getWeight());
                parts.add(part);
                partMsgs.add(partMsg);
            });
            tray.setParts(parts);
            availableTrays.add(tray);
            //WRONG \/
            TrayMsg trayMsg = TrayMsg.newBuilder()
                    .addRepeatedField(TrayMsg.getDescriptor().findFieldByName("parts"), partMsgs).build();
        });

    }

    // Packs all parts that are not currently in a tray
    public void packAllLooseParts(PackRequest request, StreamObserver<TrayList> responseObserver) {
        ArrayList<Part> allParts = (ArrayList<Part>) partRepository.findAll();
        ArrayList<Part> looseParts = new ArrayList<>();
        // TODO set isInTray for parts
        for (Part part:
             allParts) {
            if (!part.isInTray()) {
                looseParts.add(part);
            }
        }
        if (looseParts.isEmpty()) {
            throw new IllegalArgumentException("There were no loose parts");
        }
        // Shamelessly taken from above and modified
        ArrayList<String> types = new ArrayList<>();
        HashMap<String, Float> allWeightsForType = new HashMap<>();
        HashMap<String, ArrayList<PartMsg>> allPartsByType = new HashMap<>();
        looseParts.forEach(part ->
        {
            Optional<Animal> animalRepo = animalRepository.findById(part.getAnimal().getAnimal_id());
            Animal animal = null;
            if (animalRepo.isPresent()) {
                animal = animalRepo.get();
            }
            String partName = part.getPartName();
            Float weight = part.getWeight();
            if (!types.contains(partName)) {
                types.add(partName);
            }
            if (!allWeightsForType.containsKey(partName)) {
                allWeightsForType.put(partName, weight);
                ArrayList<PartMsg> newPartsMsgs = new ArrayList<>();
                assert animal != null;
                PartMsg partMsg = PartMsg.newBuilder()
                        .setPartId(part.getPartId())
                        .setAnimal(AnimalMsg.newBuilder()
                                .setId(animal.getAnimal_id())
                                .setWeight(animal.getWeight())
                                .build())
                        .setPartName(part.getPartName())
                        .setWeight(part.getWeight())
                        .build();
                newPartsMsgs.add(partMsg);
                allPartsByType.put(partName, newPartsMsgs);
            } else {
                Float oldWeight = allWeightsForType.get(partName);
                Float newWeight = oldWeight + weight;
                allWeightsForType.replace(partName, newWeight);
                ArrayList<PartMsg> newPartsMsgs = allPartsByType.get(partName);
                assert animal != null;
                PartMsg partMsg = PartMsg.newBuilder()
                        .setPartId(part.getPartId())
                        .setAnimal(AnimalMsg.newBuilder()
                                .setId(animal.getAnimal_id())
                                .setWeight(animal.getWeight())
                                .build())
                        .setPartName(part.getPartName())
                        .setWeight(part.getWeight())
                        .build();
                newPartsMsgs.add(partMsg);
                allPartsByType.replace(partName, newPartsMsgs);
            }
        });
        System.out.println(types);
        System.out.println(allWeightsForType);
        System.out.println(allPartsByType);

        //Creating the trays from each
        ArrayList<Tray> availableTrays = new ArrayList<>();
        ArrayList<TrayMsg> trayMsgs = new ArrayList<>();
        types.forEach(type ->
        {
            Tray tray = new Tray();
            tray.setWeightCapacity(allWeightsForType.get(type));
            tray.setPartName(type);
            ArrayList<Part> parts = new ArrayList<>();
            ArrayList<PartMsg> partMsgs = new ArrayList<>();
            //Creating the ArrayList<TrayMsg> in parallel
            allPartsByType.get(type).forEach(partMsg ->
            {
                AnimalMsg animalMsg = partMsg.getAnimal();
                Optional<Part> part = partRepository.findById(partMsg.getPartId());
                parts.add(part.get());
                partMsgs.add(partMsg);
            });
            tray.setParts(parts);

            // Lazy version of persistence
            Tray trayRepo = trayRepository.save(tray);
            int trayId = trayRepo.getTrayId();
            availableTrays.add(tray);

            PartList partList = PartList.newBuilder().addAllParts(partMsgs).build();
            TrayMsg trayMsg = TrayMsg.newBuilder().setTrayId(trayId).setWeightCapacity(tray.getWeightCapacity()).setPartName(tray.getPartName())
                    .setParts(partList).build();
            trayMsgs.add(trayMsg);
        });
        TrayList trayList = TrayList.newBuilder().addAllTrays(trayMsgs).build();

        responseObserver.onNext(trayList);
        responseObserver.onCompleted();
    }

    @Override
    public void packForDistribution(TrayList request, StreamObserver<ProductList> responseObserver) {
        super.packForDistribution(request, responseObserver);
    }

    private PartList convertAnimalIntoParts(Animal animal) {
        String type = animal.getAnimal_type().toLowerCase();
        ArrayList<Part> parts = new ArrayList<>();
        switch (type) {
            case "duck":

            case "chicken": {
                parts.add(new Part(animal, "wing", animal.getWeight() / 8));
                parts.add(new Part(animal, "wing", animal.getWeight() / 8));
                parts.add(new Part(animal, "breast", animal.getWeight() / 8));
                parts.add(new Part(animal, "breast", animal.getWeight() / 8));
                parts.add(new Part(animal, "bones", animal.getWeight() / 4));
                parts.add(new Part(animal, "leg", animal.getWeight() / 8));
                parts.add(new Part(animal, "leg", animal.getWeight() / 8));
                break;
            }
            default://Default is cow
            {
                //4 legs, ribs, head, tenderloin, chuck
                parts.add(new Part(animal, "leg", animal.getWeight() / 8));
                parts.add(new Part(animal, "leg", animal.getWeight() / 8));
                parts.add(new Part(animal, "leg", animal.getWeight() / 8));
                parts.add(new Part(animal, "leg", animal.getWeight() / 8));
                parts.add(new Part(animal, "chuck", animal.getWeight() / 16));
                parts.add(new Part(animal, "chuck", animal.getWeight() / 16));
                parts.add(new Part(animal, "ribs", animal.getWeight() / 16));
                parts.add(new Part(animal, "ribs", animal.getWeight() / 16));
                parts.add(new Part(animal, "head", animal.getWeight() / 8));
                parts.add(new Part(animal, "tenderloin", animal.getWeight() / 32));
                parts.add(new Part(animal, "tenderloin", animal.getWeight() / 32));
            }

        }
        ArrayList<PartMsg> partMsgs = new ArrayList<>();
        ArrayList<Part> savedParts = (ArrayList<Part>) partRepository.saveAll(parts);
        savedParts.forEach(part ->
        {
            PartMsg partMsg = PartMsg.newBuilder()
                    .setPartId(part.getPartId())
                    .setAnimal(AnimalMsg.newBuilder()
                            .setId(animal.getAnimal_id())
                            .setWeight(animal.getWeight()).build())
                    .setPartName(part.getPartName())
                    .setWeight(part.getWeight())
                    // Recently cut parts are not in trays yet
                    .setIsInTray(false)
                    .setIsInTray(false)
                    .build();
            partMsgs.add(partMsg);
        });
        PartList partList = PartList.newBuilder().addAllParts(partMsgs).build();
        return partList;
    }

    // Finds the parts needed for a half animal from the requested animal type and makes a product
    @Override
    public void packHalfAnimal(HalfAnimalMsg request, StreamObserver<ProductMsg> responseObserver) {
        String animalType = request.getAnimalType();
        ArrayList<Tray> productTrays = getPartsFromTrays(animalType);
        Product product = new Product();
        product.setTrays(productTrays); // Why is this empty
        System.out.println(productTrays);
        product.setProductType("Half of a " + animalType);
        int productId = productRepository.save(product).getProductId();
        ArrayList<TrayMsg> trayMsgs = new ArrayList<>();
        productTrays.forEach(tray ->
        {
            System.out.println(tray);
            ArrayList<PartMsg> partMsgs = new ArrayList<>();
            tray.getParts().forEach(part ->
            {
                PartMsg partMsg = PartMsg.newBuilder()
                        .setPartId(part.getPartId())
                        .setAnimal(AnimalMsg.newBuilder()
                                .setId(part.getAnimal().getAnimal_id())
                                .setWeight(part.getAnimal().getWeight()).build())
                        .setPartName(part.getPartName())
                        .setWeight(part.getWeight()).build();
                partMsgs.add(partMsg);
            });
            PartList partList = PartList.newBuilder().addAllParts(partMsgs).build();
            TrayMsg trayMsg = TrayMsg.newBuilder().setTrayId(tray.getTrayId()).setWeightCapacity(tray.getWeightCapacity()).setPartName(tray.getPartName())
                    .setParts(partList).build();
            trayMsgs.add(trayMsg);
        });
        TrayList trayList = TrayList.newBuilder().addAllTrays(trayMsgs).build();
        ProductMsg productMsg = ProductMsg.newBuilder().setProductId(productId).setProductType(product.getProductType())
                .setTrays(trayList).build();

        responseObserver.onNext(productMsg);
        responseObserver.onCompleted();
    }

    // Used to get the parts needed for a half animal product based on the type
    private ArrayList<Tray> getPartsFromTrays(String animalType) {
        ArrayList<Tray> animalTrays = findAnimalTrays(animalType);
        ArrayList<Tray> productTrays = new ArrayList<>();
        // TODO set isInProduct
        switch (animalType.toLowerCase()) {
            case "cow": {
                // get 2 legs
                for (Tray tray : animalTrays) {
                    if (tray.getPartName().contains("leg") && tray.getParts().get(0) != null
                            && tray.getParts().get(1) != null) {
                        productTrays.add(tray);
                        System.out.println("I added some leg");
                        // TODO be able to remove parts that are used in the database
                    }
                }
                // ribs
                for (Tray tray : animalTrays) {
                    if (tray.getPartName().contains("ribs") && tray.getParts().get(0) != null) {
                        productTrays.add(tray);
                    }
                }
                // chuck
                for (Tray tray : animalTrays) {
                    if (tray.getPartName().contains("chuck") && tray.getParts().get(0) != null) {
                        productTrays.add(tray);
                    }
                }
                // tenderloin
                for (Tray tray : animalTrays) {
                    if (tray.getPartName().contains("tenderloin") && tray.getParts().get(0) != null) {
                        productTrays.add(tray);
                    }
                }
            }
            break;
            case "chicken": {
                // wing
                for (Tray tray : animalTrays) {
                    if (tray.getPartName().contains("wing") && tray.getParts().get(0) != null) {
                        productTrays.add(tray);
                    }
                }
                // breast
                for (Tray tray : animalTrays) {
                    if (tray.getPartName().contains("wing") && tray.getParts().get(0) != null) {
                        productTrays.add(tray);
                    }
                }
                // leg
                for (Tray tray : animalTrays) {
                    if (tray.getPartName().contains("leg") && tray.getParts().get(0) != null) {
                        productTrays.add(tray);
                    }
                }
            }
            break;
            default:
                throw new IllegalArgumentException("Sorry you can't make a half animal from that");
        }
        return productTrays;
    }

    // Gets all the trays from a specified animal
    private ArrayList<Tray> findAnimalTrays(String animalType) {
        ArrayList<Tray> allTrays = (ArrayList<Tray>) trayRepository.findAll();
        ArrayList<Tray> animalTrays = new ArrayList<>();
        for (Tray tray : allTrays) {
            // Can we shorten this method?
            if (tray.getParts().get(0).getAnimal().getAnimal_type().equals(animalType)) {
                animalTrays.add(tray);
                System.out.println("I added a tray: " + tray.toString());
            }
        }
        return animalTrays;
    }
}
