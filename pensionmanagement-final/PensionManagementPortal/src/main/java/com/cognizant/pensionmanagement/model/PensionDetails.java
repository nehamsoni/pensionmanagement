package com.cognizant.pensionmanagement.model;

import java.text.ParseException;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class PensionDetails {
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public Long getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(Long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Double getAllowances() {
		return allowances;
	}

	public void setAllowances(Double allowances) {
		this.allowances = allowances;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankType() {
		return bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getSelfOrFamilyPension() {
		return selfOrFamilyPension;
	}

	public void setSelfOrFamilyPension(String selfOrFamilyPension) {
		this.selfOrFamilyPension = selfOrFamilyPension;
	}

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
	@Min(1)
	private Long aadharNumber;
	
	@NotNull(message = "Please enter salary")
	@Min(1)
	private Double salary;
	@NotNull(message = "Please enter allowances")
	@Min(1)
	private Double allowances;
	
	@NotNull(message = "Please choose bankname")
	private String bankName;
	@NotNull(message = "Please choose banktype")
	private String bankType;
	@NotNull(message = "Please enter account number")
	@Min(1)
	private Integer accountNumber;
	
	@NotNull(message = "Please select any 1 pension type")
	private String selfOrFamilyPension;


}
