package com.techelevator.model;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class Database {
	private BasicDataSource dataSource;
	private JdbcTemplate jdbctemplate;
	
	public Database() {
		dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/campground");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		
		jdbctemplate = new JdbcTemplate(dataSource);
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbctemplate;
	}
	
//	public void closeDataSource() {
//		FIGURE THIS OUT!
//	}
}
