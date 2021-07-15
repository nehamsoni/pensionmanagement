package com.cognizant.microservices.app.controller;
 

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.microservices.app.service.PensionProcessServiceDelegate;
import com.cognizant.pensionmanagement.model.PensionAmountDetails;
import com.cognizant.pensionmanagement.model.PensionDetails;
import com.cognizant.pensionmanagement.model.PensionerInput;




@RestController
@EnableFeignClients
public class PensionProcessServiceController {
	
     
    @Autowired
    private PensionProcessServiceDelegate pensionProcessDelegate;
    
   
    @GetMapping("/getPensionDetails")
    public List<PensionDetails> getPensioners(){
    	
		return pensionProcessDelegate.callPensionDetailsAndGetDataClient();
    	
    	
    	
    }
    
    @GetMapping("/getPensionDetails/{Id}")
    public PensionDetails getPensioner(HttpServletRequest req ,@PathVariable long Id){
    	
		return pensionProcessDelegate.callPensionDetailServiceAndGetData(Id);
    	
    	
    }
    
    @PostMapping("/getPensionAmountDetails")
    public List<PensionAmountDetails> getPensionersAmount(){
		return pensionProcessDelegate.callPensionAmountDetailServiceAndGetData();
    	
    }
    
    @PostMapping("/getPensionAmountDetails/{Id}")
    public PensionAmountDetails getPensionerAmount(@PathVariable long Id){
		return pensionProcessDelegate.callPensionAmountDetailServiceAndGetIndividualData(Id);
    	
    }
    
    @PostMapping("/PensionDetail")
    public PensionAmountDetails getPensionerdetail(@RequestBody PensionerInput pensionerInput) {
    	
    	try
    	{
    	PensionDetails detail = pensionProcessDelegate.callPensionDetailServiceAndGetData(Long.parseLong(pensionerInput.getAadharNumber()));
    	System.out.println(detail);
    	
    	if(detail.getPan().equals(pensionerInput.getPan()) && detail.getName().equals(pensionerInput.getName()) && detail.getDateOfBirth().equals(pensionerInput.getDateOfBirth()))
    	{
    	PensionAmountDetails pen= pensionProcessDelegate.callPensionAmountDetailServiceAndGetIndividualData(Long.parseLong(pensionerInput.getAadharNumber()));
    	System.out.print(pen);
		return pen;
    	}
    	}
    	catch(Exception e)
    	{
    		return null;
    	}
    	return null;
    	
    	
    }
    
   
 
   
}