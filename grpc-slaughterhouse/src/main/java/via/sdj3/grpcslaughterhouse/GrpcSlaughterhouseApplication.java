package via.sdj3.grpcslaughterhouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import via.sdj3.grpcslaughterhouse.service.RecallImpl;

@SpringBootApplication
public class GrpcSlaughterhouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrpcSlaughterhouseApplication.class, args);
	}

}
