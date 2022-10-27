package via.sdj3.grpcslaughterhouse.service;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import via.sdj3.grpcslaughterhouse.protobuf.*;

@GRpcService
public class RecallImpl extends RecallServiceGrpc.RecallServiceImplBase {
    @Override
    public void animalsInProduct(ProductId request, StreamObserver<AnimalsIdList> responseObserver) {
       // super.animalsInProduct(request, responseObserver);
        System.out.println("animalsInProduct method in RecallImpl has been called");
        System.out.println("Received request: "+request.toString());

    }

    @Override
    public void productsWithAnimal(AnimalId request, StreamObserver<ProductIdList> responseObserver) {
       // super.productsWithAnimal(request, responseObserver);
        System.out.println("productsWithAnimal method in RecallImpl has been called");
        System.out.println("Received request: "+request.toString());

    }
}
//for each GRPC class, one implementation class will extend it.
// Use Kamil's pastebin for inspiration on how to do the implementation here
