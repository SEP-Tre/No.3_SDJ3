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

    //private SlaughterhouseApplication api = new SlaughterhouseApplication();

    @Override
    public void animalsInProduct(ProductId request, StreamObserver<AnimalsIdList> responseObserver)
    {
        // super.animalsInProduct(request, responseObserver);
        System.out.println("animalsInProduct method in RecallImpl has been called");
        System.out.println("Received request: " + request.toString());
        int productIdInt = request.getId();
        ArrayList<Integer> animalsInProduct = getAnimalsInProduct(productIdInt);
        System.out.println("This is the animals in product list:");
        System.out.println(animalsInProduct);
        ArrayList<AnimalId> animalsForProto = new ArrayList<>();
        animalsInProduct.forEach(animalId ->
        {
            AnimalId animalIdProto = AnimalId.newBuilder().setId(animalId).build();
            animalsForProto.add(animalIdProto);
        });
        AnimalsIdList animalsIdList = AnimalsIdList.newBuilder().addAllList(animalsForProto).build();
        responseObserver.onNext(animalsIdList);
        responseObserver.onCompleted();


    }

    @Override
    public void productsWithAnimal(AnimalId request, StreamObserver<ProductIdList> responseObserver)
    {
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
    @Autowired
    private ProductTraceViewRepository productTraceViewRepo;

    public ArrayList<Integer> getAnimalsInProduct(int productId)
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
        return null;
        /*
        Iterable<ProductTrace> allTraces = productTraceViewRepo.findAll();
        ArrayList<ProductTrace> allFoundTraces = new ArrayList<>();
        allTraces.forEach(trace ->{
            if(productId==trace.getProductId())
            {
                System.out.println(trace.getProductId());
                allFoundTraces.add(trace);
            }
        });
        System.out.println(allFoundTraces);
        Optional<Product> foundProduct = productRepo.findById(productId);

        ArrayList<Tray> trayList= new ArrayList<>();
        Iterable<Tray> allTrays = trayRepo.findAll();
        allTrays.forEach(tray ->
        {
            if(foundProduct.get().getTray_id()==tray.getTray_id())
            {
                trayList.add(tray);
            }
        });
        System.out.println("Those are the all found trays: " + trayList);
        //Optional<Tray> foundTray = trayRepo.findById(foundProduct.get().getTrayId());
        ArrayList<Integer> allFoundPartIdsList = new ArrayList<>();
        trayList.forEach(tray -> {
            allFoundPartIdsList.add(tray.getPart_id());
        });
        System.out.println("All found part ids: " + allFoundPartIdsList);
        Iterable<Part> allParts = partRepo.findAllById(allFoundPartIdsList);
        ArrayList<Integer> animalIds = new ArrayList<>();
        allParts.forEach(part -> {
            animalIds.add(part.getAnimal_id());
        });
        System.out.println(animalIds);
        return animalIds;

        /*ArrayList<Part> allFoundPartsCorrect = new ArrayList<>();
        allParts.forEach(part -> {
            trayList.forEach(tray -> {
                if(tray.getPartId() ==  )
            });

        });



        ArrayList<Integer> allFoundPartsIds = new ArrayList<>();
        allFoundTrays.forEach(tray ->
        {
            allFoundPartsIds.add(tray.getPartId());
        });

        Iterable<Part> allFoundParts = partRepo.findAllById(allFoundPartsIds);

        ArrayList<Integer> animalsIds = new ArrayList<>();
        allFoundParts.forEach(part ->
        {
            animalsIds.add(part.getAnimalId());
        });
        return animalsIds;

         */

    }

    public ArrayList<Product> getProductsWithAnimal(int animalId)
    {
        Iterable<Part> allParts = partRepo.findAll();
        ArrayList<Integer> allFoundPartsIds = new ArrayList<>();
        allParts.forEach(part ->
        {
            if (animalId == part.getAnimalId()) allFoundPartsIds.add(part.getPartId());
        });
        Iterable<Tray> allFoundTrays = trayRepo.findAllById(allFoundPartsIds);
        ArrayList<Integer> allFoundTraysIds = new ArrayList<>();
        allFoundTrays.forEach(tray ->
        {
            allFoundTraysIds.add(tray.getTrayId());
        });
        Iterable<Product> allFoundProducts = productRepo.findAllById(allFoundTraysIds);
        //Todo problem might be here, if doesn't work use 'for each' on Iterable.
        return (ArrayList<Product>) allFoundProducts;
    }

}
//for each GRPC class, one implementation class will extend it.
// Use Kamil's pastebin for inspiration on how to do the implementation here
