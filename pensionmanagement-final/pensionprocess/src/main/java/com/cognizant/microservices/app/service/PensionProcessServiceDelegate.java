package com.cognizant.microservices.app.service;
 


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.microservices.feignclient.PensionDetailInterface;
import com.cognizant.microservices.feignclient.PensionDisbusementInterface;
import com.cognizant.pensionmanagement.model.PensionAmountDetails;
import com.cognizant.pensionmanagement.model.PensionDetails;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
 
@Service
public class PensionProcessServiceDelegate {
 
 
  
    @Autowired
    private PensionDetailInterface pensioninterface;
    
    @Autowired
    private PensionDisbusementInterface pensionDisbusementInterface;
    
    
    
    @HystrixCommand(fallbackMethod = "callPensionDetailsAndGetData_Fallback")
    public List<PensionDetails> callPensionDetailsAndGetDataClient() {
 
        System.out.println("Getting Pension details ");
        return pensioninterface.getPensioners();
        
    }
    
    
    
    @HystrixCommand(fallbackMethod = "callPensionDetailServiceAndGetData_Fallback")
    public PensionDetails callPensionDetailServiceAndGetData(Long Id) {
 
        System.out.println("Getting Pension details ");
        return  pensioninterface.getPensioner(Id);
        
    }
    
    @HystrixCommand(fallbackMethod = "callPensionDetailsAndGetData_Fallback1")
    public List<PensionAmountDetails> callPensionAmountDetailServiceAndGetData() {
 
        System.out.println("Getting Pension details ");
        return  pensionDisbusementInterface.getPensionersAmountDetails();
        
    }

    @HystrixCommand(fallbackMethod = "callPensionDetailServiceAndGetData_Fallback1")
    public PensionAmountDetails callPensionAmountDetailServiceAndGetIndividualData(Long Id) {
 
        System.out.println("Getting Pension details ");
        return pensionDisbusementInterface.getPensionerAmountDetail(Id);
        
    }
   
    
    
    

    
    @SuppressWarnings("unused")
    private List<PensionDetails> callPensionDetailsAndGetData_Fallback() {
 
        System.out.println("PensionDetails Service is down!!! fallback route enabled...");
 
        return null;
    }
    
    @SuppressWarnings("unused")
    private  PensionDetails callPensionDetailServiceAndGetData_Fallback(Long Id) {
 
    	System.out.println("PensionDetails Service is down!!! fallback route enabled...");
    	 
        return null;
    }
    
    @SuppressWarnings("unused")
    private List<PensionAmountDetails> callPensionDetailsAndGetData_Fallback1() {
 
        System.out.println("PensionDetails Service is down!!! fallback route enabled...");
 
        return null;
    }
    
    @SuppressWarnings("unused")
    private  PensionAmountDetails callPensionDetailServiceAndGetData_Fallback1(Long Id) {
 
    	System.out.println("PensionDetails Service is down!!! fallback route enabled...");
    	 
        return null;
    }
       
    
}