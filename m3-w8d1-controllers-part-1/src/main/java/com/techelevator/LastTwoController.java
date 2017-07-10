package com.techelevator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("words")
public class LastTwoController {
	
	@RequestMapping(path="/lastTwoInput", method=RequestMethod.GET)
	public String showLastTwoInput() {
		return "lastTwoInput";
	}
	
	@RequestMapping(path="/lastTwoInput", method=RequestMethod.POST)
	public String showLastTwoInput(HttpServletRequest request, ModelMap model) {
		String wordOne = request.getParameter("wordOne");
		String wordTwo = request.getParameter("wordTwo");
		words words = new words();
		words.setWord1(wordOne);
		words.setWord2(wordTwo);
		model.addAttribute("words", words);
		return "redirect:/lastTwoResult";
	}
	
	@RequestMapping(path="/lastTwoResult", method=RequestMethod.GET)
	public String showLastTwoResult(ModelMap model) {
		return "lastTwoResult";
	}
}
