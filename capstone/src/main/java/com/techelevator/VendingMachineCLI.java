package com.techelevator;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.techelevator.view.Menu;
import com.techelevator.view.VendingMachineItem;

public class VendingMachineCLI {
	private String[] purchaseMenu = { "Feed Money", "Select Product", "Finish Transaction" };
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS,
													   MAIN_MENU_OPTION_PURCHASE };
	
	
	private Menu menu;
	
	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}
	
//	public void setKeys(Set<String> keys) {
//		this.keys = menu.readAndStockItems().keySet();
//	}
//	
//	public Set<String> getKeys() {
//		return keys;
//	}
	
	public void run() {
		while(true) {
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			menu.readAndStockItems();
//			Set<String> keys = menu.getSlotsAndItemInfo().keySet();
			
			if(choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {	
				for(String key : menu.getKeys()) {
					System.out.println(key + " " + menu.getSlotsAndItemInfo().get(key));
				}
			} else if(choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				Scanner input = new Scanner(System.in);
				while(true) {
					for(int i = 1; i < purchaseMenu.length + 1; i++){
						System.out.println(i + ") " + purchaseMenu[i - 1]);
					} System.out.println("Current Money Provided: " + menu.getTotalMoney());
					String decision = input.nextLine();
					if(decision.equals("1")) {
						menu.increaseMoney();
						System.out.println("Your balance is currently: $" + menu.getCurrentMoney());
					}
					else if(decision.equals("2")) {
						menu.selectProduct();
					}
					else if(decision.equals("3")) {
						menu.finishTransaction(); 
						
						
					}
				}
					
			}
		}
	}
	

}
