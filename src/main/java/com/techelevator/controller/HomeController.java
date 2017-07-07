package com.techelevator.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.model.Park;
import com.techelevator.model.ParkDao;
import com.techelevator.model.Survey;
import com.techelevator.model.SurveyDao;
import com.techelevator.model.Weather;
import com.techelevator.model.WeatherDao;

@Controller
public class HomeController {
	
	@Autowired
	ParkDao parkDao;
	@Autowired
	WeatherDao weatherDao;
	@Autowired
	SurveyDao surveyDao;

	@RequestMapping(path="/", method=RequestMethod.GET)
	public String displayIndex(HttpServletRequest request) {
		List<Park> parks = parkDao.getAllParks();
		request.setAttribute("parks", parks);
		return "index";
	}
	
	@RequestMapping(path="/details", method=RequestMethod.GET)
	public String displayDetails(HttpServletRequest request) {
		String parkCode = request.getParameter("parkCode");
		
		//Get the parks
		Park park = parkDao.getParkByParkCode(parkCode);
		request.setAttribute("park", park);
		
		//Get the weather
		List<Weather> weather = weatherDao.getWeatherByParkCode(parkCode);
		request.setAttribute("weather", weather);
		
		return "details";
	}
	@RequestMapping(path="/surveyInput", method=RequestMethod.GET)
	public String displaySurveyInput(HttpServletRequest request){
		String parkCode = request.getParameter("parkCode");
		List<Survey> surveyList = surveyDao.getSurveyByParkCode(parkCode); 
		request.setAttribute("surv", surveyList);
		return "surveyInput";
	}
	@RequestMapping(path="/surveyResult", method=RequestMethod.POST)
	public String processSurveyResult(@RequestParam int surveyId,
									  @RequestParam String parkName,
									  @RequestParam String emailAddress,
									  @RequestParam String state,
									  @RequestParam String activityLevel){
		Survey survey = new Survey();
		survey.setSurveyId(surveyId);
		survey.setEmailAddress(emailAddress);
		survey.setState(state);
		survey.setActivityLevel(activityLevel);
		
		return "surveyResult";
	}
	
	
}
