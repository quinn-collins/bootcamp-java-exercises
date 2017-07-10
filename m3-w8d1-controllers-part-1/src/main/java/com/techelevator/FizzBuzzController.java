package com.techelevator;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FizzBuzzController {
	
	@RequestMapping("/fizzBuzzInput")
	public String showFizzBuzzInput() {
		return "fizzBuzzInput";
	}
	
	@RequestMapping("/fizzBuzzResult")
	public String showFizzBuzzResult(HttpServletRequest request) {
		String divisibleByFirst = request.getParameter("divisibleByFirst");
		String divisibleBySecond = request.getParameter("divisibleBySecond");
		String alternateFizz = request.getParameter("alternateFizz");
		String alternateBuzz = request.getParameter("alternateBuzz");
		String numberOne = request.getParameter("numberOne");
		String numberTwo = request.getParameter("numberTwo");
		String numberThree = request.getParameter("numberThree");
		String numberFour = request.getParameter("numberFour");
		String numberFive = request.getParameter("numberFive");
		
		ArrayList<Integer> divisors = new ArrayList<>();
		if(divisibleByFirst != null && !divisibleByFirst.isEmpty()){
			divisors.add(Integer.valueOf(divisibleByFirst));
		}
		if(divisibleBySecond != null && !divisibleBySecond.isEmpty()){
			divisors.add(Integer.valueOf(divisibleBySecond));
		}
		
		ArrayList<Integer> numbers = new ArrayList<>();
		if(numberOne != null && !numberOne.isEmpty()) {
			numbers.add(Integer.valueOf(numberOne));
		}
		if(numberTwo != null && !numberOne.isEmpty()) {
			numbers.add(Integer.valueOf(numberTwo));
		}
		if(numberThree != null && !numberOne.isEmpty()) {
			numbers.add(Integer.valueOf(numberThree));
		}
		if(numberFour != null && !numberOne.isEmpty()) {
			numbers.add(Integer.valueOf(numberFour));
		}
		if(numberFive != null && !numberOne.isEmpty()) {
			numbers.add(Integer.valueOf(numberFive));
		}
		
		request.setAttribute("numbers", numbers);
		request.setAttribute("divisors", divisors);
		return "fizzBuzzResult";
	}
}
