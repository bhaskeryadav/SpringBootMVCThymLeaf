package com.example.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.pojo.Emp;

@Service
public class EmpServices {

	List<Emp> li=new ArrayList<>();
	
	public List<Emp> getList(){
		return li;
	}

	public void addEmp(Emp e) {
		li.add(e);
	}

	public Emp getEmp(Integer id) {
		return li.stream().filter(e->e.getId().equals(id)).findFirst().orElse(null);
	}
}
