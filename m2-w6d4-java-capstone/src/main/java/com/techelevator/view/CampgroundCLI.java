package com.techelevator.view;

import java.util.ArrayList;
import java.util.List;

import com.techelevator.model.Park;

public class CampgroundCLI {
	private List<Park> parks;
	private String[] namesOfParksArray;
	private static final String PARK_MENU_OPTIONS_VIEW_CAMPGROUNDS = "View Campgrounds";
	private static final String PARK_MENU_OPTIONS_SEARCH_RESERVATION = "Search for Reservation";
	private static final String PARK_MENU_OPTIONS_RETURN_TO_MAIN_MENU = "Return to Previous Screen";
	private static final String[] PARK_MENU_OPTIONS = { PARK_MENU_OPTIONS_VIEW_CAMPGROUNDS,
														PARK_MENU_OPTIONS_SEARCH_RESERVATION,
														PARK_MENU_OPTIONS_RETURN_TO_MAIN_MENU};

	
	private Menu menu;
	
	public CampgroundCLI(Menu menu) {
		this.menu = menu;
	}

	public void run(ArrayList<Park> parks) {
		setListOfParks(parks);
		addParkNamesToArray(parks);
		
		boolean runMainMenu = true;
		boolean runParkMenu = true;
		while(runMainMenu) {
			String choiceParkMenu = (String)menu.getMainMenuChoiceFromOptions(namesOfParksArray);
			Park currentPark;
			for(Park park : parks) {
				if(park.getName().equals(choiceParkMenu)) {
					currentPark = park;
					System.out.println("Park Information Screen");
					System.out.println(currentPark.getName() + " National Park");
					System.out.println("Location: " + currentPark.getLocation());
					System.out.println("Established: " + currentPark.getEstablish_date());
					System.out.println("Area: " + currentPark.getArea() + " sq km");
					System.out.println("Annual Visitors: " + currentPark.getVisitors());
					System.out.println("\n\n" + currentPark.getDescription());
				}
			}
			while(runParkMenu) {
				//show the information about choice
				// select a command (view, search for reservations, return to previous screens
				String choiceParkMenuOptions = (String)menu.getMainMenuChoiceFromOptions(PARK_MENU_OPTIONS);
				
			}
		}
		
//		if(choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void setListOfParks(ArrayList<Park> parks) {
		this.parks = parks;
	}
	
	public void addParkNamesToArray(ArrayList<Park> parks) {
		namesOfParksArray = new String[parks.size()];
		int i = 0;
		for(Park park : parks) {
			namesOfParksArray[i++] = park.getName();
		}
	}
	
	
	
	

}
