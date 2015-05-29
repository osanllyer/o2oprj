package com.lfb.persist;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lfb.web.conf.AppConfig;


public class Main {

	public static void main(String[] args){
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		CustomerRepository repo = context.getBean(CustomerRepository.class);
		repo.save(new Customer("a", "b"));
	}
	
}
