package com.cognizant.microservices.feignclient;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;







@ComponentScan
@FeignClient(url="http://localhost:8081",name="authorization")
public interface PortalManagement {
	
	
	
	@GetMapping("/token")
	public String get();
	
	
	
	
	 
	
}
