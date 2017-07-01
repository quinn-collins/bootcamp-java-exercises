package com.techelevator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class colorizedNameController {
	
	@RequestMapping("/colorizedNameInput")
	public String showColorizedNameInput() {
		return "colorizedNameInput";
	}
	
	@RequestMapping("/colorizedNameResult")
	public String showColorizedNameResult(HttpServletRequest request) {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String red = request.getParameter("red");
		String blue = request.getParameter("blue");
		String green = request.getParameter("green");
		
		if(!red.isEmpty() && !red.equals(null)){
			request.setAttribute("redName", firstName + " " + lastName);
		}
		if(!blue.isEmpty() && !blue.equals(null)){
			request.setAttribute("blueName", firstName + " " + lastName);
		}
		if(!green.isEmpty() && !green.equals(null)){
			request.setAttribute("greenName", firstName + " " + lastName);
		}
		return "colorizedNameResult";
	}
}
