package com.techelevator;

public class HomeworkAssignment {
	private int totalMarks;
	private int possibleMarks;
	private String submitterName;
	private String letterGrade;
	
	public int getTotalMarks() {
		return totalMarks;
	}
	
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	
	public int getPossibleMarks() {
		return possibleMarks;
	}
	
	public String getSubmitterName() {
		return submitterName;
	}
	
	public void setSubmitterName(String submitterName) {
		this.submitterName = submitterName;
	}
	
	public String getLetterGrade() {
		double percentCorrect = ((double)totalMarks / (double)possibleMarks) * 100;
		if(percentCorrect >= 90){
			letterGrade = "A";
		}
		else if(percentCorrect >= 80) {
			letterGrade = "B";
		}
		else if (percentCorrect >= 70) {
			letterGrade = "C";
		}
		else if (percentCorrect >= 60) {
			letterGrade = "D";
		}
		else {
			letterGrade = "F";
		}
		return letterGrade;
	}
	
	public HomeworkAssignment(int possibleMarks) {
		this.possibleMarks = possibleMarks;
	}
	
	
}
