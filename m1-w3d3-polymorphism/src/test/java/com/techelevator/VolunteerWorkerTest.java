package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VolunteerWorkerTest {
SalaryWorker salary;
@Before
public void setup() {
salary = new VolunteerWorker("Sally", "Dood", 52000); //make new salary worker
}

@Test
public void calculate_test() {
	Assert.assertEquals(1000, salary.calculateWeeklyPay(40), .01);
}

@Test
public void first_name_test() {
	Assert.assertEquals("Sally", salary.getFirstName() );
}

@Test
public void last_name_test() {
	Assert.assertEquals("Dood", salary.getLastName() );
}

@Test
public void annual_salary_test() {
	Assert.assertEquals(52000, salary.getAnnualSalary(), .01 );
}

}
