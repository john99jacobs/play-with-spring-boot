package com.foo.myapp;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.foo.myapp.domain.Customer;
import com.foo.myapp.repository.CustomerRepository;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application implements CommandLineRunner {
	
	@Autowired
	private CustomerRepository repository;

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        System.out.println("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }

	@Override
	public void run(String... args) throws Exception {
        // boy we have awesome customers
        repository.save(new Customer("Jason", "Goth"));
        repository.save(new Customer("Micah", "Blalock"));
        repository.save(new Customer("Dustin", "Talk"));
        repository.save(new Customer("John", "Shields"));
	}
}