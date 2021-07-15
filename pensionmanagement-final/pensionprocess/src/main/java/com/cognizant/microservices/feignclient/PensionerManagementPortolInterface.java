package com.cognizant.microservices.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;

import com.cognizant.pensionmanagement.model.PensionAmountDetails;


@ComponentScan
@FeignClient(url="http://localhost:8081",name="pensionerList")
public interface PensionerManagementPortolInterface {
	
	
	@GetMapping("/PensionAmounts")
	public List<PensionAmountDetails> getPensionersAmountDetails();
	
	
}
