package via.sdj3.grpcslaughterhouse.service;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import via.sdj3.grpcslaughterhouse.model.Animal;
import via.sdj3.grpcslaughterhouse.protobuf.*;
import via.sdj3.grpcslaughterhouse.repository.AnimalRepository;


@GRpcService
public class SlaughterhouseImpl extends SlaughterhouseServiceGrpc.SlaughterhouseServiceImplBase
{
    @Autowired
    private AnimalRepository animalRepository;
    @Override
    public void registerAnimal(AnimalMsg request, StreamObserver<AnimalMsg> responseObserver)
    {
        super.registerAnimal(request, responseObserver);
        Animal animalToSave = new Animal();
        animalToSave.setWeight(request.getWeight());
        animalToSave.setAnimal_type(request.getType());
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
        super.cutAnimal(request, responseObserver);
    }

    @Override
    public void packIntoTray(PartList request, StreamObserver<TrayList> responseObserver)
    {
        super.packIntoTray(request, responseObserver);
    }

    @Override
    public void packForDistribution(TrayList request, StreamObserver<ProductList> responseObserver)
    {
        super.packForDistribution(request, responseObserver);
    }
}
