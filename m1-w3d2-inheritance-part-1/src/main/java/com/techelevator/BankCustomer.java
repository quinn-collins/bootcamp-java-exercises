package com.techelevator;

import java.util.ArrayList;

public class BankCustomer {
	private String name;
	private String address;
	private String phoneNumber;
	private ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
	
	public String getName() {
		return name;
	}
	
	public boolean isVip() {
		DollarAmount totalAccountBalance = new DollarAmount(0);
		for(BankAccount account : accounts){
			totalAccountBalance = totalAccountBalance.plus(account.getBalance());  
		}
		
		return totalAccountBalance.isGreaterThanOrEqualTo(new DollarAmount(25000000));
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public BankAccount[] getAccounts() {
		BankAccount[] accountArray = new BankAccount[accounts.size()];
		accounts.toArray(accountArray);
		return accountArray;
	}
	
	public void addAccount(BankAccount newAccount) {
		accounts.add(newAccount);
	}
	
	
}
