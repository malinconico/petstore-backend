package rbc.petstore;


import rbc.petstore.models.Pet;
import rbc.petstore.repositories.PetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.util.Arrays;

@SpringBootApplication
public class SpringBootRestExampleApplication {



	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestExampleApplication.class, args);
	}


}
