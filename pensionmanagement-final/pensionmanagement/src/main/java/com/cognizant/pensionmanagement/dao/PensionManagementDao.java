package com.cognizant.pensionmanagement.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.cognizant.pensionmanagement.csv.CSVPensionerReader;

import com.cognizant.pensionmanagement.model.PensionDetails;
import com.cognizant.pensionmanagement.repository.PensionDetailsRepository;
import com.cognizant.pensionmanagement.service.exception.PensionDetailsNotFoundException;


@Repository
public class PensionManagementDao {
	
	@Autowired
	private PensionDetailsRepository repository;
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PensionManagementDao.class);
	
	private List<PensionDetails> PENSION_LIST = new ArrayList<PensionDetails>();
	
	boolean start= true;
	public PensionManagementDao() throws ParseException {
		
		CSVPensionerReader csvPensionReader = new CSVPensionerReader();
		PENSION_LIST = csvPensionReader.readBooksFromCSV("C:/Users/kaarthik saran/Downloads/Book1.csv");
		
	}
	
	
	
	public List<PensionDetails> getAllPensionerDetails() {
		if(start) {
		repository.saveAll(PENSION_LIST);
		start=false;
		}
		List<PensionDetails> pensioners = new ArrayList<>();
		repository.findAll().forEach(pensioner -> pensioners.add(pensioner));
		return pensioners;
	}
	
	public void updatePensionerDetails(PensionDetails pensionDetails) throws PensionDetailsNotFoundException  {
		LOGGER.info("Start");
		
		boolean updated = false;
		updated = repository.existsById(pensionDetails.getAadharNumber());
		
		if (updated) {
			repository.deleteById(pensionDetails.getAadharNumber());
			repository.save(pensionDetails);
		}
		else {
			throw new PensionDetailsNotFoundException("AadharNumber Not Found: "+ pensionDetails.getAadharNumber());
		}
			
		LOGGER.info("End");
	}

	public PensionDetails deletePensionerDetails(Long aadharNumber) throws PensionDetailsNotFoundException {
		LOGGER.info("Start");
		
		boolean deleted = false;
		deleted = repository.existsById(aadharNumber);

		if (deleted) {
			repository.deleteById(aadharNumber);
		}else {
			throw new PensionDetailsNotFoundException("AadharNumber Not Found: "+aadharNumber);
			}
		LOGGER.info("End");
		return null;
		
	}


	public void addPensioner(PensionDetails pensionDetails) {
		repository.save(pensionDetails);
		
	}
	
	public PensionDetails getByAadharId(Long Id) throws PensionDetailsNotFoundException {
		LOGGER.info("Start");
		boolean find = false;
		getAllPensionerDetails();
		PensionDetails detail = null;
		find = repository.existsById(Id);
		if (!find) {
			throw new PensionDetailsNotFoundException("AadharNumber Not Found: "+Id);
		}
		LOGGER.info("End");
		detail = repository.findById(Id).get();
		return	detail;
		
	
	}
	
	
}
