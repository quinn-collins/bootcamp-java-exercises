package com.techelevator.application;

import com.techelevator.controller.CampgroundManager;

public class Main {
	private static CampgroundManager manager;
	
	public static void main(String[] args) {
		manager = new CampgroundManager();
		manager.run();
	}
}
