package com.lfb.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lfb.persist.Customer;
import com.lfb.service.CustomerService;


@Controller
public class JPAPersist {

	@Autowired
	CustomerService service;
	
	@RequestMapping(value="/save", method=RequestMethod.GET)
	@ResponseBody
	public String save(){
		Customer c = new Customer("li", "fenbo");
		service.saveCustomer(c);
		
		return "ok";
		
	}
	
	@ResponseBody
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public String read(){
		Customer c = service.readCustomer("fenbo");
		if(c!=null){
			return c.toString();
		}else{
			return "not found";
		}
	}
	
}
