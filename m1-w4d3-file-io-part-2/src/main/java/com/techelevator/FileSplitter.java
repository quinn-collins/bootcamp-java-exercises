package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileSplitter {

	public static void main(String[] args) {
		// Ask the user for text file to be split√
		// Very that the file exists and is not a directory√
		File sourceFile = getSourceFileFromUser();
		// Ask the user for the number of lines in each of the files after the split
		// Open the source file for reading
		openAndReadSourceAndWriteToNewFiles(sourceFile);
		// read each line and write it to a new file
		// increment the file counter each time it has the number of lines it's supposed to have
		

	}
	
	private static File getSourceFileFromUser() {
		System.out.println("What file would you like to split? ");
		Scanner input = new Scanner(System.in);
		String path = input.nextLine();
		
		File sourceFile = new File(path);
		if(!sourceFile.exists()) {
			System.out.println("That file doesn't exist");
		}
		else if(!sourceFile.isFile()) {
			System.out.println(path + " is a directory.");
		}
		return sourceFile;
	}
	
	private static int getNumberOfLines() {
		Scanner input = new Scanner(System.in);
		System.out.println("How many lines would you like to break at? ");
		return input.nextInt();
	}
	
	private static void openAndReadSourceAndWriteToNewFiles(File sourceFile) {
		try(Scanner fileInput = new Scanner(sourceFile)) {
			int count = 1;
			int numberOfLines = getNumberOfLines();
				while(fileInput.hasNextLine()) {
					try(PrintWriter writer = new PrintWriter("Input-" + count)) {
					
					for(int i = 0; i < numberOfLines ; i++) {
						if(fileInput.hasNextLine()){
							String line = fileInput.nextLine();
							writer.println(line);
						}
					}
					count++;
				}
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
