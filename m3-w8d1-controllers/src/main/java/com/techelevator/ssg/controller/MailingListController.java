package com.techelevator.ssg.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.ssg.model.SignUp;

@Controller
@RequestMapping("/mailingList")
public class MailingListController {
	
	@RequestMapping(path="", method=RequestMethod.GET)
	public String showMailingListForm(Model modelHolder) {
		if(! modelHolder.containsAttribute("signup")) {
			modelHolder.addAttribute("signup", new SignUp());
		}
		
		return "mailingList";
	}
	
	@RequestMapping(path="/submit", method=RequestMethod.POST)
	public String handleMailingListForm(
			@Valid @ModelAttribute("signup") SignUp signup, 
			BindingResult result,
			RedirectAttributes attr
	) {
		attr.addFlashAttribute("signup", signup);
		if(result.hasErrors()) {
			attr.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "signup", result);
			return "redirect:/mailingList";
		}
		
		return "redirect:/mailingList/thankYou";
	}
	
	@RequestMapping(path="/thankYou", method=RequestMethod.GET)
	public String showThankYou() {
		return "mailingListThankYou";
	}

}
