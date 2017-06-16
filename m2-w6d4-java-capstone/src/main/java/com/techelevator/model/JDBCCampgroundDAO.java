package com.techelevator.model;

import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCCampgroundDAO extends CampgroundDAO {
	private JdbcTemplate jdbctemplate;

	public JDBCCampgroundDAO(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	@Override
	public ArrayList<Campground> getAllCampgrounds() {
		ArrayList<Campground> campgrounds = new ArrayList<>();
		Campground campground = new Campground();
		String sqlGetAllCampgrounds = "SELECT campground_id, park_id, name, open_from_mm, open_to_mm, daily_fee FROM campground";
		SqlRowSet results = jdbctemplate.queryForRowSet(sqlGetAllCampgrounds);
		while(results.next()) {
			campground = mapToRowCampground(results);
			campgrounds.add(campground);
		}
		return campgrounds;
		
	}

	private Campground mapToRowCampground(SqlRowSet results) {
		Campground campground = new Campground();
		campground.setCampground_id(results.getLong("campground_id"));
		campground.setPark_id(results.getLong("park_id"));
		campground.setName(results.getString("name"));
		campground.setOpen_from_mm(results.getString("open_from_mm"));
		campground.setOpen_to_mm(results.getString("open_to_mm"));
		campground.setDaily_fee(results.getDouble("daily_fee"));
		return campground;
	}

}
