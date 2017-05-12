package com.techelevator;

import java.util.Scanner;

/*
 The foot to meter conversion formula is:
 	m = f * 0.3048
 	
 The meter to foot conversion formula is:
 	f = m * 3.2808399
 	
 Write a command line program which prompts a user to enter a length, and whether the measurement is in (m)eters or (f)eet.
 Convert the length to the opposite measurement, and display the old and new measurements to the console.
  
 $ java LinearConvert
 Please enter the length: 58
 Is the measurement in (m)eter, or (f)eet? f
 58f is 17m.
 */

public class LinearConvert {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double length, newlength = 0;
		String decidelength, opplength = "N";
		
		System.out.println("Please enter the length: ");
		length = input.nextDouble();
		input.nextLine();
		
		System.out.println("Is the length in (M)eters, or (F)eet ");
		decidelength = input.nextLine();
		
		if(decidelength.equals("F")) {
			newlength = length * 0.3048;
			opplength = "M";
		}
		else if(decidelength.equals("M")) {
			newlength = length * 3.2808399;
			opplength = "F";
		}
		else {
			System.out.println("Please enter a 'Y' or an 'C' next time you run the program.");
		}
		if(opplength != "N"){
			System.out.println(length + decidelength + " is " + newlength + opplength);
		}
		System.out.println("Have a great day!");
	}
}


