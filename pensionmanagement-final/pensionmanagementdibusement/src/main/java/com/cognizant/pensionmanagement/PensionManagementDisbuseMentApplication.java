package com.cognizant.pensionmanagement;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;



@EnableFeignClients
@SpringBootApplication
@EnableHystrixDashboard
@EnableCircuitBreaker
public class PensionManagementDisbuseMentApplication {

	public static void main(String[] args) {
		SpringApplication.run(PensionManagementDisbuseMentApplication.class, args);
		
		
		
	}

}
