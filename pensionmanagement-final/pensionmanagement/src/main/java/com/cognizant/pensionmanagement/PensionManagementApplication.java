package com.cognizant.pensionmanagement;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableFeignClients(basePackages = {"com.cognizant.*"})
@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.cognizant.pensionmanagement.repository"})
public class PensionManagementApplication {
	public static void main(String[] args) {
		SpringApplication.run(PensionManagementApplication.class, args);
		
	}
	
	
}
