package com.techelevator;

public class Elevator {
	private int currentFloor;
	private int numberOfFloors;
	private boolean doorOpen;
	
	public Elevator(int totalNumberOfFloors) {
		numberOfFloors = totalNumberOfFloors;
		currentFloor = 1;
	}
	
	public int getCurrentFloor() {
		return currentFloor;
	}
	public int getNumberOfFloors() {
		return numberOfFloors;
	}
	public boolean isDoorOpen() {
		return doorOpen;
	}
	public void openDoor() {
		if(doorOpen){
			
		}
		else{
			doorOpen = true;
		}
	}
	public void closeDoor() {
		if(doorOpen){
			doorOpen = false;
		}
		else{
			
		}
	}
	public void goUp(int desiredFloor) {
		if(doorOpen){
			
		}
		else{
			if(desiredFloor <= numberOfFloors && desiredFloor > currentFloor) {
				currentFloor = desiredFloor;
			}
		}
	}
	public void goDown(int desiredFloor) {
		if(doorOpen){
			
		}
		else{
			if(desiredFloor > 0 && desiredFloor < currentFloor){
				currentFloor = desiredFloor;
			}
		}
	}
	
}
