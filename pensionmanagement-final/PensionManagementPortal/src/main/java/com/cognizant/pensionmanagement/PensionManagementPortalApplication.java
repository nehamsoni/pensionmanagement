package com.cognizant.pensionmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.cognizant.microservices.*"})
public class PensionManagementPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(PensionManagementPortalApplication.class, args);
	}

}
