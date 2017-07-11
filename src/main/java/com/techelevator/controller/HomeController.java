package com.techelevator.controller;

import java.util.ArrayList;
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
	@RequestMapping(path="/surveyResult", method=RequestMethod.GET)
	public String displaySurveyResult(HttpServletRequest request){
		List<Park> parksList = new ArrayList<>();
		List<Survey> surveyList = surveyDao.getAllSurvey();
		for(Survey survey : surveyList) {
			parksList.add(parkDao.getParkByParkCode(survey.getParkCode()));
		}
		request.setAttribute("parkList", parksList);
		request.setAttribute("surveyList", surveyList);
		return "surveyResult";
	}
	@RequestMapping(path="/", method=RequestMethod.POST)
	public String processIndex(HttpServletRequest request){
		return "redirect:/";
	}
	@RequestMapping(path="/surveyInput", method=RequestMethod.POST)
	public String processSurveyInputt(HttpServletRequest request){
		String fPark = request.getParameter("fPark");
		String email = request.getParameter("email");
		String state = request.getParameter("state");
		String activity = request.getParameter("activity");
		Survey survey = new Survey();
		survey.setParkCode(fPark);
		survey.setEmailAddress(email);
		survey.setState(state);
		survey.setActivityLevel(activity);
		
		surveyDao.save(survey);
		
		return "redirect:/surveyResult";
	}
	
	
}
