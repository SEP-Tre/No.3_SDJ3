package via.sdj3.grpcslaughterhouse.service;

import io.grpc.Status;
import io.grpc.StatusRuntimeException;
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
import java.util.List;
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

    private static ProductList getProductList(List<Product> products) {
        ArrayList<ProductMsg> productMsgs = new ArrayList<>();
        for (Product product :
                products) {
            productMsgs.add(getProductMsg(product));
        }
        return ProductList.newBuilder()
                .addAllProducts(productMsgs)
                .build();
    }

    private static ProductMsg getProductMsg(Product product) {
        return ProductMsg.newBuilder()
                .setProductId(product.getProductId())
                .setProductType(product.getProductType())
                .setTrays(getTrayList(product.getTrays()))
                .build();
    }

    private static TrayList getTrayList(List<Tray> trays) {
        ArrayList<TrayMsg> trayMsgs = new ArrayList<>();
        for (Tray tray :
                trays) {
            trayMsgs.add(getTrayMsg(tray));
        }
        return TrayList.newBuilder().addAllTrays(trayMsgs).build();
    }

    private static TrayMsg getTrayMsg(Tray tray) {
        return TrayMsg.newBuilder()
                .setTrayId(tray.getTrayId())
                .setWeightCapacity(tray.getWeightCapacity())
                .setPartName(tray.getPartName())
                .setParts(getPartList(tray.getParts()))
                .build();
    }

    private static PartList getPartList(List<Part> parts) {
        ArrayList<PartMsg> partMsgs = new ArrayList<>();
        for (Part part :
                parts) {
            partMsgs.add(getPartMsg(part));
        }
        return PartList.newBuilder()
                .addAllParts(partMsgs)
                .build();
    }

    private static PartMsg getPartMsg(Part part) {
        return PartMsg.newBuilder()
                .setPartId(part.getPartId())
                .setAnimal(getAnimalMsg(part.getAnimal()))
                .setPartName(part.getPartName())
                .setWeight(part.getWeight())
                .setIsInProduct(part.isInProduct())
                .setIsInTray(part.isInTray())
                .build();
    }

    private static AnimalMsg getAnimalMsg(Animal animal) {
        return AnimalMsg.newBuilder()
                .setWeight(animal.getWeight())
                .setType(animal.getAnimal_type())
                .setId(animal.getAnimal_id())
                .setIsConverted(animal.isConverted())
                .build();
    }

    @Override
    public void registerAnimal(AnimalMsg request, StreamObserver<AnimalMsg> responseObserver) {
        Animal animalToSave = getAnimal(request);
        if (animalRepository.existsById(request.getId())) {
            responseObserver.onError(new StatusRuntimeException(Status.ABORTED.withDescription(
                    "An animal is already registered with that ID")));
        }
        if (!animalToSave.isConverted()) {
            Animal savedAnimal = animalRepository.save(animalToSave);
            AnimalMsg savedAnimalMsg = getAnimalMsg(animalToSave);
            responseObserver.onNext(savedAnimalMsg);
            responseObserver.onCompleted();
        } else {
            responseObserver.onError(new StatusRuntimeException(Status.ABORTED.withDescription(
                    "You can't register an animal that has already been converted")));
        }
    }

    @Override
    public void cutAnimal(AnimalMsg request, StreamObserver<PartList> responseObserver) {
        // Animal animalToSave = getAnimal(request);
        // Getting the animal from the repo instead
        Animal animalToSave = null;
        if (animalRepository.existsById(request.getId())) {
            animalToSave = animalRepository.findById(request.getId()).get();
        } else {
            responseObserver.onError(new StatusRuntimeException(Status.ABORTED.withDescription(
                    "No animal with that ID exists")));
        }
        if (!animalToSave.isConverted()) {
            PartList partList = convertAnimalIntoParts(animalToSave);
            responseObserver.onNext(partList);
            responseObserver.onCompleted();
        } else {
            responseObserver.onError(new StatusRuntimeException(Status.ABORTED.withDescription(
                    "This animal is already converted. Please do not cut it into tiny pieces")));
        }
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
        // Update the animal's converted boolean
        Animal convertedAnimal = animalRepository.findById(animal.getAnimal_id()).get();
        convertedAnimal.setConverted(true);
        animalRepository.save(convertedAnimal);

        // Set all parts to not be in a tray or product
        // Set all parts to have converted animals
        parts.forEach(part -> {
            part.setInTray(false);
            part.setInProduct(false);
            Animal animal1 = part.getAnimal();
            animal1.setConverted(true);
            part.setAnimal(animal1);
        });

        // Save the parts to the repository
        ArrayList<Part> savedParts = (ArrayList<Part>) partRepository.saveAll(parts);

        return getPartList(savedParts);
    }

    @Override
    public void packIntoTray(PartList request, StreamObserver<TrayList> responseObserver) {
        //Todo mark animal as used.
        //Todo Create a check if the parts or animals are already used.
        //Todo Clean up the code
        //Todo Add the partInTray repo and model
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
        // ArrayList<TrayMsg> trayMsgs = new ArrayList<>();
        types.forEach(type ->
        {
            Tray tray = new Tray();
            tray.setWeightCapacity(allWeightsForType.get(type));
            tray.setPartName(type);
            ArrayList<Part> parts = new ArrayList<>();
            // ArrayList<PartMsg> partMsgs = new ArrayList<>();
            //Creating the ArrayList<TrayMsg> in parallel
            allPartsByType.get(type).forEach(partMsg ->
            {
                AnimalMsg animalMsg = partMsg.getAnimal();
                Animal animal = new Animal(animalMsg.getId(), animalMsg.getWeight(), animalMsg.getType(), true);
                Part part = new Part(animal, type, partMsg.getWeight());
                parts.add(part);
                // partMsgs.add(partMsg);
            });
            tray.setParts(parts);
            Tray savedTray = trayRepository.save(tray);
            //System.out.println(savedTray);
            availableTrays.add(savedTray);
            /*
            PartList partList = getPartList(parts);
            TrayMsg trayMsg = TrayMsg.newBuilder()
                    .setParts(partList)
                    .setTrayId(savedTray.getTrayId())
                    .setWeightCapacity(savedTray.getWeightCapacity())
                    .setPartName(savedTray.getPartName())
                    .build();
            trayMsgs.add(trayMsg);
            */
        });
        TrayList trayList = getTrayList(availableTrays);
        responseObserver.onNext(trayList);
        responseObserver.onCompleted();
    }

    // Packs all parts that are not currently in a tray
    public void packAllLooseParts(PackRequest request, StreamObserver<TrayList> responseObserver) {
        ArrayList<Part> allParts = (ArrayList<Part>) partRepository.findAll();
        ArrayList<Part> looseParts = new ArrayList<>();
        for (Part part :
                allParts) {
            if (!part.isInTray()) {
                looseParts.add(part);
            }
        }
        if (looseParts.isEmpty()) {
            responseObserver.onError(new StatusRuntimeException(Status.ABORTED.withDescription(
                    "There were no loose parts")));
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

            // Set the part to be in a tray in the repository
            part.setInTray(true);
            partRepository.save(part);

            if (!types.contains(partName)) {
                types.add(partName);
            }
            if (!allWeightsForType.containsKey(partName)) {
                allWeightsForType.put(partName, weight);
                ArrayList<PartMsg> newPartsMsgs = new ArrayList<>();
                assert animal != null;
                PartMsg partMsg = getPartMsg(part);
                newPartsMsgs.add(partMsg);
                allPartsByType.put(partName, newPartsMsgs);
            } else {
                Float oldWeight = allWeightsForType.get(partName);
                Float newWeight = oldWeight + weight;
                allWeightsForType.replace(partName, newWeight);
                ArrayList<PartMsg> newPartsMsgs = allPartsByType.get(partName);
                assert animal != null;
                PartMsg partMsg = getPartMsg(part);
                newPartsMsgs.add(partMsg);
                allPartsByType.replace(partName, newPartsMsgs);
            }
        });
        System.out.println(types);
        System.out.println(allWeightsForType);
        System.out.println(allPartsByType);

        //Creating the trays from each
        ArrayList<Tray> availableTrays = new ArrayList<>();
        types.forEach(type ->
        {
            Tray tray = new Tray();
            tray.setWeightCapacity(allWeightsForType.get(type));
            tray.setPartName(type);
            ArrayList<Part> parts = new ArrayList<>();
            //Creating the ArrayList<TrayMsg> in parallel
            allPartsByType.get(type).forEach(partMsg ->
            {
                AnimalMsg animalMsg = partMsg.getAnimal();
                Optional<Part> part = partRepository.findById(partMsg.getPartId());
                parts.add(part.get());
            });
            tray.setParts(parts);

            // Lazy version of persistence
            Tray trayRepo = trayRepository.save(tray);

            // Add tray to list of trays
            availableTrays.add(tray);
        });
        TrayList trayList = getTrayList(availableTrays);

        responseObserver.onNext(trayList);
        responseObserver.onCompleted();
    }

    @Override
    public void packForDistribution(TrayList request, StreamObserver<ProductList> responseObserver) {
        super.packForDistribution(request, responseObserver);
    }

    // Finds the parts needed for a half animal from the requested animal type and makes a product
    @Override
    public void packHalfAnimal(HalfAnimalMsg request, StreamObserver<ProductMsg> responseObserver) {
        String animalType = request.getAnimalType();
        // Parts are set to be in a product in the method called below
        ArrayList<Tray> productTrays = getPartsFromTrays(animalType);
        Product product = new Product();
        product.setTrays(productTrays);
        System.out.println(productTrays);
        product.setProductType("Half of a " + animalType);
        // Save the product to the repository and assign ID
        Product savedProduct = productRepository.save(product);
        ProductMsg productMsg = getProductMsg(savedProduct);

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
                boolean legsFound = false;
                for (Tray tray : animalTrays) {
                    // Break out of the search for legs if 2 are found
                    if (legsFound) {
                        break;
                    }
                    if (tray.getPartName().contains("leg")) {

                        // For trays that have legs, find 2 legs and put them in the product
                        // Otherwise, go to the next tray and leave the other tray alone
                        ArrayList<Part> chosenLegs = new ArrayList<>();
                        for (Part part :
                                tray.getParts()) {
                            if (!part.isInProduct()) {
                                chosenLegs.add(part);
                            }
                            if (chosenLegs.size() == 2) {
                                chosenLegs.forEach(part1 ->
                                {
                                    // Set the part as being in a product
                                    part1.setInProduct(true);
                                    // Save to the repository to update it
                                    partRepository.save(part1);
                                });
                                productTrays.add(tray);
                                legsFound = true;
                                break;
                            }
                        }
                    }
                }
                // ribs
                boolean ribsFound = false;
                for (Tray tray : animalTrays) {
                    if (ribsFound) {
                        break;
                    }
                    if (tray.getPartName().contains("ribs")) {
                        for (Part part :
                                tray.getParts()) {
                            if (!part.isInProduct()) {
                                part.setInProduct(true);
                                partRepository.save(part);
                                productTrays.add(tray);
                                ribsFound = true;
                                break;
                            }
                        }
                    }
                }
                // chuck
                boolean chuckFound = false;
                for (Tray tray : animalTrays) {
                    if (chuckFound) {
                        break;
                    }
                    if (tray.getPartName().contains("chuck")) {
                        for (Part part :
                                tray.getParts()) {
                            if (!part.isInProduct()) {
                                part.setInProduct(true);
                                partRepository.save(part);
                                productTrays.add(tray);
                                chuckFound = true;
                                break;
                            }
                        }
                    }
                }
                // tenderloin
                boolean tenderloinFound = false;
                for (Tray tray : animalTrays) {
                    if (tenderloinFound) {
                        break;
                    }
                    if (tray.getPartName().contains("tenderloin")) {
                        for (Part part :
                                tray.getParts()) {
                            if (!part.isInProduct()) {
                                part.setInProduct(true);
                                partRepository.save(part);
                                productTrays.add(tray);
                                tenderloinFound = true;
                                break;
                            }
                        }
                    }
                }
            }
            break;
            case "chicken": {
                // wing
                boolean wingFound = false;
                for (Tray tray : animalTrays) {
                    if (wingFound) {
                        break;
                    }
                    if (tray.getPartName().contains("wing")) {
                        for (Part part :
                                tray.getParts()) {
                            if (!part.isInProduct()) {
                                part.setInProduct(true);
                                partRepository.save(part);
                                productTrays.add(tray);
                                wingFound = true;
                                break;
                            }
                        }
                    }
                }
                // breast
                boolean breastFound = false;
                for (Tray tray : animalTrays) {
                    if (breastFound) {
                        break;
                    }
                    if (tray.getPartName().contains("breast")) {
                        for (Part part :
                                tray.getParts()) {
                            if (!part.isInProduct()) {
                                part.setInProduct(true);
                                partRepository.save(part);
                                productTrays.add(tray);
                                breastFound = true;
                                break;
                            }
                        }
                    }
                }
                // leg
                boolean legFound = false;
                for (Tray tray : animalTrays) {
                    if (legFound) {
                        break;
                    }
                    if (tray.getPartName().contains("leg")) {
                        for (Part part :
                                tray.getParts()) {
                            if (!part.isInProduct()) {
                                part.setInProduct(true);
                                partRepository.save(part);
                                productTrays.add(tray);
                                legFound = true;
                                break;
                            }
                        }
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
                System.out.println("I added a tray: " + tray);
            }
        }
        return animalTrays;
    }
}
