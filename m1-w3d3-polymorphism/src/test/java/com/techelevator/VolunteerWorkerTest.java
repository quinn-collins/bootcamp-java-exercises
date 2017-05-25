package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VolunteerWorkerTest {
	VolunteerWorker volunteer;
	
	@Before
	public void setup() {
	volunteer = new VolunteerWorker("Sally", "Dood"); //make new salary worker
	}
	
	@Test
	public void calculate_test() {
		Assert.assertEquals(0, volunteer.calculateWeeklyPay(40), .01);
	}
	
	@Test
	public void first_name_test() {
		Assert.assertEquals("Sally", volunteer.getFirstName() );
	}
	
	@Test
	public void last_name_test() {
		Assert.assertEquals("Dood", volunteer.getLastName() );
	}



}
