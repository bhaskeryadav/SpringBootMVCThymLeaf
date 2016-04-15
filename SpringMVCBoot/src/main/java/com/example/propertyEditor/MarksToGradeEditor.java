package com.example.propertyEditor;

import java.beans.PropertyEditorSupport;

public class MarksToGradeEditor extends PropertyEditorSupport{

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if(text.contains("a")){
			throw new IllegalArgumentException();
		}
		Integer mark=Integer.valueOf(text);
		if(mark>40){
			setValue("pass");
		}else{
			setValue("Fail");
		}
	}
}
