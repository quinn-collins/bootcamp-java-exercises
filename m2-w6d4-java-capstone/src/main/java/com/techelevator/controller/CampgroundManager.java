package com.techelevator.controller;

import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.model.Campground;
import com.techelevator.model.Database;
import com.techelevator.model.JDBCCampgroundDAO;
import com.techelevator.model.JDBCParkDAO;
import com.techelevator.model.Park;
import com.techelevator.view.CampgroundCLI;
import com.techelevator.view.Menu;



public class CampgroundManager {
	private Database database;
	private JdbcTemplate jdbctemplate;
	
	private JDBCParkDAO JDBCpark;
	private ArrayList<Park> parks;
	
	private CampgroundCLI user;
	private Menu menu;
	
	private JDBCCampgroundDAO JDBCcampground;
	private ArrayList<Campground> campgrounds;
	
	
	public void run() {
		database = new Database();
		jdbctemplate = new JdbcTemplate();
		jdbctemplate = database.getJdbcTemplate();
		
		
		JDBCpark = new JDBCParkDAO(jdbctemplate);
		parks = JDBCpark.getAllParks();
		
		JDBCcampground = new JDBCCampgroundDAO(jdbctemplate);
		campgrounds = JDBCcampground.getAllCampgrounds();
		
		menu = new Menu(System.in, System.out);
		user = new CampgroundCLI(menu);
		user.run(parks, campgrounds);
		
		
		
	}


	
	
	
	
	
	
	
	
	
}
