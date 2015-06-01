package com.lfb.web.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lfb.persist.Customer;
import com.lfb.service.CustomerService;


@RestController
public class JPAPersist {

	@Resource
	CustomerService service;
	
	@RequestMapping(value="/save", method=RequestMethod.GET)
	public String save(){
		Customer c = new Customer("li", "fenbo");
		service.saveCustomer(c);
		
		return "ok";
		
	}
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public String read(){
		Customer c = service.readCustomer("fenbo");
		if(c!=null){
			return c.toString();
		}else{
			return "not found";
		}
	}
	
	@RequestMapping(value="/readall", method=RequestMethod.GET)
	public String readAll(){
		
		List<Customer> cl = service.readAll();
		return String.valueOf(cl.size());
	}
	
	@RequestMapping(value="/readone/{id}", method=RequestMethod.GET)
	public String readOne(@PathVariable long id){
		
		Customer c = service.readOne(id);
		System.out.println("id:" + id);
		return c != null ? c.toString() : "not found";
	}
	
}
