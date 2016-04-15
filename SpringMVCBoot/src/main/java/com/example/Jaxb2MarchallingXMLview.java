package com.example;

import java.util.Locale;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.xml.MarshallingView;

import com.example.pojo.Emp;

public class Jaxb2MarchallingXMLview implements ViewResolver {

	@Override
	public View resolveViewName(String arg0, Locale arg1) throws Exception {
		Jaxb2Marshaller jb=new Jaxb2Marshaller();
		jb.setClassesToBeBound(Emp.class);
		MarshallingView mv=new MarshallingView();
		mv.setMarshaller(jb);
		return mv;
	}

}
