package com.cognizant.pensionmanagement.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "PensionDetails Not Found")
public class PensionDetailsNotFoundException extends Exception {

}