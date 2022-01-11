package mcs.p3.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaP3Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaP3Application.class, args);
	}

}
