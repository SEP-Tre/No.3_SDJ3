package via.sdj3.grpcslaughterhouse.service;

import io.grpc.stub.StreamObserver;
import org.checkerframework.checker.units.qual.A;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import via.sdj3.grpcslaughterhouse.application.SlaughterhouseApplication;
import via.sdj3.grpcslaughterhouse.model.Part;
import via.sdj3.grpcslaughterhouse.model.Product;
import via.sdj3.grpcslaughterhouse.model.Tray;
import via.sdj3.grpcslaughterhouse.protobuf.*;
import via.sdj3.grpcslaughterhouse.repository.PartRepository;
import via.sdj3.grpcslaughterhouse.repository.ProductRepository;
import via.sdj3.grpcslaughterhouse.repository.TrayRepository;

import java.util.ArrayList;
import java.util.Collections;

@GRpcService
public class RecallImpl extends RecallServiceGrpc.RecallServiceImplBase {

    //private SlaughterhouseApplication api = new SlaughterhouseApplication();

    @Override
    public void animalsInProduct(ProductId request, StreamObserver<AnimalsIdList> responseObserver) {
        // super.animalsInProduct(request, responseObserver);
        System.out.println("animalsInProduct method in RecallImpl has been called");
        System.out.println("Received request: " + request.toString());
        int productIdInt = request.getId();
        var ref = new Object() {
            AnimalsIdList animalsIdList;
        };
        ArrayList<Integer> animalsInProduct = getAnimalsInProduct(productIdInt);
        System.out.println("This is the animals in product list:");
        System.out.println(animalsInProduct);
        var ref1 = new Object() {
            int index = 0;
        };
        animalsInProduct.forEach(animalId -> {
            AnimalId idProto = AnimalId.newBuilder().setId(animalId).build();
            ref.animalsIdList = AnimalsIdList.newBuilder().setList(ref1.index, idProto).build();
            ref1.index++;
        });
        responseObserver.onNext(ref.animalsIdList);
        responseObserver.onCompleted();


    }

    @Override
    public void productsWithAnimal(AnimalId request, StreamObserver<ProductIdList> responseObserver) {
        // super.productsWithAnimal(request, responseObserver);
        System.out.println("productsWithAnimal method in RecallImpl has been called");
        System.out.println("Received request: " + request.toString());
        int animalId = request.getId();
        ArrayList<Product> productList = getProductsWithAnimal(animalId);
        System.out.println("Product list: " + productList);
    }

    @Autowired
    private PartRepository partRepo;
    @Autowired
    private TrayRepository trayRepo;
    @Autowired
    private ProductRepository productRepo;

    public ArrayList<Integer> getAnimalsInProduct(int productId) {
        Iterable<Product> allFoundProducts = productRepo.findAllById(Collections.singleton(productId));

        ArrayList<Integer> allFoundTraysIds = new ArrayList<>();
        allFoundProducts.forEach(product ->
        {
            allFoundTraysIds.add(product.getTrayId());
        });

        //Problems may be here
        Iterable<Tray> allFoundTrays =
                trayRepo.findAllById(allFoundTraysIds);

        ArrayList<Integer> allFoundPartsIds = new ArrayList<>();
        allFoundTrays.forEach(tray ->
        {
            allFoundPartsIds.add(tray.getPartId());
        });

        Iterable<Part> allFoundParts =
                partRepo.findAllById(allFoundPartsIds);

        ArrayList<Integer> animalsIds = new ArrayList<>();
        allFoundParts.forEach(part ->
        {
            animalsIds.add(part.getAnimalId());
        });
        return animalsIds;
    }

    public ArrayList<Product> getProductsWithAnimal(int animalId) {
        Iterable<Part> allParts = partRepo.findAll();
        ArrayList<Integer> allFoundPartsIds = new ArrayList<>();
        allParts.forEach(part -> {
            if (animalId == part.getAnimalId()) allFoundPartsIds.add(part.getPartId());
        });
        Iterable<Tray> allFoundTrays = trayRepo.findAllById(allFoundPartsIds);
        ArrayList<Integer> allFoundTraysIds = new ArrayList<>();
        allFoundTrays.forEach(tray -> {
            allFoundTraysIds.add(tray.getTrayId());
        });
        Iterable<Product> allFoundProducts = productRepo.findAllById(allFoundTraysIds);
        //Todo problem might be here, if doesn't work use 'for each' on Iterable.
        return (ArrayList<Product>) allFoundProducts;
    }

}
//for each GRPC class, one implementation class will extend it.
// Use Kamil's pastebin for inspiration on how to do the implementation here
