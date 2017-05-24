package com.techelevator;

public class SavingsAccount extends BankAccount {

	@Override
	public DollarAmount withdraw(DollarAmount amountToWithdraw) {
		if(getBalance().isGreaterThanOrEqualTo(amountToWithdraw)) {
			if(getBalance().isGreaterThan(new DollarAmount(150000))){
				return super.withdraw(amountToWithdraw);
			}
			else {
				amountToWithdraw = amountToWithdraw.plus(new DollarAmount(200));
				return super.withdraw(amountToWithdraw);
			}
		}
		else {
			return getBalance();
		}
	}
}
