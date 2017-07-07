package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component

public class JDBCSurveyDao implements SurveyDao{
	
	private JdbcTemplate jdbcTemplate;
	public JDBCSurveyDao(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public List<Survey> getAllSurvey() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Survey> getSurveyByParkCode(String parkCode) {
		List<Survey> surveyByParkCode = new ArrayList<Survey>();
		String sqlGetSurveyByParkCode = "SELECT * FROM Survey_result JOIN park ON park.parkCode = survey_result.parkCode WHERE park.parkCode = ? ORDER BY park.parkName";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetSurveyByParkCode, parkCode);
		while(results.next()){
			Survey survey = mapRowToSurvey(results);
			surveyByParkCode.add(survey);
		}
		return surveyByParkCode;
 		
	}
	private Survey mapRowToSurvey(SqlRowSet results){
		Survey survey;
		survey = new Survey();
		survey.setSurveyId(results.getInt("surveyId"));
		survey.setParkCode(results.getString("parkCode"));
		survey.setEmailAddress(results.getString("emailAddress"));
		survey.setState(results.getString("state"));
		survey.setActivityLevel(results.getString("activityLevel"));
		return survey;
	}
	
}
