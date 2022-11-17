package via.sdj3.grpcslaughterhouse.service;

import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
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
public class SlaughterhouseImpl extends SlaughterhouseServiceGrpc.SlaughterhouseServiceImplBase
{
    private final AnimalRepository animalRepository;
    private final PartRepository partRepository;
    private final TrayRepository trayRepository;
    private final ProductRepository productRepository;

    private final SlaughterAssistant assistant;

    public SlaughterhouseImpl(AnimalRepository animalRepository, PartRepository partRepository, TrayRepository trayRepository, ProductRepository productRepository, SlaughterAssistant assistant)
    {
        this.animalRepository = animalRepository;
        this.partRepository = partRepository;
        this.trayRepository = trayRepository;
        this.productRepository = productRepository;
        this.assistant = assistant;
    }


    @Override
    public void registerAnimal(AnimalMsg request, StreamObserver<AnimalMsg> responseObserver)
    {
        Animal animalToSave = assistant.getAnimal(request);
        if (animalRepository.existsById(request.getId()))
        {
            responseObserver.onError(new StatusRuntimeException(Status.ABORTED.withDescription(
                    "An animal is already registered with that ID")));
        }
        if (!animalToSave.isConverted())
        {
            Animal savedAnimal = animalRepository.save(animalToSave);
            AnimalMsg savedAnimalMsg = assistant.getAnimalMsg(savedAnimal);
            responseObserver.onNext(savedAnimalMsg);
            responseObserver.onCompleted();
        } else
        {
            responseObserver.onError(new StatusRuntimeException(Status.ABORTED.withDescription(
                    "You can't register an animal that has already been converted")));
        }
    }

    @Override
    public void cutAnimal(AnimalMsg request, StreamObserver<PartList> responseObserver)
    {
        // Animal animalToSave = getAnimal(request);
        // Getting the animal from the repo instead
        Animal animalToSave = null;
        if (animalRepository.existsById(request.getId()))
        {
            animalToSave = animalRepository.findById(request.getId()).get();
        } else
        {
            responseObserver.onError(new StatusRuntimeException(Status.ABORTED.withDescription(
                    "No animal with that ID exists")));
        }
        if (!animalToSave.isConverted())
        {
            PartList partList = assistant.convertAnimalIntoParts(animalToSave);
            responseObserver.onNext(partList);
            responseObserver.onCompleted();
        } else
        {
            responseObserver.onError(new StatusRuntimeException(Status.ABORTED.withDescription(
                    "This animal is already converted. Please do not cut it into tiny pieces")));
        }
    }


    @Override
    public void packIntoTray(PartList request, StreamObserver<TrayList> responseObserver)
    {
        //Todo Clean up the code
        //Todo Describe the code

        //Getting all the types which are in the PartList
        //Calculating the total weight for each type
        ArrayList<String> types = new ArrayList<>();
        HashMap<String, Float> allWeightsForType = new HashMap<>();
        HashMap<String, ArrayList<PartMsg>> allPartsByType = new HashMap<>();
        request.getPartsList().forEach(partMsg ->
        {
            Part part = partRepository.findById(partMsg.getPartId()).get();
            if (part.isInTray())
            {
                responseObserver.onError(new StatusRuntimeException(Status.ABORTED.withDescription(
                        "Some of the parts are already used in trays.")));
            }
            part.setInTray(true);
            partRepository.save(part);

            String partName = partMsg.getPartName();
            Float weight = partMsg.getWeight();
            if (!types.contains(partName))
            {
                types.add(partName);
            }
            if (!allWeightsForType.containsKey(partName))
            {
                allWeightsForType.put(partName, weight);
                ArrayList<PartMsg> newPartsMsgs = new ArrayList<>();
                newPartsMsgs.add(partMsg);
                allPartsByType.put(partName, newPartsMsgs);

            } else
            {
                Float oldWeight = allWeightsForType.get(partName);
                Float newWeight = oldWeight + weight;
                allWeightsForType.replace(partName, newWeight);

                ArrayList<PartMsg> newPartMsgs = allPartsByType.get(partName);
                newPartMsgs.add(partMsg);
                allPartsByType.replace(partName, newPartMsgs);
            }
        });

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
                Optional<Part> part = partRepository.findById(partMsg.getPartId());
                parts.add(part.get());
            });
            tray.setParts(parts);
            Tray savedTray = trayRepository.save(tray);
            availableTrays.add(savedTray);
        });

        TrayList trayList = assistant.getTrayList(availableTrays);
        responseObserver.onNext(trayList);
        responseObserver.onCompleted();
    }

    // Packs all parts that are not currently in a tray
    public void packAllLooseParts(PackRequest request, StreamObserver<TrayList> responseObserver)
    {
        ArrayList<Part> allParts = (ArrayList<Part>) partRepository.findAll();
        ArrayList<Part> looseParts = new ArrayList<>();
        for (Part part :
                allParts)
        {
            if (!part.isInTray())
            {
                looseParts.add(part);
            }
        }
        if (looseParts.isEmpty())
        {
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
            if (animalRepo.isPresent())
            {
                animal = animalRepo.get();
            }
            String partName = part.getPartName();
            Float weight = part.getWeight();

            // Set the part to be in a tray in the repository
            part.setInTray(true);
            partRepository.save(part);

            if (!types.contains(partName))
            {
                types.add(partName);
            }
            if (!allWeightsForType.containsKey(partName))
            {
                allWeightsForType.put(partName, weight);
                ArrayList<PartMsg> newPartsMsgs = new ArrayList<>();
                assert animal != null;
                PartMsg partMsg = assistant.getPartMsg(part);
                newPartsMsgs.add(partMsg);
                allPartsByType.put(partName, newPartsMsgs);
            } else
            {
                Float oldWeight = allWeightsForType.get(partName);
                Float newWeight = oldWeight + weight;
                allWeightsForType.replace(partName, newWeight);
                ArrayList<PartMsg> newPartsMsgs = allPartsByType.get(partName);
                assert animal != null;
                PartMsg partMsg = assistant.getPartMsg(part);
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
        TrayList trayList = assistant.getTrayList(availableTrays);

        responseObserver.onNext(trayList);
        responseObserver.onCompleted();
    }

    @Override
    public void packForDistribution(TrayList request, StreamObserver<ProductList> responseObserver)
    {
        super.packForDistribution(request, responseObserver);
    }

    // Finds the parts needed for a half animal from the requested animal type and makes a product
    @Override
    public void packHalfAnimal(HalfAnimalMsg request, StreamObserver<ProductMsg> responseObserver)
    {
        String animalType = request.getAnimalType();
        // Parts are set to be in a product in the method called below
        ArrayList<Tray> productTrays = assistant.getPartsFromTrays(animalType);
        Product product = new Product();
        product.setTrays(productTrays);
        System.out.println(productTrays);
        product.setProductType("Half of a " + animalType);
        // Save the product to the repository and assign ID
        Product savedProduct = productRepository.save(product);
        ProductMsg productMsg = assistant.getProductMsg(savedProduct);

        responseObserver.onNext(productMsg);
        responseObserver.onCompleted();
    }

    @Override
    public void animalsInProduct(ProductID request, StreamObserver<AnimalList> responseObserver)
    {
        int id = request.getId();
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty())
        {
            responseObserver.onError(new StatusRuntimeException(Status.ABORTED.withDescription(
                    "Product not found 404.")));
        }
        Product product = optionalProduct.get();

        List<Tray> trays = product.getTrays();
        List<Part> parts = new ArrayList<>();
        trays.forEach(tray ->
        {
            parts.addAll(tray.getParts());
        });
        List<Animal> animals = new ArrayList<>();
        parts.forEach(part ->
        {
            if (!animals.contains(part.getAnimal()))
            {
                animals.add(part.getAnimal());
            }
        });

        responseObserver.onNext(assistant.getAnimalList(animals));
        responseObserver.onCompleted();


    }
}
