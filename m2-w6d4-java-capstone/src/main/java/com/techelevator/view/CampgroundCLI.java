package com.techelevator.view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.techelevator.controller.CampgroundManager;
import com.techelevator.model.Campground;
import com.techelevator.model.Park;
import com.techelevator.model.Site;

public class CampgroundCLI {

	private String campsiteChoice;
	private String arrivalChoice;
	private String departureChoice;
	private String[] namesOfParksArray;
	private static final String PARK_MENU_OPTIONS_VIEW_CAMPGROUNDS = "View Campgrounds";
	private static final String PARK_MENU_OPTIONS_SEARCH_RESERVATION = "Search for Reservation";
	private static final String PARK_MENU_OPTIONS_RETURN_TO_MAIN_MENU = "Return to Previous Screen";
	private static final String[] PARK_MENU_OPTIONS = { PARK_MENU_OPTIONS_VIEW_CAMPGROUNDS,
			PARK_MENU_OPTIONS_SEARCH_RESERVATION, PARK_MENU_OPTIONS_RETURN_TO_MAIN_MENU };

	private static final String RESERVATION_OPTIONS_SEARCH_RESERVATION = "Search for Available Reservation";
	private static final String RESERVATION_OPTIONS_RETURN_TO_PARK_MENU = "Return to Previous Screen";
	private static final String[] RESERVATION_OPTIONS = { RESERVATION_OPTIONS_SEARCH_RESERVATION,
			RESERVATION_OPTIONS_RETURN_TO_PARK_MENU };

	private ArrayList<Park> parks;
	private ArrayList<Campground> campgrounds;
	private ArrayList<Site> sites;
	private Menu menu;
	private CampgroundManager manager;
	private Scanner input;

	public CampgroundCLI(Menu menu, CampgroundManager manager) {
		this.menu = menu;
		this.manager = manager;
	}

	public void run() {
		input = new Scanner(System.in);
		parks = manager.getAllParks();
		addParkNamesToArray(parks);
		campgrounds = manager.getAllCampgrounds();

		boolean runMainMenu = true;
		boolean runParkMenu = true;
		boolean runReservation = true;
		while (runMainMenu) {
			String choiceParkMenu = (String) menu.getMainMenuChoiceFromOptions(namesOfParksArray);
			Park currentPark = null;
			for (Park park : parks) {
				if (park.getName().equals(choiceParkMenu)) {
					currentPark = park;
					System.out.println("Park Information Screen");
					System.out.println(currentPark.getName() + " National Park");
					System.out.println("Location: " + currentPark.getLocation());
					System.out.println("Established: " + currentPark.getEstablish_date());
					System.out.println("Area: " + currentPark.getArea() + " sq km");
					System.out.println("Annual Visitors: " + currentPark.getVisitors());
					System.out.println("\n" + currentPark.getDescription());
				}
			}
			while (runParkMenu) {
				// show the information about choice
				// select a command (view, search for reservations, return to
				// previous screens
				String choiceParkMenuOptions = (String) menu.getMainMenuChoiceFromOptions(PARK_MENU_OPTIONS);
				if (choiceParkMenuOptions.equals(PARK_MENU_OPTIONS_VIEW_CAMPGROUNDS)) {
					System.out.println("Park Campgrounds");
					System.out.println(currentPark.getName() + " National Park Campgrounds");
					System.out.println();
					System.out.println("Name Open Close Daily Fee");
					for (Campground campground : campgrounds) {
						if (currentPark.getPark_id() == campground.getPark_id()) {
							System.out.print("#" + campground.getCampground_id() + " " + campground.getName() + " "
									+ campground.getOpen_from_mm() + " " + campground.getOpen_to_mm() + " $"
									+ campground.getDaily_fee());
							System.out.println();
						}
					}

					while (runReservation) {
						String choiceReservationOptions = (String) menu
								.getMainMenuChoiceFromOptions(RESERVATION_OPTIONS);
						if (choiceReservationOptions.equals(RESERVATION_OPTIONS_SEARCH_RESERVATION)) {
							System.out.println("Which campground (enter 0 to cancel)? _");
							campsiteChoice = input.nextLine();
							int campsiteChoiceInt = Integer.parseInt(campsiteChoice);
							System.out.println("What is arrival date (Year, Month, Day) ?");
							arrivalChoice = input.nextLine();
							LocalDate arrivalChoiceDate = LocalDate.parse(arrivalChoice);
							System.out.println("What is departure date(Year, Month, Day) ? ");
							departureChoice = input.nextLine();
							LocalDate departureChoiceDate = LocalDate.parse(departureChoice);
							sites = manager.getReservationsByCampsite(campsiteChoiceInt, arrivalChoiceDate, departureChoiceDate);
							for(Site site : sites) {
								System.out.print(site.getSite_id() + "  ");
								System.out.print(site.getMax_occupency() + "  ");
								System.out.print(site.isAccessible() + "  ");
								System.out.print(site.getMax_rv_length() + "  ");
								System.out.print(site.isUtilities() + "  $");
								for(Campground campground : manager.getAllCampgrounds()) {
									if(site.getCamp_id() == campground.getCampground_id())
										System.out.println(campground.getDaily_fee());
								}
								
							}
							

						}
					}
				}
			}
		}
	}

	public void addParkNamesToArray(ArrayList<Park> parks) {
		namesOfParksArray = new String[parks.size()];
		int i = 0;
		for (Park park : parks) {
			namesOfParksArray[i++] = park.getName();
		}
	}

	public void printSites(ArrayList<Site> sites2) {

		for (Site site : sites2) {
			this.sites = sites2;
			System.out.println(site.getSite_id() + " " + site.getCamp_id() + site.getSite_number()
					+ site.getMax_occupency() + site.isAccessible() + site.getMax_rv_length() + site.isUtilities());
		}

	}

}
