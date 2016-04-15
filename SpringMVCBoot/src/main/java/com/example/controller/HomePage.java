package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

import com.example.pojo.Emp;
import com.example.pojo.LoginBean;
import com.example.services.LoginService;

@Controller
public class HomePage {

	@Autowired
	private LoginService logSer;
	
	@Autowired
	private ThymeleafViewResolver thymleafViewResolver;

	/*
	 * Can return string or ModelAndView object
	 */
	@RequestMapping("/app")
	public String hello(){
		return "index";
	}

	@RequestMapping("/addPage")
	public String addPage(Model model){
		
		thymleafViewResolver.getTemplateEngine().getTemplateResolvers().forEach(e->{
			System.out.println((e).getClass());
		});
		
		model.addAttribute("emp",new Emp());
		return "add";
		//return "forward:/emp/addEmp";
	}
	
	@RequestMapping("/search")
	public String search(Model model){
		return "search";
	}
	
	@RequestMapping("/register")
	public String register(Model mod){
		mod.addAttribute("logBean", new LoginBean());
		mod.addAttribute("serList",logSer.getListOp());
		return "register";
	}
}
