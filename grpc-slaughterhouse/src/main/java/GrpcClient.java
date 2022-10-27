import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import via.sdj3.grpcslaughterhouse.protobuf.*;

import java.util.Scanner;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel= ManagedChannelBuilder.forAddress("localhost",7171)
                .usePlaintext()
                .build();

        // TODO: 27/10/2022 PLEASE CHANGE PORT!!!!!!!!!1

        RecallServiceGrpc.RecallServiceBlockingStub stub = RecallServiceGrpc.newBlockingStub(channel);
        Scanner input=new Scanner(System.in);

        System.out.println("To get the list of involved products, enter the id of the sick animal: ");
        int in =input.nextInt();
        ProductIdList productIdList= stub.productsWithAnimal(AnimalId.newBuilder().setId(in).build());
        System.out.println(productIdList.toString());

        System.out.println("To get the list of animals in this product, enter the product id: ");
        int in1=input.nextInt();
        AnimalsIdList animalsIdList=stub.animalsInProduct(ProductId.newBuilder().setId(in).build());
        System.out.println(animalsIdList.toString());

        channel.shutdown();
    }
}
