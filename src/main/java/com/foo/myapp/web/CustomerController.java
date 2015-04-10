package com.foo.myapp.web;

import java.util.ArrayList;
import java.util.List;

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
    public List<Customer> listCustomers() {
    	List<Customer> retval = new ArrayList<>();
    	repository.findAll().forEach(customer -> retval.add(customer));
    	System.out.println(retval);
    	return retval;
    }

}