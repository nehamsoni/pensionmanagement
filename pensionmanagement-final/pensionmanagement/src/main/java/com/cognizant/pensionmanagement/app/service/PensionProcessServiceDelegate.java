package com.cognizant.pensionmanagement.app.service;
 


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.microservices.feignclient.Authorization;
import com.cognizant.microservices.feignclient.PortalManagement;



 
@Service
public class PensionProcessServiceDelegate {
 
 
  
    
    @Autowired
    private PortalManagement portol;
    
    @Autowired
    private Authorization auth;
    
    public String register() {
    	String token = portol.get();
    	return token;
    }
   
    
    public boolean callDataClient(String header) {
    	try {
        System.out.println("Getting Pension details ");
        return auth.getToken(header);
    	}
    	catch(Exception e) {
    		return false;
    	}
        
    }
    
   
    
    
       
    
}