package com.cognizant.pensionmanagement.controller;

import javax.validation.Valid;

import org.bouncycastle.operator.InputAEADDecryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.microservices.feignclient.PensionManagementProxy;
import com.cognizant.pensionmanagement.app.service.PensionProcessServiceDelegate;
import com.cognizant.pensionmanagement.model.AuthToken;
import com.cognizant.pensionmanagement.model.LoginUser;
import com.cognizant.pensionmanagement.model.PensionAmountDetails;
import com.cognizant.pensionmanagement.model.PensionDetails;
import com.cognizant.pensionmanagement.model.PensionerInput;


@Controller
public class PensionerController {
	
	@Autowired
	PensionManagementProxy proxy;
	
	@Autowired
	PensionProcessServiceDelegate service;
	
	private  AuthToken auth =null;
	private String token =null;

	private PensionDetails pensionerdetails;
	@GetMapping("/home")
	public String home(){
		
		return "home";
	}
	

	
	@GetMapping("/signin")
	public String signin(@ModelAttribute("authorizationinput") LoginUser login){
		
		return "signin";
	}
	
	@GetMapping("/signup")
	public String signup(){
		
		return "signup";
	}
	
	
	@PostMapping("/authorization")
	public String login(@ModelAttribute("authorizationinput") LoginUser login ,BindingResult result,ModelMap map) {
		
		if(result.hasErrors())
		{
			return "home";
		}
	    auth = service.register(login);
	    token = service.register();
		return "action";
	}
	
	@GetMapping("/add")
	public String add(@ModelAttribute("pensiondetails") PensionDetails pensiondetails){
		
		return "add";
	}
	
	@GetMapping("/update")
	public String update(@ModelAttribute("pensiondetails") PensionDetails pensiondetails){
		
		return "update";
	}
	
	@PostMapping("/updatepensiondetails")
	public String updatepensionerform(@Valid @ModelAttribute("pensiondetails") PensionDetails pensiondetails,BindingResult result,ModelMap map)
	{
		if(result.hasErrors())
		{
			return "add";
		}
		//System.out.print(pensiondetails.getDateOfBirth());
		service.updatepensioner(pensiondetails);
		map.put("pensiondetails",pensiondetails);
		return "successfullupdate";
	
		
	}
	
	
	
	@PostMapping("/pensiondetails")
	public String addpensionerform(@Valid @ModelAttribute("pensiondetails") PensionDetails pensiondetails,BindingResult result,ModelMap map)
	{
		if(result.hasErrors())
		{
			return "add";
		}
		//System.out.print(pensiondetails.getDateOfBirth());
		service.addpensioner(pensiondetails);
		map.put("pensiondetails",pensiondetails);
		return "successfulladd";
	
		
	}
	
	@GetMapping("/delete")
	public String delete(){
		
		return "delete";
	}
	
	@GetMapping("/token")
	@ResponseBody
	public String Temp() {
	    return token;
	}
	
	@GetMapping("/pensionerform")
	public String pensionerform(@ModelAttribute("pensionerinput") PensionerInput pensionerinput)
	{
		return "pensionerdetail";
		
	}
	
	
	
	
	
	@PostMapping("/entereddetails")
	public String showpensionerform(@Valid @ModelAttribute("pensionerinput") PensionerInput pensionerinput,BindingResult result,ModelMap map)
	{
		if(result.hasErrors())
		{
			return "pensionerdetail";
		}
		
		PensionAmountDetails pensionerinput1 = proxy.getPensionerdetail(pensionerinput);
		//System.out.println(pensionerinput1.getAadharNumber());
		if(pensionerinput1!=null)
		{
		map.put("pensionerinput", pensionerinput1);
		return "pensionerOutput";
		}
		return "Invalid";
		
	}
	
	
}
