package com.cognizant.pensionmanagement.model;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PensionAmountDetails {

	@NotNull(message = "must not be null")
	private Long aadharNumber;
	
	@NotNull(message = "must not be null")
	private String name;
	
	@NotNull(message = "must not be null")
	private Double pensionamount;
	
	@NotNull(message = "must not be null")
	private Double bankservicecharge;

	

	
}

