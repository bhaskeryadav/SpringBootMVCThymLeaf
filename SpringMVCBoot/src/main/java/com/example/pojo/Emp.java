package com.example.pojo;

import javax.xml.bind.annotation.XmlRootElement;

import com.example.pojo.validation.annotation.IsValidEmp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Emp {

	//@IsValidEmp
	private String name;
	
	private Integer id;
	
}
