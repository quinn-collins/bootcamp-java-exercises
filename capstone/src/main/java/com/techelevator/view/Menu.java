package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Menu {
	
	private String[] validAmount = { "$1", "$2", "$5", "$10", "Exit" };
	private Map<String, VendingMachineItem> slotsAndItemInfo;
	private List<VendingMachineItem> itemsPurchased = new ArrayList<VendingMachineItem>();
	private double totalMoney;
	private PrintWriter out;
	private Scanner in;

	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
	}

	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while(choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}

	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if(selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch(NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will be null
		}
		if(choice == null) {
			out.println("\n*** "+userInput+" is not a valid option ***\n");
		}
		return choice;
	}

	private void displayMenuOptions(Object[] options) {
		out.println();
		for(int i = 0; i < options.length; i++) {
			int optionNum = i+1;
			out.println(optionNum+") "+options[i]);
		}
		out.print("\nPlease choose an option >>> ");
		out.flush();
	}
	//get the item file
	private File getItemFile() {
		File itemFile = new File("vendingmachine.csv");
		return itemFile;
	}
	// store 
	public Map<String, VendingMachineItem> readAndStockItems() {
		slotsAndItemInfo = new LinkedHashMap<String, VendingMachineItem>();
		try(Scanner input = new Scanner(getItemFile())) {
			while(input.hasNextLine()) {
				String line = input.nextLine();
				String[] pieces = line.split("\\|");
				if(pieces[0].startsWith("A")) {
					slotsAndItemInfo.put(pieces[0], new ChipItem(pieces[1], Double.valueOf(2), 5));
				}
				else if(pieces[0].startsWith("B")) {
					slotsAndItemInfo.put(pieces[0], new CandyItem(pieces[1], Double.valueOf(2), 5));
				}
				else if(pieces[0].startsWith("C")) {
					slotsAndItemInfo.put(pieces[0], new DrinkItem(pieces[1], Double.valueOf(2), 5));
				}
				else if(pieces[0].startsWith("D")) {
					slotsAndItemInfo.put(pieces[0], new GumItem(pieces[1], Double.valueOf(2), 5));
				}
				else {
					slotsAndItemInfo.put(pieces[0], new VendingMachineItem(pieces[1], Double.valueOf(pieces[2]), 5));
				}
				
			}
			
		}
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return slotsAndItemInfo;
	}
	
	public void decreaseItemCount(String decision) {
		VendingMachineItem vending = slotsAndItemInfo.get(decision);
		vending.setItemsRemaining(vending.getItemsRemaining() - 1);
		slotsAndItemInfo.put(decision, vending);
	}
	
	public Map<String, VendingMachineItem> getSlotsAndItemInfo() {
		return slotsAndItemInfo;
	}
	
	public Set<String> getKeys() {
		Set<String> keys = getSlotsAndItemInfo().keySet();
		return keys;
	}
	
	
	public double increaseMoney() {
		Scanner input = new Scanner(System.in);
		for(int i = 1; i < validAmount.length + 1; i++){
			System.out.println(i + ") " + validAmount[i - 1]);
		}
		System.out.println("Balance: $" + totalMoney);
		while(true) {
			String decision = input.nextLine();
			System.out.println("Put in money or press '5' to exit.");
			if(decision.equals("1")) {
				totalMoney += 1.00;
			}
			else if(decision.equals("2")) {
				totalMoney += 2.00;
			}
			else if(decision.equals("3")) {
				totalMoney += 5.00;
			}
			else if(decision.equals("4")) {
				totalMoney += 10.00;
			}
			else if(decision.equals("5")) {
				break;
			}
			System.out.println("Balance: $" + totalMoney);

		}
		return totalMoney;
		
	}
	
	public double decreaseMoney(double money) {
		totalMoney -= money;
		return totalMoney;
	}
	
	public double getCurrentMoney() {
		return totalMoney;
	}

	public void selectProduct() {
		Scanner input = new Scanner(System.in);
		System.out.println("What product would you like to purchase? ");
		for(String key : getKeys()) {
			System.out.println(key + " " + getSlotsAndItemInfo().get(key));
		}
		
		while(true) {
			String decision = input.nextLine();
			if(!getSlotsAndItemInfo().containsKey(decision)) {
				System.out.println("This item selection does not exist.");
				break;
			}
			else if(getSlotsAndItemInfo().get(decision).getItemsRemaining() <= 0) {
				System.out.println("Sorry this item is sold out, please choose another.");
				break;
			}
			else if(totalMoney < getSlotsAndItemInfo().get(decision).getItemPrice()) {
				System.out.println("Please feed more money.");
				break;
			}
			else {
				System.out.println("Heres your " + getSlotsAndItemInfo().get(decision).getItemName());
				decreaseMoney(getSlotsAndItemInfo().get(decision).getItemPrice());
				decreaseItemCount(decision);
				System.out.println("Your new balance is " + totalMoney);
				itemsPurchased.add(getSlotsAndItemInfo().get(decision));
				break;
			}
		}
		
		
	}

	public void finishTransaction() {
		System.out.print(totalMoney + " returned to you: ");
		int quarters = 0;
		int dimes = 0;
		int nickels = 0;
		while(totalMoney >= .05) {
			if(totalMoney >= .25) {
				quarters++;
				totalMoney -= .25;
			}
			else if(totalMoney >= .10) {
				dimes++;
				totalMoney -=.10;
			}
			else if(totalMoney >= .05) {
				nickels++;
				totalMoney -= .05;
			}
		}
		System.out.println("Quarters: " + quarters + " Dimes: " + dimes + " Nickels: " + nickels);
		System.out.println("Balance is now: " + totalMoney);
		for(VendingMachineItem item : itemsPurchased) {
			item.makeNoise();
		}
		
		
	}
	
	

}
