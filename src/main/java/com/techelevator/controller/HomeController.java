package com.techelevator.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.model.Park;
import com.techelevator.model.ParkDao;
import com.techelevator.model.Weather;
import com.techelevator.model.WeatherDao;

@Controller
public class HomeController {
	
	@Autowired
	ParkDao parkDao;
	@Autowired
	WeatherDao weatherDao;
	

	@RequestMapping(path="/", method=RequestMethod.GET)
	public String displayIndex(HttpServletRequest request) {
		List<Park> parks = parkDao.getAllParks();
		request.setAttribute("parks", parks);
		return "index";
	}
	
	@RequestMapping(path="/details", method=RequestMethod.GET)
	public String displayDetails(HttpServletRequest request) {
		
		String parkCode = request.getParameter("parkCode");
		List<Weather> weather = (List<Weather>) weatherDao.getWeatherByParkCode(parkCode);
		request.setAttribute("weather", weather);
		return "details";
	}
	
	
}
