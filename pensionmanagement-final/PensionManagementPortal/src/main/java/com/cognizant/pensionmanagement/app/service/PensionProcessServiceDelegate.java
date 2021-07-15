package com.cognizant.pensionmanagement.app.service;
 


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognizant.microservices.feignclient.Authorization;
import com.cognizant.microservices.feignclient.PensionDetailInterface;
import com.cognizant.pensionmanagement.model.AuthToken;
import com.cognizant.pensionmanagement.model.LoginUser;
import com.cognizant.pensionmanagement.model.PensionDetails;


 
@Service
public class PensionProcessServiceDelegate {
 
 
  
    @Autowired
    private PensionDetailInterface detail;
    
    @Autowired
    private Authorization auth;
    
    public String register() {
    	String token = auth.get();
    	return token;
    }
   
    public PensionDetails addpensioner(@RequestBody  @Valid PensionDetails pensioner) {
    	
    	return detail.addPensioner(pensioner);
		
    	
    }
    
    public PensionDetails updatepensioner(@RequestBody  PensionDetails pensioner) {
    	
    	return detail.updatePensionerDetails(pensioner);
		
    	
    }
    
    
    public AuthToken register(@RequestBody LoginUser loginUser) {
    	return auth.register(loginUser);
    }

	
    
    
       
    
}