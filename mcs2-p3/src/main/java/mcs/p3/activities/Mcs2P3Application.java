package mcs.p3.activities;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Mcs2P3Application {

	public static void main(String[] args) {
		SpringApplication.run(Mcs2P3Application.class, args);
	}

}
