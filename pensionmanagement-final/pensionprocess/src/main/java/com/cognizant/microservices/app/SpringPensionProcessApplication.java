package com.cognizant.microservices.app;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;







@EnableFeignClients(basePackages = {"com.cognizant.microservices.*"})
@SpringBootApplication
@EnableHystrixDashboard
@EnableCircuitBreaker
public class SpringPensionProcessApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(SpringPensionProcessApplication.class, args);
		
		
		
	}
	
	

}
