package via.sdj3.grpcslaughterhouse.service;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import via.sdj3.grpcslaughterhouse.model.Part;
import via.sdj3.grpcslaughterhouse.model.Product;
import via.sdj3.grpcslaughterhouse.model.ProductTrace;
import via.sdj3.grpcslaughterhouse.model.Tray;
import via.sdj3.grpcslaughterhouse.protobuf.*;
import via.sdj3.grpcslaughterhouse.repository.PartRepository;
import via.sdj3.grpcslaughterhouse.repository.ProductRepository;
import via.sdj3.grpcslaughterhouse.repository.ProductTraceViewRepository;
import via.sdj3.grpcslaughterhouse.repository.TrayRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@GRpcService
public class RecallImpl extends RecallServiceGrpc.RecallServiceImplBase
{

    @Autowired
    private ProductTraceViewRepository productTraceViewRepo;

    @Override
    public void animalsInProduct(ProductId request, StreamObserver<animalsInProductResponse> responseObserver) {
        int productId=request.getId();
        System.out.println("Searching for the trace of Product with ID: " + productId);
        System.out.println("...");
        System.out.println("...");
        System.out.println("...");
        String responseString = getAnimalsInProduct(productId);
        animalsInProductResponse response =
                animalsInProductResponse.newBuilder().setTrace(responseString).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void productsWithAnimal(AnimalId request, StreamObserver<productsWithAnimalResponse> responseObserver) {
        int animalId = request.getId();
        System.out.println("Searching for the trace of Animal with ID: " + animalId);
        System.out.println("...");
        System.out.println("...");
        System.out.println("...");
        String responseString = getProductsWithAnimal(animalId);
        productsWithAnimalResponse response =
                productsWithAnimalResponse.newBuilder().setTrace(responseString).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    private String getAnimalsInProduct(int productId)
    {
        //System.out.println(productTraceRepo.findAll());
        // TODO: 10/27/2022 The trace repo is working!!!!!
        // TODO: 30-10-2022 Clean the code, Clean the toString in ProductTrace
        // TODO: 30-10-2022 Do the getProducts method
        // TODO: 30-10-2022 Delete the 'id' variable from db and ProductTrace
        // TODO: 30-10-2022 Maybe change the proto to display the string of trace instead
        //  of the ones that we have
        List<ProductTrace> testTrace = productTraceViewRepo.findProductTracesByProductId(productId);
        System.out.println(testTrace);
        return testTrace.toString();

    }

    private String getProductsWithAnimal(int animalId)
    {
        List<ProductTrace> animalTrace = productTraceViewRepo.findProductTraceByAnimalId(animalId);
        System.out.println(animalTrace);
        return animalTrace.toString();
    }

}
