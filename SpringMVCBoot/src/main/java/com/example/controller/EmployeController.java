package com.example.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.pojo.Emp;
import com.example.services.EmpServices;
import com.example.services.TestService;

@Controller
@RequestMapping("/emp")
public class EmployeController {

	@Autowired
	private EmpServices empSer;
	
	@Autowired
	private ApplicationContext cont;

	
	@RequestMapping("/list")
	public ModelAndView getEmpList(){
		ModelAndView mv=new ModelAndView("list");
		TestService tc=cont.getBean(TestService.class);
		tc.sayHello();
		mv.addObject("list", empSer.getList());
		return mv;
	}
	
	@RequestMapping(value="/addEmp",method=RequestMethod.POST)
	public String addEmp(@Valid @ModelAttribute Emp e,Model model) throws Exception{
		if(e.getId()==-1){
			throw new Exception();
		}
		empSer.addEmp(e);
		model.addAttribute("emp",e);
		return "success";
	}
	
	@RequestMapping("/getEmp/{id}")
	public ModelAndView getEmp(@PathVariable Integer id){
		ModelAndView mv=new ModelAndView("success");
		mv.addObject("emp",empSer.getEmp(id));
		return mv;
	}
	
	@RequestMapping("/test")
	public String testReq(@RequestParam String name){
		System.out.println(name);
		return "abc";
	}
	
}
