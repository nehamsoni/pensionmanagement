package com.cognizant.pensionmanagement.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.pensionmanagement.model.PensionAmountDetails;
import com.cognizant.pensionmanagement.service.PensionManagementService;
import com.cognizant.pensionmanagement.service.PensionProcessServiceDelegate;
import com.cognizant.pensionmanagement.service.exception.PensionDetailsNotFoundException;


@RestController
@EnableFeignClients
@RequestMapping(path = "/PensionAmounts")
public class PensionDetailsController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PensionDetailsController.class);

	@Autowired
	private PensionManagementService pensionManagementService ;
	


	@GetMapping
	public List<PensionAmountDetails> getAllPensionerDetails() {
		LOGGER.info("Start");

		List<PensionAmountDetails> details = pensionManagementService.getAllPensioners();

		LOGGER.info("End");

		return details;
	}

	@GetMapping("/{Id}")
	public PensionAmountDetails getDetailsByAadharId(@PathVariable Long Id) throws PensionDetailsNotFoundException
	{
		LOGGER.info("Start");
		pensionManagementService.getAllPensioners();
		PensionAmountDetails detail = pensionManagementService.getByAadharId(Id);
		LOGGER.info("End");
		return detail;
	}
	
	
	
	
	
	

}