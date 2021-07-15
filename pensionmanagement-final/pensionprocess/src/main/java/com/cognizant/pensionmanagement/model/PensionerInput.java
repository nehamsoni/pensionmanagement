package com.cognizant.pensionmanagement.model;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PensionerInput {

	@NotBlank(message = "Please enter your name")
	private String name;
	
	@NotNull(message = "Please enter your DOB")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past(message = "That's impossible.Please enter a valid DOB")
	private Date dateOfBirth;
	
	@NotBlank(message = "Please enter your PAN")
	@Size(min=10,max=10, message = "Enter a valid 10 digit unique alphanumeric number")
	private String pan;
	
	@NotNull(message = "Please enter your aadhar number")
	@Pattern(regexp="\\d{12}",message = "Enter a valid 12 digit aadhar number")
	private String aadharNumber;
	
	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	@NotNull(message = "Please select any 1 pension type")
	private String pensionType;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) throws ParseException {
		
		this.dateOfBirth = dateOfBirth;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	

	public String getPensionType() {
		return pensionType;
	}

	public void setPensionType(String pensionType) {
		this.pensionType = pensionType;
	}

	
	
}
