package com.techelevator;

/*
 The Fibonacci numbers are the integers in the following sequence:  
	0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
 By definition, the first two numbers in the Fibonacci sequence are 0 and 1, and each subsequent number is the sum of the previous two.
 
Write a command line program which prompts the user for an integer value and display the Fibonacci sequence leading up to that number.

  
 $ java Fiboncci
 
Please enter the Fibonacci number: 25
 
 0, 1, 1, 2, 3, 5, 8, 13, 21
 */
import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		int x = 0, y = 0, z = 0;
		int userNumber;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter the Fibonacci number: ");
		userNumber = input.nextInt();
		
		while(true) {
			z = x + y;
			x = y;
			y = z;

			if(y == 0) {
				y++;
			}
			if(userNumber == x){
				System.out.println(x);
				System.out.println("You entered a Fibonacci number and reached the end.");
				break;
			}
			else if (userNumber < x){
				System.out.println("You've reached the end.");
				break;
			}
			System.out.println(x);
		}
	
		
	}

	
}
