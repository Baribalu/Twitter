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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cgm.builder.AccountBuilder;
import com.cgm.entities.Account;
import com.cgm.entities.Message;

/**
 * Handles requests for the application home page.
 */
@Controller("home")
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String home(ModelMap model) {



		return "home";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String home(@ModelAttribute("message") Message message,ModelMap model) {

		return "home";
	}

}
