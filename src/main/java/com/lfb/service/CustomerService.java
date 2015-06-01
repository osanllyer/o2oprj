package com.lfb.service;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.lfb.persist.Customer;
import com.lfb.persist.CustomerRepository;


@Service
public class CustomerService {

	@Resource
	private CustomerRepository customerRepository;
	
	public void saveCustomer(Customer customer){
		Customer c = customerRepository.save(customer);
		System.out.println(c.toString());
	}
	
	@Transactional(readOnly=true)
	public Customer readCustomer(String lastName){
		List<Customer> l = customerRepository.findByLastname(lastName);
		System.out.println(l.size());
		if( l != null && !l.isEmpty() ){
			return customerRepository.findByLastname(lastName).get(0);	
		}else{
			return null;
		}
		
	}
	
	public Customer readOne(long id){
		return customerRepository.findOne(id);
	}

	public List<Customer> readAll() {

		List<Customer> l = Lists.newArrayList();
		
		Iterable<Customer> it = customerRepository.findAll();
		
		Iterator<Customer> iter = it.iterator();
		
		while(iter.hasNext()){
			l.add(iter.next());
		}
		
		return l;
	}
	
}
