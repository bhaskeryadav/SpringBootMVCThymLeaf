package com.example.pojo.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.example.pojo.validation.classImplement.ValidName;

@Constraint(validatedBy = {ValidName.class})
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IsValidEmp {

	String message() default "Invalid ";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default{};
}
