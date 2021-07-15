
package com.cognizant.pensionmanagement.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PensionDetails {

	@Id
	@Column
	@NotNull(message = "must not be null")
	private Long aadharNumber;
	
	@Column
	@NotNull(message = "must not be null")
	private String name;
	
	@Column
	@NotNull(message = "must not be null")
	private  Date dateOfBirth;
	
	@Column
	@NotNull(message = "must not be null")
	private String pan;
	
	@Column
	@NotEmpty(message = "must not be empty")
	private String selfOrFamilyPension;
	
	@Column
	@NotNull(message = "must not be null")
	private Double salary;
	
	@Column
	@NotNull(message = "must not be null")
	private Double allowances;
	
	@Column
	@NotNull(message = "must not be null")
	private Integer accountNumber;
	
	@Column
	@NotNull(message = "must not be null")
	private String bankName;
	
	@Column
	@NotNull(message = "must not be null")
	private String bankType;
	
}
