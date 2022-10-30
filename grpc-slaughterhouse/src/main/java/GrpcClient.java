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
            System.out.println("\n\nG'bless. If you know a sick animal and would like to save the population, press 1");
            System.out.println("If you want to know which animals are in a product, PLEASE press 2, 3, 4, or 5.");
            System.out.println("If you want QUIT, PLEASE press 6.");
            System.out.print("Enter number here: ");
            int selection = input.nextInt();

            if (selection == 1) {
                System.out.print("Enter the animal ID to retrieve its trace: ");
                int in = input.nextInt();
                productsWithAnimalResponse response= stub.productsWithAnimal(AnimalId.newBuilder().setId(in).build());
                System.out.println(response.getTrace());
            }

            if (selection > 1 && selection<6) {
                System.out.print("Enter the product ID in order to retrieve its trace: ");
                int in1 = input.nextInt();
                animalsInProductResponse response = stub.animalsInProduct(ProductId.newBuilder().setId(in1).build());
                System.out.println(response.getTrace());
            }
            if(selection == 6) {
                break;
            }
        }
        channel.shutdown();

    }
}
