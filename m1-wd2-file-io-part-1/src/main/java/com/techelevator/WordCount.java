package com.techelevator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class WordCount {

	public static void main(String[] args) {
		// ask the user for the file path
		// verify that the file is valid
		File file = getFileFromUser();

		// read the contents of the file
		try(Scanner fileInput = new Scanner(file)) {
			// go line by line through the file
			int lineNumber = 1;
			int sentences = 0;
			int words = 0;
			while(fileInput.hasNextLine()) {
				String line = fileInput.nextLine();
				
				if(line.contains(".") || line.contains("?") || line.contains("!")) {
					sentences++;
				}
				String[] wordArray = line.split(" ");
				for(String word : wordArray) {
					if(!word.isEmpty()) {
						words++;
					}
				}
				
					
			}
			// display numbers of words and sentences
			System.out.println("Word count: " + words);
			System.out.println("Sentence count: " + sentences);
 		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private static File getFileFromUser() {
		Scanner input = new Scanner(System.in);
		System.out.println("File please: ");
		String path = input.nextLine();
		
		File file = new File(path);
		if(!file.exists()) {
			System.out.println("That file does not exist");
			System.exit(1);
		}
		else if(!file.isFile()) {
			System.out.println(path + " is a directory.");
		}
		
		return file;
		
	}

}
