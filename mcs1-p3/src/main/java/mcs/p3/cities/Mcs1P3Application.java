package mcs.p3.cities;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Mcs1P3Application {

	public static void main(String[] args) {
		SpringApplication.run(Mcs1P3Application.class, args);
	}

}
