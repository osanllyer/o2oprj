package com.lfb.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lfb.persist.Customer;
import com.lfb.persist.CustomerRepository;


@Service
public class CustomerService {

	@Resource
	private CustomerRepository customerRepository;
	
	@Transactional
	public void saveCustomer(Customer customer){
		customerRepository.save(customer);
	}
	
	@Transactional(readOnly=true)
	public Customer readCustomer(String lastName){
		List<Customer> l = customerRepository.findByLastName(lastName);
		if( l != null && !l.isEmpty() ){
			return customerRepository.findByLastName(lastName).get(0);	
		}else{
			return null;
		}
		
	}
	
}
