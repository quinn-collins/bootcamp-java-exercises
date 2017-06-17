package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

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
		}
		return choice;
	}

	private void displayMainMenuOptions(Object[] options) {
		out.println();
		for(int i = 0; i < options.length; i++) {
			int optionNum = i+1;
			out.println(optionNum+") "+options[i]);
		}
		out.print("\nPlease choose an option >>> ");
		out.flush();
		
	}

}
