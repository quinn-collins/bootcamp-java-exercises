package com.techelevator;

import java.util.Map;

import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.models.FavoriteThings;

@Controller
@SessionAttributes("favorites")
public class HelloController {

	@RequestMapping("/greeting")
	public String displayGreeting() {
		
		return "greeting";
	}
	
	@RequestMapping(path="/Page1", method=RequestMethod.GET)
	public String displayPage1() {
		return "Page1";
	}
	
	@RequestMapping(path="/Page1", method=RequestMethod.POST)
	public String displayPage1(HttpServletRequest request, ModelMap model) {
		String favoriteColor = request.getParameter("favoriteColor");
		FavoriteThings favorites = new FavoriteThings();
		favorites.setColor(favoriteColor);
		
		// Save color in the session
		model.addAttribute("favorites", favorites);
		
		return "redirect:/Page2";
	}
	
	@RequestMapping(path="/Page2", method=RequestMethod.GET)
	public String displayPage2() {
		return "Page2";
	}
	
	@RequestMapping(path="/Page2", method=RequestMethod.POST)
	public String displayPage2(HttpServletRequest request, ModelMap model) {
		String favoriteFood = request.getParameter("favoriteFood");
		FavoriteThings favorites = (FavoriteThings)model.get("favorites");
		favorites.setFood(favoriteFood);
		
		// Save food in the session
		model.addAttribute("favorites", favorites);
		
		return "redirect:/Page3";
	}
	
	@RequestMapping(path="/Page3", method=RequestMethod.GET)
	public String displayPage3() {
		return "Page3";
	}
	
	@RequestMapping(path="/Page3", method=RequestMethod.POST)
	public String displayPage3(HttpServletRequest request, ModelMap model) {
		String favoriteSeason = request.getParameter("season");
		FavoriteThings favorites = (FavoriteThings)model.get("favorites");
		favorites.setSeason(favoriteSeason);
		
		// Save season in the session
		model.addAttribute("favorites", favorites);
		
		return "redirect:/Summary";
	}
	
	@RequestMapping(path="/Summary", method=RequestMethod.GET)
	public String displaySummary() {
		return "Summary";
	}
}
