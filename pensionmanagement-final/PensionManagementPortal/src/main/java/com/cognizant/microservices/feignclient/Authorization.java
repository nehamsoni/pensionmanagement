package com.cognizant.microservices.feignclient;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import com.cognizant.pensionmanagement.model.AuthToken;
import com.cognizant.pensionmanagement.model.LoginUser;







@ComponentScan
@FeignClient(url="http://localhost:8000",name="authdetails")
public interface Authorization {
	
	@PostMapping(value = "/token/generate-token")
    public AuthToken register(@RequestBody LoginUser loginUser);
	
	@GetMapping("/token/get-token")
	public String get();
	
	@GetMapping("/auth")
	public boolean getToken(@RequestHeader("Authorization") String Header);
	 
	
}
