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

        ArrayList<Tray> traysToBePacked = new ArrayList<>();
        traysToBePacked = assistant.convertList(request);
        ArrayList<Product> productList = new ArrayList<>();

        for (Tray tray : traysToBePacked)
        {

            ArrayList<Tray> trayOfCurrentProduct = new ArrayList<>();
            trayOfCurrentProduct.add(tray);
            Product product = new Product();

            for (Part part : tray.getParts())
            {
                part.setInProduct(true);
                partRepository.save(part);
            }
            product.setProductType(tray.getPartName());
            //productTrays.add(tray);
            product.setTrays(trayOfCurrentProduct);
            productList.add(product);


            System.out.println("I will create a product using this tray: " + trayOfCurrentProduct.get(0).getParts().size() + //nr of parts
                    " " + trayOfCurrentProduct.get(0).getParts().get(0).getAnimal().getAnimal_type() + //animal type
                    " " + trayOfCurrentProduct.get(0).getPartName()); //part name
            System.out.println("Created a product containing " + product.getTrays().get(0).getParts().size() //nr of parts
                    + " " + product.getTrays().get(0).getParts().get(0).getAnimal() //animal type
                    + " " + product.getTrays().get(0).getParts().get(0).getPartName());//part name


            productRepository.save(product); //Saving the current product into the repo before the next loop
            // TODO: 16/11/2022 I AM NOT SURE IF SAVING THE PRODUCT IS NECESSARY IF I AM JUST PASSING ON A PRODUCLIST?


        }

        ProductList productListMsg = assistant.getProductList(productList);

        responseObserver.onNext(productListMsg);
        responseObserver.onCompleted();
    }

    @Override
    public void recallProducts(AnimalMsg request, StreamObserver<ProductList> responseObserver)
    {
        int sickAnimalID = request.getId();
        List<Part> sickParts = assistant.findPartsOfSickAnimal(sickAnimalID);
        ArrayList<Part> sickPartsList = new ArrayList<>(sickParts);
        ArrayList<Tray> traysWithSickMeat = new ArrayList<>();
        ArrayList<Product> productsToRecall = new ArrayList<>();

        System.out.println("Start of recallProducts");
        System.out.println("Sick parts contains " + sickParts.size() + " elements");

        System.out.println("First for, second loop looping through all the trays. Number of all trays=" + assistant.getAllTrays().size());
        //triple for loop to find all the trays that have been in contact with the meat of a diseased animal.
        for (Part part : sickPartsList)
        {
            int sickPartID = part.getPartId();

            for (Tray tray : assistant.getAllTrays())
            {


                for (int i = 0; i <= tray.getParts().size() - 1; i++)
                {
                    if (tray.getParts().get(i).getPartId() == sickPartID && !traysWithSickMeat.contains(tray))
                    {
                        traysWithSickMeat.add(tray);
                        System.out.println("Adding the tray to the list of sick trays: tray ID:" + tray.getTrayId() + " part name: " + tray.getPartName());

                    }
                }
            }
        }
        //Another triple loop-> Every product -> All trays from every product -> compare their ID's with the trays containing sick meat. If it is a match,
        //add it to the list of products to be recalled.

        System.out.println("After the first three for loops, there are " + traysWithSickMeat.size() + " trays containing sick meat");
        System.out.println("Second for, first loop, looking through all the products. nr of all products: " + assistant.getAllProducts().size());
        for (Product product : assistant.getAllProducts())
        {

            for (Tray tray : product.getTrays())
            {
                for (Tray tray1 : traysWithSickMeat)
                {
                    if (tray.getTrayId() == tray1.getTrayId())
                    {
                        productsToRecall.add(product);
                        System.out.println("<!ALERT!> The product with the ID " + product.getProductId() + " which is a " + product.getProductType() + " must be immediately recalled!!!");
                    }
                }
            }
        }

        ProductList productListMsg = assistant.getProductList(productsToRecall);

        responseObserver.onNext(productListMsg);
        responseObserver.onCompleted();
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
