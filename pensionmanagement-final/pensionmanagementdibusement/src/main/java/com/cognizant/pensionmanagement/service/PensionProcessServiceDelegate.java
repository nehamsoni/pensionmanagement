package com.cognizant.pensionmanagement.service;
 

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.pensionmanagement.feignclient.PensionDetailInterface;
import com.cognizant.pensionmanagement.model.PensionDetails;
import com.cognizant.pensionmanagement.service.exception.PensionDetailsNotFoundException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
 
@Service
public class PensionProcessServiceDelegate {
 
    @Autowired
    private PensionDetailInterface pensioninterface;
    
    
    @HystrixCommand(fallbackMethod = "callPensionDetailsAndGetData_Fallback")
    public List<PensionDetails> callPensionDetailsAndGetDataClient() {
 
        System.out.println("Getting Pension details ");
        return pensioninterface.getPensioners();
        
    }
    
      
    @SuppressWarnings("unused")
    private List<PensionDetails> callPensionDetailsAndGetData_Fallback() {
 
        System.out.println("PensionDetails Service is down!!! fallback route enabled...");
		return null;
    }
    
    
    
}