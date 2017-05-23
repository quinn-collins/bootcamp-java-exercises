package com.techelevator;

public class CheckingAccount extends BankAccount {

	@Override
	public DollarAmount withdraw(DollarAmount amountToWithdraw) {
		if(getBalance().isGreaterThanOrEqualTo(amountToWithdraw)) {
			return super.withdraw(amountToWithdraw);
		} else if(getBalance().isGreaterThanOrEqualTo(new DollarAmount(-9000))) {
			return super.withdraw(amountToWithdraw.plus(new DollarAmount(1000)));
		} else {
			return getBalance();
		}
	}
}
