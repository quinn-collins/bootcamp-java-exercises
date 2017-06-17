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
	
	@Test
	public void check_withdraw_balance() {
		DollarAmount amountToWithdraw = new DollarAmount(1000);
		Assert.assertEquals(new DollarAmount(-1000), bank.withdraw(amountToWithdraw));
	}
	@Test
	public void check_transfer() {
		DollarAmount amountToTransfer = new DollarAmount(1000);
		BankAccount destinationAccount = new BankAccount();
		bank.transfer(destinationAccount, amountToTransfer);
		Assert.assertEquals(new DollarAmount(-1000), bank.getBalance());
		Assert.assertEquals(new DollarAmount(1000), destinationAccount.getBalance());
	}
	@Test
	public void check_transfer_of_0() {
		DollarAmount amountToTransfer = new DollarAmount(0);
		BankAccount destinationAccount = new BankAccount();
		bank.transfer(destinationAccount, amountToTransfer);
		Assert.assertEquals(new DollarAmount(0), bank.getBalance());
		Assert.assertEquals(new DollarAmount(0), destinationAccount.getBalance());
	}
	
	
}
