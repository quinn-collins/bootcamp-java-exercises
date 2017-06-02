package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class MenuTest {
	Menu menu;
	private PrintWriter out;
	private Scanner in;
	private String[] validAmount = { "$1", "$2", "$5", "$10", "Exit" };
	private double totalMoney;
	private Map<String, VendingMachineItem> slotsAndItemInfo;
	private List<VendingMachineItem> itemsPurchased = new ArrayList<VendingMachineItem>();
	
	Map<String, VendingMachineItem> map;
	VendingMachineItem item;
	
	@Before
	public void setup(){
		menu = new Menu(System.in,System.out);
		map = new LinkedHashMap<String, VendingMachineItem>();
		item = new VendingMachineItem("name",4.0,5,0);
		map.put("A1", item);
	}
	@Test
	public void test_get_current_money(){
		Assert.assertEquals(totalMoney, menu.getCurrentMoney(), 0.01);
	}
	@Test
	public void test_get_total_money(){
		Assert.assertEquals(totalMoney, menu.getTotalMoney(),0.01);
	}
	@Test
	public void test_derease_money(){
		menu.decreaseMoney(2);
		Assert.assertEquals(-2, menu.getTotalMoney(),0.01);
	}
//	@Test
//	public void test_decrease_item_count(){
//		Assert.assertEquals(4, item.getItemsRemaining());
//	}
//	@Test
//	public void test_increase_item_sold(){
//		Assert.assertEquals(4, item.getItemsRemaining());
//	}
}
