package com.foo.myapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.foo.myapp.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}