package com.techelevator.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCSiteDAO extends SiteDAO{

	private JdbcTemplate jdbctemplate;
	
	
	public JDBCSiteDAO(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
		
	}

	@Override
	public ArrayList<Site> getAllSites() {
		ArrayList<Site> sites = new ArrayList<>();
		
		String sqlGetAllSites = "SELECT site.site_id, campground_id, site_number, max_occupancy, accessible, max_rv_length, utilities FROM site "
								+ "JOIN reservation ON site.site_id = reservation.site_id";
		SqlRowSet results = jdbctemplate.queryForRowSet(sqlGetAllSites);
		while(results.next()) {
			Site site = mapToSiteRow(results);
			sites.add(site);
		}
		return sites;
	}
	
	public ArrayList<Site> getSitesByCampsite(int campsiteChoiceInt, LocalDate arrivalChoiceDate, LocalDate departureChoiceDate) {
		ArrayList<Site> sites = new ArrayList<>();
		
		String sqlSitesByCampsite = "SELECT * FROM site WHERE campground_id = ? AND site_id "
									+ "NOT IN (SELECT site_id FROM reservation "
									+ "WHERE (? >=  from_date and ? <= to_date) OR (? >= from_date and ? <= to_date))";
		SqlRowSet results = jdbctemplate.queryForRowSet(sqlSitesByCampsite, campsiteChoiceInt, arrivalChoiceDate, arrivalChoiceDate, departureChoiceDate, departureChoiceDate);
		while(results.next()) {
			Site site = mapToSiteRow(results);
			sites.add(site);
		}
		return sites;	
		
	}
	
	private Site mapToSiteRow(SqlRowSet results) {
		Site site = new Site();
		site.setSite_id(results.getLong("site_id"));
		site.setCamp_id(results.getLong("campground_id"));
		site.setSite_number(results.getLong("site_number"));
		site.setMax_occupency(results.getLong("max_occupancy"));
		site.setAccessible(results.getBoolean("accessible"));
		site.setMax_rv_length(results.getLong("max_rv_length"));
		site.setUtilities(results.getBoolean("utilities"));
		return site;
	}
	
	private Site mapToSiteAvailable(SqlRowSet results) {
		Site site = new Site();
		site.setSite_id(results.getLong("site_id"));
		site.setMax_occupency(results.getLong("max_occupancy"));
		site.setMax_rv_length(results.getLong("max_rv_length"));
		site.setUtilities(results.getBoolean("utilities"));
		return site;
	}


	public ArrayList<Site> getAllReservationCampsite(long park_id, LocalDate arrivalChoiceDate,LocalDate departureChoiceDate) {
ArrayList<Site> sites = new ArrayList<>();
		
		String sqlSitesByCampsite = "SELECT campground.name, site.site_number, site.max_occupancy, site.max_rv_length, site.utilities, campground.daily_fee "
									+ "FROM site "
									+ "JOIN campground On campground.campground_id = site.campground_id "
									+ "WHERE campground.park_id = ? "
									+ "AND site.site_id "
									+ "NOT IN (SELECT site_id FROM reservation "
									+ "WHERE (? BETWEEN from_date and to_date) OR (? BETWEEN from_date and to_date))";
		SqlRowSet results = jdbctemplate.queryForRowSet(sqlSitesByCampsite, park_id, arrivalChoiceDate, departureChoiceDate);
		while(results.next()) {
			Site site = mapToSiteRow(results);
			sites.add(site);
		}
		return sites;	
	}

	
	

}
