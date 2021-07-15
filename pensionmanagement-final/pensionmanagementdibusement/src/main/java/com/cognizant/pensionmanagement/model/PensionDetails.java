
package com.cognizant.pensionmanagement.model;



import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Data
public class PensionDetails {

	
	
	@NotNull(message = "must not be null")
	private Long aadharNumber;
	
	
	@NotNull(message = "must not be null")
	private String name;
	
	
	@NotNull(message = "Please enter your DOB")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past(message = "That's impossible.Please enter a valid DOB")
	private  Date dateOfBirth;
	
	
	@NotNull(message = "must not be null")
	private String pan;
	
	
	@NotEmpty(message = "must not be empty")
	private String selfOrFamilyPension;
	
	
	@NotNull(message = "must not be null")
	private Double salary;
	
	
	@NotNull(message = "must not be null")
	private Double allowances;
	
	
	@NotNull(message = "must not be null")
	private Integer accountNumber;
	
	
	@NotNull(message = "must not be null")
	private String bankName;
	
	
	@NotNull(message = "must not be null")
	private String bankType;
	
}
