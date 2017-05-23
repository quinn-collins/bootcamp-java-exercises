package com.techelevator;
//part 2

public class BankAccount {
	private String accountNumber;
	private DollarAmount balance; //different class from exercises;

		//create constructor - BankAccount class name
	public BankAccount() {
		balance = new DollarAmount(0);
	}
	//create setter
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	//create getter - no args, bc we are asking info from class
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public DollarAmount getBalance() {
		return balance;
	}
	
	public DollarAmount deposit(DollarAmount amountToDeposit) {
		balance = balance.plus(amountToDeposit); //we need to have balance = here bc the other is immutable
			return balance;
	}
	//make withdrawal method
	public DollarAmount withdraw(DollarAmount amountToWithdraw) {
		balance = balance.minus(amountToWithdraw);
		return balance;
		
	}
	//create transfer method
	public void transfer(BankAccount destinationAccount, DollarAmount amountToTransfer) {
		//first we should check how much balance we have, instead of using just balance, use new DollarAmount
		DollarAmount startingBalance = new DollarAmount(balance.getDollars(), balance.getCents());
		//withdraw the amount
		DollarAmount balanceAfter = withdraw(amountToTransfer);
		destinationAccount.deposit(amountToTransfer);
		
		if(!startingBalance.equals(balanceAfter)) {
			destinationAccount.deposit(amountToTransfer);
			
		}
	}
}

