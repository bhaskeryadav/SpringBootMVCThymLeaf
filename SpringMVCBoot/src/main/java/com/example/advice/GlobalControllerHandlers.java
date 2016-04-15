package com.example.advice;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice(basePackages="com.example.controller")
public class GlobalControllerHandlers {

	
	@Autowired
	private MessageSource messageSource;
	
	@ModelAttribute
	public void setHeader(Model model){
		model.addAttribute("head", "Employee App");
		model.addAttribute("welcomeMsg",messageSource.getMessage("abc", null, "default",Locale.GERMAN));
	}
	
	@ExceptionHandler(Exception.class)
	public void handleExceptionGlobally(Exception e){
		System.out.println("----------Global hadler start--------------");
		System.out.println(e.getMessage());
		System.out.println("----------Global hadler end--------------");
	}
}
