package com.techelevator;

public class BankAccount {
	private String accountNumber;
	private DollarAmount balance;
	
	public BankAccount() {
		balance = new DollarAmount(0);
	}
	
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public DollarAmount getBalance() {
		return balance;
	}
	
	public DollarAmount deposit(DollarAmount amountToDeposit) {
		balance = balance.plus(amountToDeposit);
		return balance;
	}
	
	public DollarAmount withdraw(DollarAmount amountToWithdraw) {
		balance = balance.minus(amountToWithdraw);
		return balance;
	}
	
	public void transfer(BankAccount destinationAccount, DollarAmount amountToTransfer) {
		DollarAmount startingBalance = new DollarAmount(balance.getDollars(), balance.getCents());
		DollarAmount balanceAfter = withdraw(amountToTransfer);
		
		if(!startingBalance.equals(balanceAfter)) {
			destinationAccount.deposit(amountToTransfer);
		}
			
	}
	
}
