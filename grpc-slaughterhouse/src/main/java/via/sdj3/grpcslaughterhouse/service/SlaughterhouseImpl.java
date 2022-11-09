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

    @Override
    public void registerAnimal(AnimalMsg request, StreamObserver<AnimalMsg> responseObserver) {
        Animal animalToSave = getAnimal(request);
        Animal savedAnimal = animalRepository.save(animalToSave);
        AnimalMsg savedAnimalMsg = AnimalMsg.newBuilder()
                .setId(savedAnimal.getAnimal_id())
                .setWeight(savedAnimal.getWeight())
                .setType(savedAnimal.getAnimal_type())
                .build();
        responseObserver.onNext(savedAnimalMsg);
        responseObserver.onCompleted();
    }


    @Override
    public void cutAnimal(AnimalMsg request, StreamObserver<PartList> responseObserver) {
        Animal animalToSave = getAnimal(request);
        PartList partList = convertAnimalIntoParts(animalToSave);
        responseObserver.onNext(partList);
        responseObserver.onCompleted();
    }

    @Override
    public void packIntoTray(PartList request, StreamObserver<TrayList> responseObserver) {
        super.packIntoTray(request, responseObserver);
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
                    .setWeight(part.getWeight()).build();
            partMsgs.add(partMsg);
        });
        PartList partList = PartList.newBuilder().addAllParts(partMsgs).build();
        return partList;
    }

    private static Animal getAnimal(AnimalMsg request) {
        Animal animalToSave = new Animal();
        animalToSave.setWeight(request.getWeight());
        animalToSave.setAnimal_type(request.getType());
        animalToSave.setAnimal_id(request.getId());
        return animalToSave;
    }

    @Override
    public void packHalfAnimal(HalfAnimalMsg request, StreamObserver<ProductMsg> responseObserver) {
        String animalType = request.getAnimalType();
        ArrayList<Tray> productTrays = getPartsFromTrays(animalType);
        Product product = new Product();
        product.setTrays(productTrays);
        product.setProductType("Half of a " + animalType);
        int productId = productRepository.save(product).getProductId();
        ArrayList<TrayMsg> trayMsgs = new ArrayList<>();
        productTrays.forEach(tray ->
                {
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

    private ArrayList<Tray> getPartsFromTrays(String animalType) {
        ArrayList<Tray> animalTrays = findAnimalTrays(animalType);
        ArrayList<Tray> productTrays = new ArrayList<>();
        switch (animalType.toLowerCase()) {
            case "cow": {
                // get 2 legs
                for (Tray tray : animalTrays) {
                    if (tray.getPartName().equals("leg") && tray.getParts().get(0) != null
                            && tray.getParts().get(1) != null) {
                        productTrays.add(tray);
                        // TODO be able to remove parts that are used in the database
                    }
                }
                // ribs
                for (Tray tray : animalTrays) {
                    if (tray.getPartName().equals("ribs") && tray.getParts().get(0) != null) {
                        productTrays.add(tray);
                    }
                }
                // chuck
                for (Tray tray : animalTrays) {
                    if (tray.getPartName().equals("chuck") && tray.getParts().get(0) != null) {
                        productTrays.add(tray);
                    }
                }
                // tenderloin
                for (Tray tray : animalTrays) {
                    if (tray.getPartName().equals("tenderloin") && tray.getParts().get(0) != null) {
                        productTrays.add(tray);
                    }
                }
            }
            break;
            case "chicken" :
            {
                // wing
                for (Tray tray : animalTrays) {
                    if (tray.getPartName().equals("wing") && tray.getParts().get(0) != null) {
                        productTrays.add(tray);
                    }
                }
                // breast
                for (Tray tray : animalTrays) {
                    if (tray.getPartName().equals("wing") && tray.getParts().get(0) != null) {
                        productTrays.add(tray);
                    }
                }
                // leg
                for (Tray tray : animalTrays) {
                    if (tray.getPartName().equals("leg") && tray.getParts().get(0) != null) {
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

    private ArrayList<Tray> findAnimalTrays(String animalType) {
        ArrayList<Tray> allTrays = (ArrayList<Tray>) trayRepository.findAll();
        ArrayList<Tray> animalTrays = new ArrayList<>();
        for (Tray tray : allTrays) {
            // Can we shorten this method?
            if (tray.getParts().get(0).getAnimal().getAnimal_type().equals(animalType)) {
                animalTrays.add(tray);
            }
        }
        return animalTrays;
    }
}
