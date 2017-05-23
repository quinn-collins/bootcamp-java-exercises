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
		Assert.assertEquals(new DollarAmount(0), bank.getBalance());
	}
	
	@Test
	public void check_balance_deposit() {
		DollarAmount amountToDeposit = new DollarAmount(1000);
		Assert.assertEquals(new DollarAmount(1000), bank.deposit(amountToDeposit));
	}
}
