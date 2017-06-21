package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import com.techelevator.model.Campground;
import com.techelevator.model.Park;
import com.techelevator.model.Site;

public class Menu {
	
	private PrintWriter out; // create a writer that can write anything - PrintWriter out = new PrintWriter(output)
	private Scanner in; // create a reader that can read anything - Scanner in = new Scanner(input)

	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output); // output == System.out - System is a class that contains method out which returns a WriteStream;
		this.in = new Scanner(input);		// input == System.in - System is a class that contains method in which returns an InputStream;
	}
	
	public Object getMainMenuChoiceFromOptions(Object[] options) {
		Object choice = null;
		while(choice == null) { // while choice is null
			displayMainMenuOptions(options); // displays main menu options
			choice = getMainMenuChoiceFromUserInput(options); // passes main menu options, waits for object return
		}
		return choice;
	}

	private Object getMainMenuChoiceFromUserInput(Object[] options) {
		Object choice = null; // creates object sets to null
		String userInput = in.nextLine(); // takes input from user
		try {
			int selectedOption = Integer.valueOf(userInput); // sets new int selectedOption to int version of user input
			if(selectedOption > 0 && selectedOption <= options.length) { // if user int less or equal to main menu options
				choice = options[selectedOption - 1];					// choice = main menu options[user value - 1]
			}															// choice object = main menu string object
		} catch(NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will be null
		}
		if(choice == null) {	// any option not in the array
			out.println("\n*** "+userInput+" is not a valid option ***\n");
			out.flush();
		}
		return choice;
	}

	private void displayMainMenuOptions(Object[] options) {
		out.println();
		for(int i = 0; i < options.length; i++) {
			int optionNum = i+1;
			out.println(optionNum+") "+options[i]);
		}
		out.println("\nPlease choose an option >>> ");
		out.flush();
		
	}

	public void printCurrentParkInformation(Park currentPark) {
		
		
		out.println("Park Information Screen");
		out.println(currentPark.getName() + " National Park");
		out.printf("%-17s", "Location: ");
		out.printf(currentPark.getLocation() + "\n");
		out.printf("%-17s", "Established: ");
		out.println(currentPark.getEstablish_date());
		out.printf("%-17s", "Area: ");
		out.println(currentPark.getArea() + " sq. km");
		out.printf("%-17s", "Annual Visitors: ");
		out.println(currentPark.getVisitors() + " visitors");
		out.println(currentPark.getDescription());
		out.flush();
	}

	public void printAllCampgrounds(Park currentPark, ArrayList<Campground> campgrounds) {
		out.println("Park Campgrounds");
		out.println(currentPark.getName() + " National Park Campgrounds");
		out.println();
		out.printf("%-10s", "Site ID");
		out.printf("%-20s", "Campground Name");
		out.printf("%-16s", "Open Month");
		out.printf("%-16s", "Close Month");
		out.printf("%-20s", "Daily Fee");
		out.println();
		for (Campground campground : campgrounds) {
			if (currentPark.getPark_id() == campground.getPark_id()) {
				out.print("#");
				out.printf("%-9s", campground.getCampground_id());
				out.printf("%-20s", campground.getName());
				out.printf("%-16s", campground.getOpen_from_mm());
				out.printf("%-16s", campground.getOpen_to_mm());
				out.print("$");
				out.printf("%-20s", campground.getDaily_fee());
				
				out.println();
			}
		}
		out.flush();
		
	}

	public String getArrivalDateFromUser() {
		System.out.println("What is arrival date (Year-Month-Day) ?");
		String arrivalChoice = in.nextLine();
		return arrivalChoice;		
	}

	public String getDepartureDateFromUser() {
		System.out.println("What is departure date(Year-Month-Day) ? ");
		String departureChoice = in.nextLine();
		return departureChoice;
	}

	public boolean printAndCheckSiteList(ArrayList<Site> sites) {
		boolean sitesAvailable = false;
		if(sites.isEmpty() || sites.equals(null)){
			out.println("Would you like to pick another date? (y) / (n)");
			String pickAnotherDate = in.nextLine();
		    if(pickAnotherDate.equals("y")){
		    	sitesAvailable = true;
		    }
		}
		return sitesAvailable;
	}

	public void printAllSitesFromUserInput(ArrayList<Site> sites, ArrayList<Campground> campgrounds) {
		System.out.println("Results matching Your Search Criteria");
		System.out.printf("%-10s", "Site No.");
		System.out.printf("%-12s", "Max Occup.");
		System.out.printf("%-16s", "Accessible?");
		System.out.printf("%-16s", "Max RV Length");
		System.out.printf("%-12s", "Utility");
		System.out.printf("%-20s", "Cost");
		System.out.println();
		
		for(Site site : sites) {
			System.out.printf("%-10s", site.getSite_id());
			System.out.printf("%-12s", site.getMax_occupency());
			System.out.printf("%-16s", site.isAccessible());
			System.out.printf("%-16s", site.getMax_rv_length());
			System.out.printf("%-12s", site.isUtilities());
			System.out.print("$");
			
			
			for(Campground campground : campgrounds) {
				if(site.getCamp_id() == campground.getCampground_id())
					System.out.println(campground.getDaily_fee());
			}
			
		}
		
	}

	public String getSiteToBeReservedFromUser() {
		System.out.println("Which site should be reserved (enter 0 to cancel) ?");
		String siteChoice = in.nextLine();
		return siteChoice;
	}

	public String getReservationName() {
		System.out.println("What name should the reservation be made under? ____) ? ");
		String reservationName = in.nextLine();
		return reservationName;
	}

	public void printConfirmationId(int confirmationId) {
		System.out.println("The reservation has been made and the confirmation id is " + confirmationId);
	}

	public String getCampsiteChoice() {
		System.out.println("Which campground (enter 0 to cancel)? _");
		String campsiteChoice = in.nextLine();
		return campsiteChoice;
	}

	public void printInputError() {
		out.println("\n*** Your input is not a valid option ***\n");
		out.flush();
	}

}
