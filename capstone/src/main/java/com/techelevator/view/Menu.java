package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Date;

public class Menu {

	private String[] validAmount = { "$1", "$2", "$5", "$10", "Exit" };
	private Map<String, VendingMachineItem> slotsAndItemInfo;
	private List<VendingMachineItem> itemsPurchased = new ArrayList<VendingMachineItem>();
	private double totalMoney;
	private PrintWriter out;
	private Scanner in;

	Date date = new Date();
	String timeAndDate = date.toString();

	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
	}

	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while (choice == null) {
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
			if (selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch (NumberFormatException e) {
			// eat the exception, an error message will be displayed below since
			// choice will be null
		}
		if (choice == null) {
			out.println("\n*** " + userInput + " is not a valid option ***\n");
		}
		return choice;
	}

	private void displayMenuOptions(Object[] options) {
		out.println();
		for (int i = 0; i < options.length; i++) {
			int optionNum = i + 1;
			out.println(optionNum + ") " + options[i]);
		}
		out.print("\nPlease choose an option >>> ");
		out.flush();
	}

	// get the item file
	private File getItemFile() {
		File itemFile = new File("vendingmachine.csv");
		return itemFile;
	}

	// store
	public Map<String, VendingMachineItem> readAndStockItems() {
		slotsAndItemInfo = new LinkedHashMap<String, VendingMachineItem>();
		try (Scanner input = new Scanner(getItemFile())) {
			while (input.hasNextLine()) {
				String line = input.nextLine();
				String[] pieces = line.split("\\|");
				if (pieces[0].startsWith("A")) {
					slotsAndItemInfo.put(pieces[0], new ChipItem(pieces[1], Double.valueOf(2), 5, 0));
				} else if (pieces[0].startsWith("B")) {
					slotsAndItemInfo.put(pieces[0], new CandyItem(pieces[1], Double.valueOf(2), 5, 0));
				} else if (pieces[0].startsWith("C")) {
					slotsAndItemInfo.put(pieces[0], new DrinkItem(pieces[1], Double.valueOf(2), 5, 0));
				} else if (pieces[0].startsWith("D")) {
					slotsAndItemInfo.put(pieces[0], new GumItem(pieces[1], Double.valueOf(2), 5, 0));
				} else {
					slotsAndItemInfo.put(pieces[0], new VendingMachineItem(pieces[1], Double.valueOf(pieces[2]), 5, 0));
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

	public double getTotalMoney() {
		return totalMoney;
	}

	public double increaseMoney() {
		Scanner input = new Scanner(System.in);
		for (int i = 1; i < validAmount.length + 1; i++) {
			System.out.println(i + ") " + validAmount[i - 1]);
		}
		System.out.println("Balance: $" + totalMoney);
		while (true) {
			String line = "";
			String decision = input.nextLine();
			System.out.println("Put in money or press '5' to exit.");
			if (decision.equals("1")) {
				line += timeAndDate + " FEED MONEY: " + totalMoney + " ";
				totalMoney += 1.00;
				line += totalMoney;
				printLog(line);
			} else if (decision.equals("2")) {
				line += timeAndDate + " FEED MONEY: " + totalMoney + " ";
				totalMoney += 2.00;
				line += totalMoney;
				printLog(line);
			} else if (decision.equals("3")) {
				line += timeAndDate + " FEED MONEY: " + totalMoney + " ";
				totalMoney += 5.00;
				line += totalMoney;
				printLog(line);
			} else if (decision.equals("4")) {
				line += timeAndDate + " FEED MONEY: " + totalMoney + " ";
				totalMoney += 10.00;
				line += totalMoney;
				printLog(line);
			} else if (decision.equals("5")) {
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
		String line = "";
		Scanner input = new Scanner(System.in);
		System.out.println("What product would you like to purchase? ");
		for (String key : getKeys()) {
			System.out.println(key + " " + getSlotsAndItemInfo().get(key));
		}

		while (true) {
			String decision = input.nextLine();
			if (!getSlotsAndItemInfo().containsKey(decision)) {
				System.out.println("This item selection does not exist.");
				break;
			} else if (getSlotsAndItemInfo().get(decision).getItemsRemaining() <= 0) {
				System.out.println("Sorry this item is sold out, please choose another.");
				break;
			} else if (totalMoney < getSlotsAndItemInfo().get(decision).getItemPrice()) {
				System.out.println("Please feed more money.");
				break;
			} else {
				System.out.println("Heres your " + getSlotsAndItemInfo().get(decision).getItemName());
				line += timeAndDate + " " + getSlotsAndItemInfo().get(decision).getItemName() + " " + decision + ": "
						+ totalMoney + " ";
				decreaseMoney(getSlotsAndItemInfo().get(decision).getItemPrice());
				decreaseItemCount(decision);
				increaseItemSold(decision);
				System.out.println("Your new balance is " + totalMoney);
				System.out.println(getSlotsAndItemInfo().get(decision).getItemSold());
				itemsPurchased.add(getSlotsAndItemInfo().get(decision));
				line += totalMoney;
				printLog(line);
				break;
			}

		}

	}

	private void increaseItemSold(String decision) {
		VendingMachineItem vendingItemSold = slotsAndItemInfo.get(decision);
		vendingItemSold.setItemSold(vendingItemSold.getItemSold() + 1);
		slotsAndItemInfo.put(decision, vendingItemSold);
	}

	public void finishTransaction() {
		String line = "";
		System.out.print(totalMoney + " returned to you: ");
		line += timeAndDate + " " + "GIVE CHANGE " + totalMoney + " ";
		int quarters = 0;
		int dimes = 0;
		int nickels = 0;
		while (totalMoney >= .05) {
			if (totalMoney >= .25) {
				quarters++;
				totalMoney -= .25;
			} else if (totalMoney >= .10) {
				dimes++;
				totalMoney -= .10;
			} else if (totalMoney >= .05) {
				nickels++;
				totalMoney -= .05;
			}

		}
		line += totalMoney;
		printLog(line);
		salesLog();
		System.out.println("Quarters: " + quarters + " Dimes: " + dimes + " Nickels: " + nickels);
		System.out.println("Balance is now: " + totalMoney);
		for (VendingMachineItem item : itemsPurchased) {
			item.makeNoise();
		}

	}

	public void printLog(String line) {
		try (PrintWriter logging = new PrintWriter(new FileWriter("Log.txt", true))) {
			line += "\n";
			logging.println(line);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	public void salesLog() {
		double totalSales = 0;
		Set<String> keys = getKeys();
		try (PrintWriter report = new PrintWriter(new FileWriter("SalesReport.txt", true))) {
			for (String key : keys) {
				report.println(getSlotsAndItemInfo().get(key).getItemName() + " | "
						+ getSlotsAndItemInfo().get(key).getItemSold());
				totalSales += (getSlotsAndItemInfo().get(key).getItemPrice()
						* getSlotsAndItemInfo().get(key).getItemSold());
			}

			report.println("\n**TOTAL SALES**" + " $" + totalSales);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

}
