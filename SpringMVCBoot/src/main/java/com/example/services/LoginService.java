package com.example.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	List<String> listOp=new ArrayList<>(5);
	
	public List<String> getListOp(){
		listOp.add("10");
		listOp.add("20");
		listOp.add("30");
		listOp.add("40");
		listOp.add("50");
		return listOp;
	}
	
}
