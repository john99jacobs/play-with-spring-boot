package com.foo.myapp;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class ApplicationConfig {
	@Bean
	public DataSource dataSource() {
		final HikariDataSource ds = new HikariDataSource();
		ds.setMaximumPoolSize(10);
		ds.setDriverClassName("org.hsqldb.jdbcDriver");
		ds.setJdbcUrl("jdbc:hsqldb:mem:foo");
		ds.setUsername("sa");
		ds.setPassword("");
		return ds;
	}
    

}
