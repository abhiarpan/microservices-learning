package com.service.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaDemoServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaDemoServiceRegistryApplication.class, args);
	}

}
