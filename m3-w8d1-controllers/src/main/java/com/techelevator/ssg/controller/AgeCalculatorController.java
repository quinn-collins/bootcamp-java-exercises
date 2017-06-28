package com.techelevator.ssg.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AgeCalculatorController {
	
	@RequestMapping("/ageCalculatorInput")
	public String showAgeCalculatorInput() {
		return "ageCalculatorInput";
	}
	
	@RequestMapping("/ageCalculatorResult")
	public String showAgeCalculatorResult(HttpServletRequest request) {
		String choosePlanet = request.getParameter("choosePlanet");
		String earthAge = request.getParameter("earthAge");
		Double age = Double.valueOf(earthAge);
		if(choosePlanet.equals("mercury")) {
			request.setAttribute("alienAge", (age * 365)/87.96);
		} else if(choosePlanet.equals("venus")) {
			request.setAttribute("alienAge", (age * 365)/224.68);
		} else if(choosePlanet.equals("earth")) {
			request.setAttribute("alienAge", (age));
		} else if(choosePlanet.equals("mars")) {
			request.setAttribute("alienAge", (age * 365)/686.98);
		} else if(choosePlanet.equals("jupiter")) {
			request.setAttribute("alienAge", (age * 365)/11.862);
		} else if(choosePlanet.equals("saturn")) {
			request.setAttribute("alienAge", (age * 365)/29.456);
		} else if(choosePlanet.equals("uranus")) {
			request.setAttribute("alienAge", (age * 365)/84.07);
		} else {
			request.setAttribute("alienAge", (age * 365)/164.81);
		}
		
		
		return "ageCalculatorResult";
	}
}
