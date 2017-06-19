package com.techelevator.view;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;


import com.techelevator.controller.CampgroundManager;
import com.techelevator.model.Campground;
import com.techelevator.model.Park;
import com.techelevator.model.Site;

public class CampgroundCLI {

	private static final String PARK_MENU_OPTIONS_VIEW_CAMPGROUNDS = "View Campgrounds";
	private static final String PARK_MENU_OPTIONS_SEARCH_RESERVATION = "Search for Reservation";
	private static final String PARK_MENU_OPTIONS_RETURN_TO_MAIN_MENU = "Return to Previous Screen";
	private static final String[] PARK_MENU_OPTIONS = { PARK_MENU_OPTIONS_VIEW_CAMPGROUNDS,
			PARK_MENU_OPTIONS_SEARCH_RESERVATION, PARK_MENU_OPTIONS_RETURN_TO_MAIN_MENU };

	private static final String RESERVATION_OPTIONS_SEARCH_RESERVATION = "Search for Available Reservation";
	private static final String RESERVATION_OPTIONS_RETURN_TO_PARK_MENU = "Return to Previous Screen";
	private static final String[] RESERVATION_OPTIONS = { RESERVATION_OPTIONS_SEARCH_RESERVATION,
			RESERVATION_OPTIONS_RETURN_TO_PARK_MENU };
	
	private String siteChoice;
	private String reservationName;
	private Integer campsiteChoice;
	private LocalDate arrivalChoice;
	private LocalDate departureChoice;
	private String[] namesOfParksArray;

	private ArrayList<Park> parks;
	private ArrayList<Campground> campgrounds;
	private ArrayList<Site> sites;
	private Menu menu;
	private CampgroundManager manager;
	

	public CampgroundCLI(Menu menu, CampgroundManager manager) {
		this.menu = menu;
		this.manager = manager;
	}
	public void run() { 																						// Run the CLI
		parks = manager.getAllParks();
		addParkNamesToArray(parks);
		campgrounds = manager.getAllCampgrounds();
		boolean runMainMenu = true;  
		boolean runReservation = true; 
		
		while (runMainMenu) { 																						// RUN MAIN MENU
			boolean runParkMenu = true;  
			String choiceParkMenu = (String) menu.getMainMenuChoiceFromOptions(namesOfParksArray);						// RUN PARK LIST CHOICE
			Park currentPark = null;
			for (Park park : parks) {
				if (park.getName().equals(choiceParkMenu)) { 													
					currentPark = park;	
					menu.printCurrentParkInformation(currentPark);
				}
				else if (choiceParkMenu.equals("Quit")) { 																// QUIT MAIN MENU
					runMainMenu = false;
					System.exit(1); // handle differently?
				}
			}
			while (runParkMenu) {
				String choiceParkMenuOptions = (String) menu.getMainMenuChoiceFromOptions(PARK_MENU_OPTIONS);				// RUN PARK MENU OPTIONS
				if (choiceParkMenuOptions.equals(PARK_MENU_OPTIONS_VIEW_CAMPGROUNDS)) {											// RUN VIEW CAMPGROUNDS
					menu.printAllCampgrounds(currentPark, campgrounds);
					while (runReservation) {
						String choiceReservationOptions = (String) menu.getMainMenuChoiceFromOptions(RESERVATION_OPTIONS);			// RUN RESERVATION OPTIONS	
						if (choiceReservationOptions.equals(RESERVATION_OPTIONS_SEARCH_RESERVATION)) {								// RUN SEARCH RESERVATION OPTION
							while(campsiteChoice == null) {
								try {
									campsiteChoice = Integer.valueOf(menu.getCampsiteChoice());
								}
								catch(NumberFormatException e) {
									menu.printInputError();
								}
							}
							if (campsiteChoice == 0) {
								break;
							}
							
							LocalDate departureChoiceDate = null;
							LocalDate arrivalChoiceDate = null;
							boolean sitesAvailable = true;
							while(sitesAvailable) {
								sitesAvailable = false;
								while(arrivalChoice == null) {
									try {
										arrivalChoice = LocalDate.parse(menu.getArrivalDateFromUser());
									}
									catch(DateTimeParseException e) {
										menu.printInputError();
									}
								}
								while(departureChoice == null) {
									try {
										departureChoice = LocalDate.parse(menu.getDepartureDateFromUser());
									}
									catch(DateTimeParseException e) {
										menu.printInputError();
									}
								}
								
								
								sites = manager.getReservationsByCampsite(campsiteChoice, arrivalChoice, departureChoice);
								sitesAvailable = menu.printAndCheckSiteList(sites);
								if(!sitesAvailable) {
									break;
								}
							}
							menu.printAllSitesFromUserInput(sites, campgrounds);
							siteChoice = menu.getSiteToBeReservedFromUser();
							int siteChoiceInt = Integer.parseInt(siteChoice); // This should probably be handled elsewhere
							if (siteChoiceInt == 0){							// So should this
								break;
							}
							reservationName = menu.getReservationName();
							int confirmationId = manager.getReservationNameAndSite(siteChoiceInt, reservationName, arrivalChoiceDate, departureChoiceDate);
							menu.printConfirmationId(confirmationId);
						}
						else if (choiceReservationOptions.equals(RESERVATION_OPTIONS_RETURN_TO_PARK_MENU)) {							// RETURN TO RESERVATION OPTIONS MENU
							runReservation = false;
						}
					}
				}
				else if(choiceParkMenuOptions.equals(PARK_MENU_OPTIONS_SEARCH_RESERVATION)) {										// SEARCH GLOBAL RESERVATIONS MENU
					// NOTHING IN THIS BLOCK IS FINISHED
					arrivalChoice = LocalDate.parse(menu.getArrivalDateFromUser());
					departureChoice = LocalDate.parse(menu.getDepartureDateFromUser());
					sites = manager.getReservationsParkWide(currentPark.getPark_id(), arrivalChoice, departureChoice);
					menu.printAllSitesFromUserInput(sites, campgrounds);

				}
				else if (choiceParkMenuOptions.equals(PARK_MENU_OPTIONS_RETURN_TO_MAIN_MENU)) {										// RETURN TO MAIN MENU
					runParkMenu = false;
				}
			}
		}
	}

	public void addParkNamesToArray(ArrayList<Park> parks) {
		namesOfParksArray = new String[parks.size() + 1 ];
		int i = 0;
		for (Park park : parks) {
			namesOfParksArray[i++] = park.getName();
		}
		namesOfParksArray[i] = "Quit";
	}

	public void printSites(ArrayList<Site> sites2) {
		for (Site site : sites2) {
			this.sites = sites2;
			System.out.println(site.getSite_id() + " " + site.getCamp_id() + site.getSite_number()
					+ site.getMax_occupency() + site.isAccessible() + site.getMax_rv_length() + site.isUtilities());
		}
	}

}
