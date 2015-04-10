package com.foo.myapp;

import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.foo.myapp.domain.Customer;
import com.foo.myapp.repository.CustomerRepository;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application implements CommandLineRunner {
	
	@Autowired
	private CustomerRepository repository;

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        System.out.println("Let's inspect some beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
        	if ("dataSource".equals(beanName)) {
        		Object ds = ctx.getBean(beanName);
        		System.out.println("dataSource bean is type [" + ds.getClass().getName() + "]");
        	}
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