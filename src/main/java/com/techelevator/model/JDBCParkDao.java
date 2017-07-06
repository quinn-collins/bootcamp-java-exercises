package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
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
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllParks);
		while(results.next()){
			Park park = mapRowToPark(results);
			parks.add(park);
		}
		return parks;
	}
	
	private Park mapRowToPark(SqlRowSet results){
		Park park;
		park = new Park();
		
		park.setParkCode(results.getString("parkCode"));
		park.setParkName(results.getString("parkName"));
		park.setState(results.getString("state"));
		park.setAcreage(results.getInt("acreage"));
		park.setElevationInFeet(results.getInt("elevationInFeet"));
		park.setMilesOfTrail(results.getDouble("milesOfTrail"));
		park.setNumberOfCampsites(results.getInt("numberOfCampsites"));
		park.setClimate(results.getString("climate"));
		park.setYearFounded(results.getInt("yearFounded"));
		park.setAnnualVisitorCount(results.getInt("annualVisitorCount"));
		park.setInspirationalQuote(results.getString("inspirationalQuote"));
		park.setInspirationalQuoteSource(results.getString("inspirationalQuoteSource"));
		park.setParkDescription(results.getString("parkDescription"));
		park.setEntryFee(results.getInt("entryFee"));
		park.setNumberOfAnimalSpecies(results.getInt("numberOfAnimalSpecies"));
		
		return park;
	}

	@Override
	public Park getParkByParkCode(String parkCode) {
		Park park = null;
		String sqlGetParkByParkCode = "SELECT * FROM park WHERE parkCode = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetParkByParkCode, parkCode);
		if(results.next()){
			park = mapRowToPark(results);
		}
		return park;
	}

}
