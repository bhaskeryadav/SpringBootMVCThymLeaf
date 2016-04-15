package com.example.pojo;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import lombok.Data;

@Data
public class LoginBean {
	
	@Size(min=3,max=30,message="size exception")
	private String userName;
	
	@NotEmpty
	private String password;
	
	@DateTimeFormat(pattern="dd-MM-yyyy")
	@Past
	private Date date;
	
	@NotEmpty
	private List<String> myList;
	
	@NumberFormat
	private Long id;
	
	@NotEmpty
	private String grade;
	
}
