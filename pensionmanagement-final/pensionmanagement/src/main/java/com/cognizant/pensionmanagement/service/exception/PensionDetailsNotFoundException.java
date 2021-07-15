package com.cognizant.pensionmanagement.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "PensionDetails Not Found")
public class PensionDetailsNotFoundException extends RuntimeException {
	
	public PensionDetailsNotFoundException(String message) {

        super(message);
    }

}