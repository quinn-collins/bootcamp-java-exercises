package com.techelevator;

/*
Write a command line program which prompts the user for a series of decimal integer values  
and displays each decimal value as itself and its binary equivalent

$ DecimalToBinary 

Please enter in a series of decimal values (separated by spaces): 460 8218 1 31313 987654321

460 in binary is 111001100
8218 in binary is 10000000011010
1 in binary is 1
31313 in binary is 111101001010001
987654321 in binary is 111010110111100110100010110001
*/
import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		//declare variables
		int decimalValue;
		Scanner input = new Scanner(System.in);
		
		//get user input
		System.out.println("Enter the decimal you would like to convert to binary: ");
		decimalValue = input.nextInt();
		System.out.print(decimalValue + " in binary is ");
		
		/*
		 * target value is = where to start in binary. IE if number is 17, target value will double until 32.
		 * decimal value = user input
		 */
		int targetValue = 1;
		while(targetValue < decimalValue) {
			targetValue *= 2;
		}
		
		/*
		 * Target value was found to be the first number bigger than the decimal value on the binary scale
		 * Start a while loop that stops once your target value is <= 0
		 * check if target value is less or equal to the user value. IE is 32 <= 17
		 * if it is we have a 1 at the start of our binary number
		 * if it isn't we have a 0
		 * following you want to divide target value by 2. IE 32 / 2 = 16
		 * 16 > 0
		 * So 16 <= 17 so we'll print out a 1
		 * since we get a 1, we'll subtract target value from decimal value. IE 17 - 16 = 1
		 * we'll divide target value by 2.. 16 / 2 = 8
		 * 1 > 0
		 * target value still greater than user value ..else.. put in a 0
		 * 8 / 2 = 4
		 * 1 > 0
		 * else.. put in a 0
		 * 4 / 2 = 2
		 * 1 > 0
		 * else put in a 0
		 * 2 / 2 = 1
		 * target value = decimal value
		 * put in a 1
		 * subrtract target value 1 from decimal value 1 = 0
		 * target value is now = to 0 so exit the loop
		 * 
		 */
		while(targetValue > 0) {
			if(targetValue <= decimalValue) {
				System.out.print("1");
				decimalValue -= targetValue;
			} else {
				System.out.print("0");
			}
			
			targetValue /= 2;	
		}
	}
}
