package com.cognizant.microservices.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognizant.pensionmanagement.model.PensionAmountDetails;
import com.cognizant.pensionmanagement.model.PensionerInput;
@ComponentScan
@FeignClient(url="http://localhost:9098",name="pensionprocess")
public interface PensionManagementProxy {
	
	 @PostMapping("/PensionDetail")
	    public PensionAmountDetails getPensionerdetail(@RequestBody PensionerInput pensionerinput);
	
}
