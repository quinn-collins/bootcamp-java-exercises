package com.techelevator;

/*
 Write a command line program which prompts the user for the total bill, and the amount tendered. It should then display the change required.
 
 $ java MakeChange
 Please enter the amount of the bill: 23.65
 Please enter the amount tendered: 100.00
 The change required is 76.35
 */
import java.util.Scanner;
import java.text.DecimalFormat;

public class MakeChange {

	public static void main(String[] args) {
		//declare variables
		double totalBill, tendered, changeReq;
		Scanner input = new Scanner(System.in);
		DecimalFormat d = new DecimalFormat("'$'0.00");
		
		//Get input from the user
		System.out.println("Please enter the amount of the bill: ");
		totalBill = input.nextDouble();
		
		System.out.println("Please enter the amount tendered: ");
		tendered = input.nextDouble();
		
		changeReq = tendered - totalBill;
		
		System.out.println("The change required is " + d.format(changeReq));
	}

}
