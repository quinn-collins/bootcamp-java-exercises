package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SavingsAccountTest {
	SavingsAccount savings;
	
	@Before
	public void setup() {
		savings = new SavingsAccount();
	}
	
	@Test
	public void withdraw_successful() {
		savings.deposit(new DollarAmount(151000));
		DollarAmount amountToWithdraw = new DollarAmount(5000);
		savings.withdraw(amountToWithdraw);
		Assert.assertEquals(new DollarAmount(146000), savings.getBalance());
	}
	
	@Test
	public void withdraw_successful_plus_fee() {
		savings.deposit(new DollarAmount(149000));
		DollarAmount amountToWithdraw = new DollarAmount(5000);
		savings.withdraw(amountToWithdraw);
		Assert.assertEquals(new DollarAmount(143800), savings.getBalance());
	}
	
	@Test
	public void withdraw_failed() {
		savings.deposit(new DollarAmount(150000));
		DollarAmount amountToWithdraw = new DollarAmount(160000);
		savings.withdraw(amountToWithdraw);
		Assert.assertEquals(new DollarAmount(150000), savings.getBalance());
	}
	
	
}
