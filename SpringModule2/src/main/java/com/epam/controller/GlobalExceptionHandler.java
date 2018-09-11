package com.epam.controller;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public String handleGenericException(Exception theException, Model model) {
		System.out.println("---> Exception : "+theException.getMessage());
		theException.printStackTrace();
		model.addAttribute("exception", theException.getMessage()+".<br>"+theException.getCause().getMessage());
		return "exception";
	}
}