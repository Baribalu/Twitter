package com.cgm.twitter.controllers;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cgm.builder.AccountBuilder;
import com.cgm.entities.Account;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(ModelMap model) {

		Account andreiAccount = AccountBuilder.andreiAccount();
		ArrayList<Account> accounts = new ArrayList<Account>();
		accounts.add(andreiAccount);
		
		int i=0;
		for (Account account : AccountBuilder.accounts) {
			for(String following:andreiAccount.getFollowers()) {
				if(account.getUsername().equals(following)) {
					accounts.add(account);
				}
			}
		}
		model.addAttribute("accounts",accounts);

		return "home";
	}

}
