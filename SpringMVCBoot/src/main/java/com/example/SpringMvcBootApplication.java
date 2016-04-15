package com.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.TemplateResolver;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;

@EnableWebMvc
@SpringBootApplication
public class SpringMvcBootApplication  extends WebMvcConfigurerAdapter{

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcBootApplication.class, args);
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource rbs = new ResourceBundleMessageSource();
		rbs.setBasename("I18/msg");
		return rbs;
	}
	
	@Bean
	public ViewResolver contentResolver(ContentNegotiationManager cnm) {
		ContentNegotiatingViewResolver cnvr = new ContentNegotiatingViewResolver();
		cnvr.setContentNegotiationManager(cnm);
		List<ViewResolver> vr = new ArrayList<>();
		vr.add(new Jaxb2MarchallingXMLview());
		vr.add(new JsonViewReslover());
		vr.add(thymleafViewResolver());
		cnvr.setViewResolvers(vr);
		return cnvr;
	}

	@Bean
	public TemplateResolver thymleafTemplateResolver() {
		TemplateResolver vr = new SpringResourceTemplateResolver();
		vr.setPrefix("classpath:/templates/");
		vr.setSuffix(".html");
		//vr.setTemplateMode("HTML5");
		return vr;
	}

	@Bean
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine te = new SpringTemplateEngine();
		te.setTemplateResolver(thymleafTemplateResolver());
		return te;
	}

	@Bean
	public ThymeleafViewResolver thymleafViewResolver() {
		ThymeleafViewResolver vr = new ThymeleafViewResolver();
		vr.setTemplateEngine(templateEngine());
		return vr;
	}
}
