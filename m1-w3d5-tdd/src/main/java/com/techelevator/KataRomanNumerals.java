package com.techelevator;

public class KataRomanNumerals {
	String[] romanArray = {"M", "CM", "D", "C", "L", "X", "IX", "V", "IV", "I"};
	int[] numbersArray = {1000, 900, 500, 100, 50, 10, 9, 5, 4, 1};
	
	public String numeralToRoman(int number) {
		int n = number;
		String roman = "";
		
		for(int i = 0; i < numbersArray.length; i++) {
			while(n >= numbersArray[i]) {
				roman += romanArray[i];
				n -= numbersArray[i];
			}
		}
		return roman;
	}
	
	public int romanToNumeral(String roman) {
		int numeral = 0;
		while(!roman.isEmpty()){
			if(roman.length() == 1) {
				for(int i = 0; i < romanArray.length; i++) {
					if(roman.equals(romanArray[i])) {
						numeral += numbersArray[i];
						roman = "";
						break;
					}
				}
				
			}
			if(roman.length() >= 2) {
				for(int i = 0; i < romanArray.length; i++) {
					if(roman.substring(0,2).equals(romanArray[i])){
						numeral += numbersArray[i];
						roman = roman.substring(2);
						break;
					}
				}
			}
			
			if(roman.length() >= 1) {
				for(int i = 0; i < romanArray.length; i++) {
					if(roman.substring(0,1).equals(romanArray[i])) {
						numeral += numbersArray[i];
						roman = roman.substring(1);
						break;
					}
				}
			}
			
		}
		
		return numeral;
	}
	
}
//		String roman = "";
//		while(number >= 1000) {
//			roman = roman + "M";
//			number -= 1000;
//		}
//		while(number >= 900){
//			roman = roman + "CM";
//			number -= 900;
//		}
//		while(number >= 500){
//			roman = roman + "D";
//			number -= 500;
//		}
//		while(number >= 100){
//			roman = roman + "C";
//			number -= 100;
//		}
//		while(number >= 50){
//			roman = roman + "L";
//			number -= 50;
//		}
//		while(number >= 10){
//			roman = roman + "X";
//			number -= 10;
//		}
//		while(number >= 9){
//			roman = roman + "IX";
//			number -= 9;
//		}
//		while(number >= 5){
//			roman = roman + "V";
//			number -= 5;
//		}
//		while(number >= 4) {
//			roman = roman + "IV";
//			number -= 4;
//		}
//		while(number >= 1){
//			roman = roman + "I";
//			number -= 1;
//		}
//		
//		return roman;
//	}
		
	
	
	
	
	
//	String[] romanArray = {"I","V","X"};
//	int j = 0;
//	int k = 1;
//	
//	public String numeralToRoman(int number) {
//		String roman = "";
//		for(int i = 1; i <= number; i++) {
//			roman = roman + romanArray[j];
//			if(roman.equals(romanArray[j] + romanArray[j] + romanArray[j] + romanArray[j])) {
//				roman = romanArray[j] + romanArray[k];
//			}
//			else if(roman.equals(romanArray[j] + romanArray[k] + romanArray[j])){
//				roman = romanArray[k];
//			}
//			else if(roman.equals(romanArray[k] + romanArray[j])){
//				roman = romanArray[k] + romanArray[j];
//			}
//		}
//		return roman;
//	}

