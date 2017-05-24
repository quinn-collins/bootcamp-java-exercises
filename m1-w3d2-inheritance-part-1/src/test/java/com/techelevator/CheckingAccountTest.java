package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CheckingAccountTest {
	CheckingAccount checking;
	
	@Before
	public void setup() {
		checking = new CheckingAccount();
		
	}
	
	@Test 
	public void amount_to_withdraw() {
		DollarAmount amountToWithdraw = new DollarAmount(50);
		checking.deposit(new DollarAmount(100));
		checking.withdraw(amountToWithdraw);
		Assert.assertEquals(new DollarAmount(50), checking.getBalance());
		
	}
	@Test 
	public void amount_overdrawn() {
		DollarAmount amountToWithdraw = new DollarAmount(110);
		checking.deposit(new DollarAmount(100));
		checking.withdraw(amountToWithdraw);
		Assert.assertEquals(new DollarAmount(-1010), checking.getBalance());
		
	}
	@Test 
	public void amount_too_much_withdraw() {
		DollarAmount amountToWithdraw = new DollarAmount(1000000);
		checking.deposit(new DollarAmount(1000));
		checking.withdraw(amountToWithdraw);
		Assert.assertEquals(new DollarAmount(1000), checking.getBalance());
}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
