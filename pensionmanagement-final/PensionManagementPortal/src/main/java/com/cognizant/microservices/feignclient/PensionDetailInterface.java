package com.cognizant.microservices.feignclient;




import javax.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.cognizant.pensionmanagement.model.PensionDetails;

@ComponentScan
@FeignClient(url="http://localhost:8082",name="pensionDetails")
public interface PensionDetailInterface {
	
	
	@PutMapping("/PensionDetailsByAadhar")
	public PensionDetails updatePensionerDetails(@RequestBody PensionDetails pensioner);
	
	@PostMapping("/PensionDetailsByAadhar")
	public PensionDetails addPensioner(@RequestBody  PensionDetails pensioner);
	
	@DeleteMapping("/{id}")
	public PensionDetails deletePensionerDetails(@PathVariable("id") Long id );
	

}
