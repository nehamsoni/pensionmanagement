package com.cognizant.pensionmanagement.feignclient;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;

import com.cognizant.pensionmanagement.model.PensionDetails;

@ComponentScan
@FeignClient(url="http://localhost:8082",name="pensionDetails")
public interface PensionDetailInterface {
	
	
	@GetMapping("/PensionDetailsByAadhar")
	public List<PensionDetails> getPensioners();
	
	

}
