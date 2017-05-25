package com.techelevator;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class ElevatorTest {
	private Elevator myElevator;
	
	@Before
	public void setup() {
		myElevator = new Elevator(1, 10);
	}
	
	@Test
	public void return_shaft_number() {
		Assert.assertEquals(1, myElevator.getShaftNumber());
	}
	
	@Test
	public void return_current_level() {
		Assert.assertEquals(1, myElevator.getCurrentLevel());
	}
	
	@Test 
	public void return_number_of_levels() {
		Assert.assertEquals(10, myElevator.getNumberOfLevels());
	}
	
	@Test
	public void door_should_be_open() {
		Assert.assertTrue("Door should be open", myElevator.isDoorOpen());
	}
	
	@Test
	public void elevator_should_not_be_moving() {
		Assert.assertFalse("Elevator should not be moving", myElevator.isMoving());
	}
	
	@Test
	public void door_should_open() {
		myElevator.CloseDoor();
		myElevator.OpenDoor();
		Assert.assertTrue("Elevator door should open", myElevator.isDoorOpen());
	}
	
	@Test
	public void elevator_should_go_up() {
		myElevator.CloseDoor();
		Assert.assertTrue("Elevator should go up if desired floor is greater than currentlevel", myElevator.GoUp(4));
	}
	@Test
	public void elevator_should_not_go_above_number_of_levels() {
		
		Assert.assertFalse("Elevator can't go above max level", myElevator.GoUp(12));
	}
	
	@Test
	public void elevator_should_not_go_up_if_desired_lower_than_current() {
		Assert.assertFalse("Elevator can't go up if desired floor is lower than current level", myElevator.GoUp(0));
	}
	
	@Test
	public void elevator_should_not_go_up_if_door_open() {
		myElevator.OpenDoor();
		Assert.assertFalse("Elevator can't move if door open", myElevator.GoUp(4) );
	}
	
	@Test
	public void elevator_should_go_down() {
		myElevator.CloseDoor();
		myElevator.GoUp(4);
		Assert.assertTrue("Elevator should go up if door is not open, current level is greater than desired floor, and your not trying to go below floor 1", myElevator.GoDown(1));
	}
	
	@Test
	public void elevator_should_not_go_down_if_door_open() {
		myElevator.GoUp(6);
		myElevator.OpenDoor();
		Assert.assertFalse("Elevator can't move if door is open", myElevator.GoDown(1));
	}
	@Test
	public void elevator_cant_be_lower_than_1(){
		Assert.assertFalse("Elevator can't go lower than 1", myElevator.GoDown(0));
	}
	@Test
	public void elevator_cant_go_down_if_desired_level_is_above_current_floor() {
		Assert.assertFalse("Desired level can't be higher than current level", myElevator.GoDown(2));
	}

}
