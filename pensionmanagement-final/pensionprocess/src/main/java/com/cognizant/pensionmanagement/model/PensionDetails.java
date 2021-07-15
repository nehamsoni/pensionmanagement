
package com.cognizant.pensionmanagement.model;



import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
	
	
	@NotNull(message = "must not be null")
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
