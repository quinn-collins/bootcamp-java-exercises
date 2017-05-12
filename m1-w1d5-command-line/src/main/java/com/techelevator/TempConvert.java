package com.techelevator;

/*
 The Fahrenheit to Celsius conversion formula is:
 	Tc = (Tf - 32) / 1.8
 	where 'Tc' is the temperature in Celsius, and 'Tf' is the temperature in Fahrenheit
 	
 The Celsius to Fahrenheit conversion formula is:
 	Tf = Tc * 1.8 + 32
 	
 Write a command line program which prompts a user to enter a temperature, and whether its in degrees (C)elsius or (F)arenheit.
 Convert the temperature to the opposite degrees, and display the old and new temperatures to the console.
  
 $ java TempConvert
 Please enter the temperature: 58
 Is the temperature in (C)elcius, or (F)arenheit? F
 58F is 14C.
 
 Note why Tf - 32 above is enclosed in parentheses with a comment inside your code. You'll feel better for it, 
 and will start building some good programming habits while you're at it.
 */
import java.util.Scanner;
public class TempConvert {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double temp, newTemp = 0;
		String decideTemp, oppTemp = "N";
		
		System.out.println("Please enter the temperature: ");
		temp = input.nextDouble();
		input.nextLine();
		
		System.out.println("Is the temperature in (C)elsius, or (F)arenheit? ");
		decideTemp = input.nextLine();
		
		if(decideTemp.equals("F")) {
			newTemp = (temp - 32) / 1.8;
			oppTemp = "C";
		}
		else if(decideTemp.equals("C")) {
			newTemp = temp * 1.8 + 32;
			oppTemp = "F";
		}
		else {
			System.out.println("Please enter a 'Y' or an 'C' next time you run the program.");
		}
		if(oppTemp != "N"){
			System.out.println(temp + decideTemp + " is " + newTemp + oppTemp);
		}
		System.out.println("Have a great day!");
	}

}
