package com.cognizant.microservices.feignclient;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;






@ComponentScan
@FeignClient(url="http://localhost:8000",name="authdetails")
public interface Authorization {
	
	
	@GetMapping("/auth")
	public boolean getToken(@RequestHeader("Authorization") String Header);
	 
	
}
