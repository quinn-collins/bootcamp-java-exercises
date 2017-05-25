package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AirplaneTest {
private Airplane myAirplane;
	
	@Before
	public void setup() {
		myAirplane = new Airplane(10, 100);
	}
	
	@Test
	public void plane_number_set() {
		Assert.assertEquals(null, myAirplane.getPlaneNumber());
	}
	
	@Test
	public void first_class_seats_can_be_reserved() {
		Assert.assertTrue("You can book those seats because they are available", myAirplane.Reserve(true, 5));
		Assert.assertEquals(5, myAirplane.getAvailableFirstClassSeats());
		Assert.assertEquals(5, myAirplane.getBookedFirstClassSeats());
	}
	
	@Test
	public void first_class_seats_can_not_be_reserved() {
		Assert.assertFalse("You can not book those seats because there is not enough seats", myAirplane.Reserve(true, 15));
		Assert.assertEquals(10, myAirplane.getAvailableFirstClassSeats());
		Assert.assertEquals(0, myAirplane.getBookedFirstClassSeats());
	}
	
	@Test
	public void coach_seats_can_be_reserved() {
		Assert.assertTrue("You can book those seats because they are available", myAirplane.Reserve(false, 50));
		Assert.assertEquals(50, myAirplane.getAvailableCoachSeats());
		Assert.assertEquals(50, myAirplane.getBookedCoachSeats());
	}
	
	@Test
	public void coach_seats_can_not_be_reserved() {
		Assert.assertFalse("You can not book that many seats", myAirplane.Reserve(false, 150));
		Assert.assertEquals(100, myAirplane.getAvailableCoachSeats());
		Assert.assertEquals(0, myAirplane.getBookedCoachSeats());
	}
	
	@Test
	public void total_first_class_seats_initialized(){
		Assert.assertEquals(10, myAirplane.getTotalFirstClassSeats());
	}
	
	@Test
	public void total_coach_seats_initialized() {
		Assert.assertEquals(100, myAirplane.getTotalCoachSeats());
	}
	
	
}
