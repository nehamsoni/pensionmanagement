package com.cognizant.pensionmanagement.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.pensionmanagement.model.PensionAmountDetails;
import com.cognizant.pensionmanagement.model.PensionDetails;
import com.cognizant.pensionmanagement.service.exception.PensionDetailsNotFoundException;


@Service
public class PensionManagementService {
	
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PensionManagementService.class);
	List<PensionAmountDetails> list = new ArrayList<PensionAmountDetails>();
	
	@Autowired
	private PensionProcessServiceDelegate pensionProcessDelegate;
	
	boolean start = true;
	
	public List<PensionAmountDetails> getAllPensioners() {
		LOGGER.info("Start");
		List<PensionDetails> pensioners=pensionProcessDelegate.callPensionDetailsAndGetDataClient();
		
		if(start) {
		for(PensionDetails i : pensioners) {
			Double totalpension =0.0;
			Double pensionamount =0.0;
			Double bankcharge =0.0;
			Double Allowance  = i.getAllowances();
			Double salary = i.getSalary();
			String banktype = i.getBankType();
			String pensiontype = i.getSelfOrFamilyPension();
			if(banktype.equalsIgnoreCase("PVT")) {
				bankcharge = 500.0;
			}
			else {
				bankcharge = 550.0;
			}
			if(pensiontype.equalsIgnoreCase("self")) {
				pensionamount = (0.8*salary)+Allowance;
			}
			else {
				pensionamount =  (0.5*salary)+Allowance;
			}
			totalpension = pensionamount - bankcharge;
			
			list.add(new PensionAmountDetails(i.getAadharNumber(),i.getName(),totalpension,bankcharge));
		}
		start =false;
		}
		
		LOGGER.info("End");
		return list;
	}


	public PensionAmountDetails getByAadharId(Long id)  {
		
		getAllPensioners();
		System.out.println(list); 
		PensionAmountDetails details =null;
		for(PensionAmountDetails i : list) {
			if(i.getAadharNumber().equals(id)) {
				System.out.print(i.getAadharNumber());
				details = i;
				return details;
			}
			
		}
		throw new PensionDetailsNotFoundException("AadharNumber Not Found: "+id);
	}
	
	
	
	
	
	
	
	

	 
}