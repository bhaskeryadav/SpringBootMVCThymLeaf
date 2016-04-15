package com.example.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pojo.LoginBean;
import com.example.propertyEditor.MarksToGradeEditor;

@Controller
@RequestMapping("/login")
public class LoginConroller {


	/* we can add BindingResult as a parameter in the method to get the errors while converting
	 * form data to beans but somehow it slows down the application
	 * */
	@RequestMapping("/register")
	public String register(@Valid @ModelAttribute LoginBean logBean){
		System.out.println(logBean.getMyList().size());
		return "view";
	}
	
	/*
	 * This method is executed per controller before binding.
	 * Here we can filter, format the input data
	 */
	@InitBinder
	public void addBinder(WebDataBinder bind){
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		bind.registerCustomEditor(Date.class, "date",new CustomDateEditor(sdf, false));
		bind.registerCustomEditor(String.class,"grade", new MarksToGradeEditor());
	}
	
	@ExceptionHandler(Exception.class)
	public void handleException(Exception e){
		System.out.println(e.getMessage());
	}
	
}
