import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import via.sdj3.grpcslaughterhouse.protobuf.*;

import java.util.Scanner;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 7171)
                .usePlaintext()
                .build();
        Scanner input = new Scanner(System.in);

        while (true) {

            RecallServiceGrpc.RecallServiceBlockingStub stub = RecallServiceGrpc.newBlockingStub(channel);
            System.out.println("G'bless. If you know a sick animal and would like to save the population, press 1");
            System.out.println("If you want to know which animals are in a product, PLEASE press 2, 3, 4, or 5.");
            System.out.println("If you want QUIT, PLEASE press 6.");
            int selection = input.nextInt();

            if (selection == 1) {
                System.out.println("Enter the id of the sick animal to get the list of products potentially containing traces of the sick animal: ");
                int in = input.nextInt();
                ProductIdList productIdList = stub.productsWithAnimal(AnimalId.newBuilder().setId(in).build());
                System.out.println(productIdList.toString());
            }

            if (selection > 1 && selection<6) {
                System.out.println("To get the list of animals in the product, enter the product id: ");
                int in1 = input.nextInt();
                AnimalsIdList animalsIdList = stub.animalsInProduct(ProductId.newBuilder().setId(in1).build());
                System.out.println(animalsIdList.toString());
            }
            if(selection == 6) {
                break;
            }
        }
        channel.shutdown();

    }
}
