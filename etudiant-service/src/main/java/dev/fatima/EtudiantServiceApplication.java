package dev.fatima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class EtudiantServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EtudiantServiceApplication.class, args);
	}

}
