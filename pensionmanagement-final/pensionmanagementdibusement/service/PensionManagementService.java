package com.cognizant.pensionmanagement.service;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.pensionmanagement.dao.PensionManagementDao;
import com.cognizant.pensionmanagement.model.PensionDetails;
import com.cognizant.pensionmanagement.repository.PensionDetailsRepository;
import com.cognizant.pensionmanagement.service.exception.PensionDetailsNotFoundException;

@Service
public class PensionManagementService {
	
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PensionManagementService.class);

	@Autowired
	private PensionManagementDao pensionDao;
	
	
	
	public List<PensionDetails> getAllPensionerDetails() {
		LOGGER.info("Start");

		List<PensionDetails> details = pensionDao.getAllPensionerDetails();
		LOGGER.info("End");
		
		return details;
	}

	public void updatePensionerDetails(PensionDetails pensionDetail) throws PensionDetailsNotFoundException {
		LOGGER.info("Start");

		pensionDao.updatePensionerDetails(pensionDetail);
		LOGGER.info("End");
	}
	
	public PensionDetails deletePensionerDetails(Long id) throws PensionDetailsNotFoundException {
		PensionDetails detail = pensionDao.deletePensionerDetails(id);
		return detail;
	}

	public void addPensioner(@Valid PensionDetails pensionDetail) {
		// TODO Auto-generated method stub
		pensionDao.addPensioner(pensionDetail);
		
	}
	
	public PensionDetails getByAadharId(Long Id) throws PensionDetailsNotFoundException
	{
		PensionDetails detail = pensionDao.getByAadharId(Id);
		return detail;
	}
	

	 
}