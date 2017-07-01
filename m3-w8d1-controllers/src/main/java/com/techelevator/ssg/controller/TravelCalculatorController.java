package com.techelevator.ssg.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TravelCalculatorController {
	
	@RequestMapping("/travelCalculatorInput")
	public String showTravelCalculatorInput() {
		return "travelCalculatorInput";
	}
	
	@RequestMapping("/travelCalculatorResult")
	public String showTravelCalculatorResult(HttpServletRequest request) {
		String choosePlanet = request.getParameter("choosePlanet");
		String chooseTravelMethod = request.getParameter("chooseTravelMethod");
		String earthAge = request.getParameter("earthAge");
		double age = Double.valueOf(earthAge);
		
		
		Map<String, Double> travelMethodMap = new HashMap<>();
		travelMethodMap.put("walking", 3.0);
		travelMethodMap.put("car", 100.0);
		travelMethodMap.put("bulletTrain", 200.0);
		travelMethodMap.put("boeing747", 570.0);
		travelMethodMap.put("concorde", 1350.0);
		
		Map<String, Double> planetDistanceMap = new HashMap<>();
		planetDistanceMap.put("mercury", 56974146.0);
		planetDistanceMap.put("venus", 25724767.0);
		planetDistanceMap.put("earth", 1.0);
		planetDistanceMap.put("mars", 48678219.0);
		planetDistanceMap.put("jupiter", 390674710.0);
		planetDistanceMap.put("saturn", 792248270.0);
		planetDistanceMap.put("uranus", 1692662530.0);
		planetDistanceMap.put("neptune", 2703959960.0);
		
		double travelTime = (planetDistanceMap.get(choosePlanet)/travelMethodMap.get(chooseTravelMethod)/24/365);
		
		request.setAttribute("travelTime", travelTime);
		request.setAttribute("ageAfterTravel", age+travelTime);
		
		
		
		return "travelCalculatorResult";
	}
}
