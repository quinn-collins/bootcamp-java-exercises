package com.techelevator.model;

import java.util.List;

public interface SurveyDao {
		public List<Survey> getAllSurvey();
		public List<Survey> getSurveyByParkCode(String parkCode);
		public void save(Survey post);
}
