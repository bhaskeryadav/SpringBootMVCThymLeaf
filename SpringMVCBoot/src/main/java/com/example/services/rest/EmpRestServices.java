package com.example.services.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.Emp;

@RestController
public class EmpRestServices {

	/*
	 * produces can be used for declaring the return type of data instead of 
	 * contentnegotiation 
	 */
	@RequestMapping(value="/emp1",produces={MediaType.APPLICATION_JSON_VALUE},method=RequestMethod.GET)
	public Emp getEmpJson(){
		Emp e=new Emp();
		e.setId(1);
		e.setName("Bhasker");
		return e;
	}
	
	@RequestMapping(value="/emp1",produces={MediaType.TEXT_HTML_VALUE},method=RequestMethod.POST)
	public String getEmpXml(){
		return "<html><head>Payge</head><body>Bhasker</body></html>";
	}
}
