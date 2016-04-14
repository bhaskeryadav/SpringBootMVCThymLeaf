package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.pojo.Emp;
import com.example.services.EmpServices;

@Controller
@RequestMapping("/emp")
public class EmployeController {

	@Autowired
	private EmpServices empSer;
	
	@RequestMapping("/list")
	public ModelAndView getEmpList(){
		ModelAndView mv=new ModelAndView("list");
		mv.addObject("list", empSer.getList());
		return mv;
	}
	
	@RequestMapping(value="/addEmp",method=RequestMethod.POST)
	public String addEmp(@ModelAttribute Emp e,Model model){
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
}
