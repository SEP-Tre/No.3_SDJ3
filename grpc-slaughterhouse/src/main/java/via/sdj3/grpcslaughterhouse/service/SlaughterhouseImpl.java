package via.sdj3.grpcslaughterhouse.service;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import via.sdj3.grpcslaughterhouse.model.Animal;
import via.sdj3.grpcslaughterhouse.model.Part;
import via.sdj3.grpcslaughterhouse.model.Tray;
import via.sdj3.grpcslaughterhouse.protobuf.*;
import via.sdj3.grpcslaughterhouse.repository.AnimalRepository;
import via.sdj3.grpcslaughterhouse.repository.PartRepository;
import via.sdj3.grpcslaughterhouse.repository.TrayRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


@GRpcService
public class SlaughterhouseImpl extends SlaughterhouseServiceGrpc.SlaughterhouseServiceImplBase
{
    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private PartRepository partRepository;
    @Autowired
    private TrayRepository trayRepository;

    @Override
    public void registerAnimal(AnimalMsg request, StreamObserver<AnimalMsg> responseObserver)
    {
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
    public void cutAnimal(AnimalMsg request, StreamObserver<PartList> responseObserver)
    {
        Animal animalToSave = getAnimal(request);
        PartList partList = convertAnimalIntoParts(animalToSave);
        responseObserver.onNext(partList);
        responseObserver.onCompleted();

    }

    @Override
    public void packIntoTray(PartList request, StreamObserver<TrayList> responseObserver)
    {
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
            tray.setParts(new HashSet<>(parts));
            Tray savedTray = trayRepository.save(tray);
            //System.out.println(savedTray);
            availableTrays.add(savedTray);
            PartList partList = PartList.newBuilder().addAllParts(partMsgs).build();
            TrayMsg trayMsg = TrayMsg.newBuilder()
                    .setParts(partList)
                    .setTrayId(savedTray.getTrayId())
                    .setWeightCapacity(savedTray.getWeightCapacity())
                    .setPartName(savedTray.getPartName())
                    .build();
            trayMsgs.add(trayMsg);
        });
        TrayList trayList = TrayList.newBuilder().addAllTrays(trayMsgs).build();
        responseObserver.onNext(trayList);
        responseObserver.onCompleted();
    }

    @Override
    public void packForDistribution(TrayList request, StreamObserver<ProductList> responseObserver)
    {
        super.packForDistribution(request, responseObserver);
    }

    private PartList convertAnimalIntoParts(Animal animal)
    {
        String type = animal.getAnimal_type().toLowerCase();
        ArrayList<Part> parts = new ArrayList<>();
        switch (type)
        {
            case "duck":

            case "chicken":
            {
                parts.add(new Part(animal, "wings", animal.getWeight() / 4));
                parts.add(new Part(animal, "breast", animal.getWeight() / 4));
                parts.add(new Part(animal, "torso", animal.getWeight() / 2));
                break;
            }
            default://Default is cow
            {
                //4 legs, ribs, head, tenderloin, chuck
                parts.add(new Part(animal, "leg", animal.getWeight() / 8));
                parts.add(new Part(animal, "leg", animal.getWeight() / 8));
                parts.add(new Part(animal, "leg", animal.getWeight() / 8));
                parts.add(new Part(animal, "leg", animal.getWeight() / 8));
                parts.add(new Part(animal, "chuck", animal.getWeight() / 4));
                parts.add(new Part(animal, "ribs", animal.getWeight() / 16));
                parts.add(new Part(animal, "head", animal.getWeight() / 8));
                parts.add(new Part(animal, "tenderloin", animal.getWeight() / 16));
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

    private static Animal getAnimal(AnimalMsg request)
    {
        Animal animalToSave = new Animal();
        animalToSave.setWeight(request.getWeight());
        animalToSave.setAnimal_type(request.getType());
        animalToSave.setAnimal_id(request.getId());
        return animalToSave;
    }
}
