package com.example;

import java.util.Locale;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

public class JsonViewReslover implements ViewResolver{

	@Override
	public View resolveViewName(String arg0, Locale arg1) throws Exception {
		MappingJackson2JsonView view=new MappingJackson2JsonView();
		view.setPrettyPrint(true);
		return view;
	}

}
