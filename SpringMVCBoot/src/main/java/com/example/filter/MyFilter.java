package com.example.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.springframework.web.filter.GenericFilterBean;

@WebFilter(filterName="abc",urlPatterns="/*")
public class MyFilter extends GenericFilterBean {


	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		try{
			System.out.println("before");
			arg2.doFilter(arg0, arg1);
			System.out.println("after");
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
