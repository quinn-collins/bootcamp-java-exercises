package com.techelevator.model;

import java.util.ArrayList;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCParkDAO extends ParkDAO {
	private JdbcTemplate jdbctemplate;
	
	public JDBCParkDAO(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	@Override
	public ArrayList<Park> getAllParks() {
		ArrayList<Park> parks = new ArrayList<>();
		
		String sqlGetAllParks = "SELECT park_id, name, location, establish_date, area, visitors, description FROM park ORDER BY name";
		SqlRowSet results = jdbctemplate.queryForRowSet(sqlGetAllParks);
		while(results.next()) {
			Park park = mapToParkRow(results);
			parks.add(park);
		}
		return parks;
	}
	
	private Park mapToParkRow(SqlRowSet results) {
		Park thePark = new Park();
		thePark.setPark_id(results.getLong("park_id"));
		thePark.setName(results.getString("name"));
		thePark.setLocation(results.getString("location"));
		thePark.setEstablish_date(results.getDate("establish_date").toLocalDate());
		thePark.setArea(results.getLong("area"));
		thePark.setVisitors(results.getLong("visitors"));
		thePark.setDescription(results.getString("description"));
		return thePark;
	}
	
	

}
