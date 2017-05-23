package com.techelevator;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class BankAccountTest {
	BankAccount bank;
	
	@Before
	public void setup() {
		bank = new BankAccount();
		bank.setAccountNumber("123");
	}
	
	@Test
	public void check_account_number() {
		Assert.assertEquals("123", bank.getAccountNumber());
	}
	
	@Test
	public void check_balance() {
		Assert.assertEquals(0, bank.getBalance());
	}
}
