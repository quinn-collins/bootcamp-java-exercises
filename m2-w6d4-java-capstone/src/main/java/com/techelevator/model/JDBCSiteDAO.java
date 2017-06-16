package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCSiteDAO extends SiteDAO{

	private JdbcTemplate jdbctemplate;
	private String whereQuery;
	
	public JDBCSiteDAO(JdbcTemplate jdbctemplate, String whereQuery) {
		this.jdbctemplate = jdbctemplate;
		this.whereQuery = whereQuery;
	}

	@Override
	public ArrayList<Site> getAllSites() {
		ArrayList<Site> sites = new ArrayList<>();
		
		String sqlGetAllSites = "SELECT site.site_id, campground_id, site_number, max_occupancy, accessible, max_rv_length, utilities FROM site "
								+ "JOIN reservation ON site.site_id = reservation.site_id"
								+ whereQuery;
		SqlRowSet results = jdbctemplate.queryForRowSet(sqlGetAllSites);
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
	
	

}
