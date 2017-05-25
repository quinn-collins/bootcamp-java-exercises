package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;

public class HomeworkAssignmentTest {
	HomeworkAssignment myHomework;
	
	@Before
	public void setup() {
		myHomework = new HomeworkAssignment(100);
	}
	
	@Test
	public void initialize_total_marks(){
		myHomework.setTotalMarks(50);
		Assert.assertEquals(50, myHomework.getTotalMarks());
	}
	
	@Test
	public void check_possible_marks() {
		Assert.assertEquals(100, myHomework.getPossibleMarks());
	}
	
	@Test
	public void initialize_submitter_name() {
		myHomework.setSubmitterName("quinn");
		Assert.assertEquals("quinn", myHomework.getSubmitterName());
	}
	
	@Test
	public void check_grade_a() {
		myHomework.setTotalMarks(90);
		Assert.assertEquals("A", myHomework.getLetterGrade());
	}
	
	public void check_grade_b() {
		myHomework.setTotalMarks(80);
		Assert.assertEquals("B", myHomework.getLetterGrade());
	}	
	
	public void check_grade_c() {
		myHomework.setTotalMarks(70);
		Assert.assertEquals("C", myHomework.getLetterGrade());
	}
}
