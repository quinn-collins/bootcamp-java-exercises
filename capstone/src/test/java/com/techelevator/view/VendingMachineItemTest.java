package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class VendingMachineItemTest {
	VendingMachineItem item;
	
	@Before
	public void setup(){
		item = new VendingMachineItem("Cola", 50.0, 5, 0);
	}
	@Test
	public void test_get_item_name(){
		Assert.assertEquals("Cola", item.getItemName());
	}
	@Test
	public void test_get_item_price(){
		Assert.assertEquals(50.0, item.getItemPrice(), 0.01);
	}
	@Test
	public void test_get_item_remaining(){
		Assert.assertEquals(5, item.getItemsRemaining());
	}
	@Test
	public void test_get_item_sold(){
		Assert.assertEquals(0, item.getItemSold());
	}
	@Test
	public void test_set_item_name(){
		Assert.assertEquals(0, item.setItemSold(0));
	}
	@Test
	public void test_set_item_remaining(){
		Assert.assertEquals(4, item.setItemsRemaining(4));
	}
	@Test
	public void test_to_string(){
		Assert.assertEquals("Cola $50.0 5 Remaining", item.toString());
	}
}
