package com.example.services;

import java.util.ArrayList;
import java.util.Iterator;
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
		for (Iterator iterator = li.iterator(); iterator.hasNext();) {
			Emp type = (Emp) iterator.next();
			if(type.getId().equals(id)){
				return type;
			}
		}
		return null;
	}
}
