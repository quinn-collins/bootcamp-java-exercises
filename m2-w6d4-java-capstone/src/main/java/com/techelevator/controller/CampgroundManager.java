package com.techelevator.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import com.techelevator.model.Campground;
import com.techelevator.model.JDBCCampgroundDAO;
import com.techelevator.model.JDBCParkDAO;
import com.techelevator.model.JDBCReservationDAO;
import com.techelevator.model.JDBCSiteDAO;
import com.techelevator.model.Park;
import com.techelevator.model.Site;

public class CampgroundManager {
	private JDBCParkDAO JDBCpark;
	private JDBCCampgroundDAO JDBCcampground;
	private JDBCSiteDAO JDBCsite;
	private JDBCReservationDAO JDBCreservation;
	private ArrayList<Park> parks;
	private ArrayList<Campground> campgrounds;
	private ArrayList<Site> sites;
	
	public CampgroundManager(JDBCParkDAO JDBCpark, JDBCCampgroundDAO JDBCcampground, JDBCSiteDAO JDBCsite, JDBCReservationDAO JDBCreservation) {
		this.JDBCpark = JDBCpark;
		this.JDBCcampground = JDBCcampground;
		this.JDBCsite = JDBCsite;
		this.JDBCreservation = JDBCreservation;
	}

	public ArrayList<Park> getAllParks() {
		parks = JDBCpark.getAllParks();
		return parks;
	}
	
	public ArrayList<Campground> getAllCampgrounds() {
		campgrounds = JDBCcampground.getAllCampgrounds();
		return campgrounds;
	}
	
	
	public ArrayList<Site> getReservationsByCampsite(int campsiteChoiceInt, LocalDate arrivalChoiceDate, LocalDate departureChoiceDate) {
		sites = JDBCsite.getSitesByCampsite(campsiteChoiceInt, arrivalChoiceDate, departureChoiceDate);
		return sites;
	}
	public int getReservationNameAndSite(int siteChoiceInt, String reservationName, LocalDate arrivalChoiceDate, LocalDate departureChoiceDate) {
		int confirmationId = JDBCreservation.getConfirmationId(siteChoiceInt, reservationName, arrivalChoiceDate, departureChoiceDate);
		return confirmationId;
	}

	public ArrayList<Site> getReservationsParkWide(long park_id, LocalDate arrivalChoiceDate, LocalDate departureChoiceDate) {
		sites = JDBCsite.getAllReservationCampsite(park_id, arrivalChoiceDate, departureChoiceDate);
		return sites;
	}
	
	
	
	
	
	
	
	
	
}