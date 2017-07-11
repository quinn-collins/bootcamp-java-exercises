package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Survey;;

@Component

public class JDBCSurveyDao implements SurveyDao{
	
	private JdbcTemplate jdbcTemplate;
	public JDBCSurveyDao(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public List<Survey> getAllSurvey() {
		List<Survey> surveys = new ArrayList<Survey>();
		String sqlGetAllSurvey = "SELECT COUNT(parkCode), parkCode, emailAddress, state, activityLevel FROM survey_result GROUP BY parkCode, emailAddress, state, activityLevel ORDER BY COUNT DESC LIMIT 5";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllSurvey);
		while(results.next()){
			Survey survey = mapRowToSurvey(results);
			surveys.add(survey);
		
		}
		return surveys;
	}
	@Override
	public List<Survey> getSurveyByParkCode(String parkCode) {
		List<Survey> surveyByParkCode = new ArrayList<Survey>();
		String sqlGetSurveyByParkCode = "SELECT * FROM survey_result JOIN park ON park.parkCode = survey_result.parkCode WHERE park.parkCode = ? ORDER BY survey_result.surveyId";
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
		survey.setParkCode(results.getString("parkCode"));
		survey.setEmailAddress(results.getString("emailAddress"));
		survey.setState(results.getString("state"));
		survey.setActivityLevel(results.getString("activityLevel"));
		return survey;
	}
	@Override
	public void save(Survey survey) {
//		int surveyId = getNextId();
		String sqlInsertSurvey = "INSERT INTO survey_result(parkCode, emailAddress, state, activityLevel) VALUES(?,?,?,?)";
		jdbcTemplate.update(sqlInsertSurvey, survey.getParkCode(), survey.getEmailAddress(), survey.getState(), survey.getActivityLevel());
//		survey.setSurveyId(surveyId);
		
	}
	private int getNextId() {
		String sqlSelectNextId = "SELECT NEXTVAL('seq_survey_id')";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectNextId);
		int surveyId = (Integer) null;
		if(results.next()) {
			surveyId = results.getInt(1);
		} else {
			throw new RuntimeException("Something strange happened, unable to select next forum post id from sequence");
		}
		return surveyId;
	}
	
}
