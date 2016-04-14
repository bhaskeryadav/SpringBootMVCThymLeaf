package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pojo.Emp;

@Controller
public class HomePage {

	@RequestMapping("/app")
	public String hello(){
		return "index";
	}

	@RequestMapping("/addPage")
	public String addPage(Model model){
		model.addAttribute("emp",new Emp());
		return "add";
	}
	
	@RequestMapping("/search")
	public String search(Model model){
		return "search";
	}
}
