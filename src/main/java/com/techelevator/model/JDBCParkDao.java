package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
@Component
public class JDBCParkDao implements ParkDao {
	
	private JdbcTemplate jdbcTemplate;
	@Autowired
	public JDBCParkDao(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
			
		
	}

	@Override
	public List<Park> getAllParks() {
		ArrayList<Park> parks = new ArrayList<Park>();
		String sqlGetAllParks="SELECT * FROM park";
		
		SqlRowSet results = jdbcTemplate.query
		return null;
	}

}
