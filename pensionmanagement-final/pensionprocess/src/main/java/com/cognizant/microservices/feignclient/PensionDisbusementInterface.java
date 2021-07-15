package com.cognizant.microservices.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cognizant.pensionmanagement.model.PensionAmountDetails;


@ComponentScan
@FeignClient(url="http://localhost:8083",name="pensionDibusement")
public interface PensionDisbusementInterface {
	
	
	@GetMapping("/PensionAmounts")
	public List<PensionAmountDetails> getPensionersAmountDetails();
	
	@GetMapping("/PensionAmounts/{Id}")
	public PensionAmountDetails getPensionerAmountDetail(@PathVariable long Id);

}
