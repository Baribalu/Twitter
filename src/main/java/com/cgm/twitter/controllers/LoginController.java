package com.cgm.twitter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cgm.builder.AccountBuilder;
import com.cgm.entities.Account;

@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping(method = RequestMethod.GET)
	public String login(ModelMap model) {
		model.put("account",new Account());
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("account") Account account, ModelMap model) {
		
		Account testAccount = AccountBuilder.andreiAccount();
		if(testAccount.getUsername().equals(account.getUsername()) && testAccount.getPassword().equals(account.getUsername())) {
			model.put("account",account);
			return new ModelAndView("logout",model);
		}
		
		return new ModelAndView("login");
	}
	
}
