package com.techelevator.ssg.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WeightCalculatorController {
	
	@RequestMapping("/weightCalculatorInput")
	public String showWeightCalculatorInput() {
		return "weightCalculatorInput";
	}
	
	@RequestMapping("/weightCalculatorResult")
	public String showWeightCalculatorResult(HttpServletRequest request) {
		String choosePlanet = request.getParameter("choosePlanet");
		String earthWeight = request.getParameter("earthWeight");
		Double weight = Double.valueOf(earthWeight);
		if(choosePlanet.equals("mercury")) {
			request.setAttribute("alienWeight", (weight/9.81)*3.59);
		} else if(choosePlanet.equals("venus")) {
			request.setAttribute("alienWeight", (weight/9.81)*8.87);
		} else if(choosePlanet.equals("earth")) {
			request.setAttribute("alienWeight", (weight/9.81)*9.81);
		} else if(choosePlanet.equals("mars")) {
			request.setAttribute("alienWeight", (weight/9.81)*3.77);
		} else if(choosePlanet.equals("jupiter")) {
			request.setAttribute("alienWeight", (weight/9.81)*25.95);
		} else if(choosePlanet.equals("saturn")) {
			request.setAttribute("alienWeight", (weight/9.81)*11.08);
		} else if(choosePlanet.equals("uranus")) {
			request.setAttribute("alienWeight", (weight/9.81)*10.);
		} else {
			request.setAttribute("alienWeight", (weight/9.81)*14.07);
		}
		return "weightCalculatorResult";
	}
}
