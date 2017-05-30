package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuizMaker {

	public static void main(String[] args) {
		// Ask the user for the file path
		// Verify that's a valid file
		File file = getFileFromUser();
		
		// Find the first question in the file
		try(Scanner fileInput = new Scanner(file)) {
			Scanner input = new Scanner(System.in);
				String answer = "";
			while(fileInput.hasNextLine()) {
				String line = fileInput.nextLine();
				Boolean correct = false;
				String[] question = line.split("\\|");
				System.out.println(question[0]);
				for(int i = 1; i < question.length; i++) {
					if(question[i].endsWith("*")) {
						System.out.println(question[i].substring(0, question[i].length()-1));
					}
					else {
						System.out.println(question[i]);
					}
				}
				answer = input.nextLine();
				System.out.println("Your answer: " + answer);
				for(int i = 1; i < question.length; i++) {
					if(question[i].contains("*") && question[i].substring(0, question[i].length()-1).equals(answer)) {
						correct = true;	
					}
				}
				if(correct) {
					System.out.println("Correct");
				}
				else {
					System.out.println("Wrong");
				}
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		// Ask user the question
		System.out.println();

	}
	
	private static File getFileFromUser() {
		Scanner input = new Scanner(System.in);
			System.out.println("Give me the file!!");
			String path = input.nextLine();
			
			File file = new File(path);
			if(!file.exists()) {
				System.out.println("That file doesn't exist");
				System.exit(1);
			}
			else if(!file.isFile()) {
				System.out.println(path + " is a directory.");
			}
			
			return file;
		
	}

}
