package com.techelevator;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class EmployeeTest {
	Employee myEmployee;
	@Before
	public void setup() {
		myEmployee = new Employee(100, "Quinn", "Collins", 100000);
	}
	
	@Test
	public void employee_id_initialized() {
		Assert.assertEquals(100, myEmployee.getEmployeeId());
	}
	
	@Test
	public void employee_first_name_initialized() {
		Assert.assertEquals("Quinn", myEmployee.FirstName());
	}

	@Test
	public void employee_last_name_initialized() {
		Assert.assertEquals("Collins", myEmployee.LastName());
	}
	
	@Test
	public void employee_first_and_last_name_initialized() {
		Assert.assertEquals("Collins, Quinn", myEmployee.FullName());
	}
	
	@Test
	public void employee_department_initialized() {
		myEmployee.setDepartment("testing");
		Assert.assertEquals("testing", myEmployee.getDepartment());
	}
	
	@Test
	public void employee_salary_initialized() {
		Assert.assertEquals(100000, myEmployee.getAnnualSalary(), .01);
	}
	
	@Test
	public void raise_employee_salary() {
		myEmployee.RaiseSalary(200);
		Assert.assertEquals(300000, myEmployee.getAnnualSalary(), 0.01);
	}
}
