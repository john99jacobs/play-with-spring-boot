package com.foo.myapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.foo.myapp.domain.Customer;
import com.foo.myapp.repository.CustomerRepository;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerRepository repository;

    @RequestMapping("/customers")
    @ResponseBody
    public Iterable<Customer> listCustomers() {
    	return repository.findAll();
    }
}