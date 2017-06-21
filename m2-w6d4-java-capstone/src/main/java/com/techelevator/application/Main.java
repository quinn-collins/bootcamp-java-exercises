package com.techelevator.application;

import org.springframework.jdbc.core.JdbcTemplate;
import com.techelevator.controller.CampgroundManager;
import com.techelevator.model.Database;
import com.techelevator.model.JDBCCampgroundDAO;
import com.techelevator.model.JDBCParkDAO;
import com.techelevator.model.JDBCReservationDAO;
import com.techelevator.model.JDBCSiteDAO;
import com.techelevator.view.CampgroundCLI;
import com.techelevator.view.Menu;

public class Main {
	private static CampgroundManager manager;
	private static Database database;
	private static JdbcTemplate jdbctemplate;
	private static CampgroundCLI user;
	private static Menu menu;
	
	private static JDBCParkDAO JDBCpark;
	private static JDBCCampgroundDAO JDBCcampground;
	private static JDBCSiteDAO JDBCsite;
	private static JDBCReservationDAO JDBCreservation;
	
	
	public static void main(String[] args) {
		database = new Database();
		jdbctemplate = new JdbcTemplate();
		jdbctemplate = database.getJdbcTemplate();
		
		JDBCpark = new JDBCParkDAO(jdbctemplate);
		JDBCcampground = new JDBCCampgroundDAO(jdbctemplate);
		JDBCsite = new JDBCSiteDAO(jdbctemplate);
		JDBCreservation = new JDBCReservationDAO(jdbctemplate);
		
		manager = new CampgroundManager(JDBCpark, JDBCcampground, JDBCsite, JDBCreservation);
		
		
		
		menu = new Menu(System.in, System.out);
		user = new CampgroundCLI(menu, manager);
		
		user.run();
	}
}
