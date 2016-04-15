package com.example.pojo.validation.classImplement;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.pojo.validation.annotation.IsValidEmp;

public class ValidName implements ConstraintValidator<IsValidEmp, String> {

	@Override
	public void initialize(IsValidEmp arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext arg1) {
		if(value.contains("a")){
			return false;
		}
		return true;
	}

}
