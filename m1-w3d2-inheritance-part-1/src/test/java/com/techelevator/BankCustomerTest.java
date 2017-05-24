package com.techelevator;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class BankCustomerTest {
	BankCustomer customer;
	BankAccount Account1;
	BankAccount Account2;
	BankAccount Account3;
	
	@Before
	public void setup() {
		Account1 = new BankAccount();
		Account2 = new BankAccount();
		Account3 = new BankAccount();
		customer = new BankCustomer();
		customer.setName("Quinn");
		customer.setAddress("Rev1");
		customer.setPhoneNumber("614");
		customer.addAccount(Account1);
		customer.addAccount(Account2);
		customer.addAccount(Account3);
		
	}
	
	@Test
	public void get_set_name() {
		Assert.assertEquals("Quinn", customer.getName());
	}
	
	@Test
	public void check_for_vip() {
		Account1.deposit(new DollarAmount(250000000));
		Account2.deposit(new DollarAmount(250000000));
		Account3.deposit(new DollarAmount(250000000));
		Assert.assertTrue(customer.isVip());
		
	}
	@Test
	public void check_for_vip_false() {
		Account1.deposit(new DollarAmount(2));
		Account2.deposit(new DollarAmount(77));
		Account3.deposit(new DollarAmount(1));
		Assert.assertFalse(customer.isVip());
		
	}
	
	@Test
	public void get_set_address() {
		Assert.assertEquals("Rev1", customer.getAddress());
	}
	
	@Test
	public void get_set_phone_number() {
		Assert.assertEquals("614", customer.getPhoneNumber());
	}
	
	@Test
	public void check_accounts_returned() {
//		for(int i = 0; i < customer.getAccounts().size(); i++) { } 
		BankAccount accountCheck1 = customer.getAccounts()[0];
		BankAccount accountCheck2 = customer.getAccounts()[1];
		BankAccount accountCheck3 = customer.getAccounts()[2];
		Assert.assertEquals(Account1, accountCheck1);
		Assert.assertEquals(Account2, accountCheck2);
		Assert.assertEquals(Account3, accountCheck3);
	}
}
