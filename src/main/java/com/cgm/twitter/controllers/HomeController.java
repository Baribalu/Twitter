package com.cgm.twitter.controllers;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.cgm.twitter.services.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	UserService userService;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String home(ModelMap model,HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("username");
		model.put("newMessage", new Message());
		if(username!=null) {
			ArrayList<Message> messages = userService.getFollowingMessages(username);
			model.addAttribute("messages",messages);
		}else {
			model.addAttribute("about","You need to Login first! Have Fun!");
		}
		return "home";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String home(@ModelAttribute("newMessage") Message message,ModelMap model, HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("username");
		message.setUser(username);
		userService.postMessage(username,message);
		return "redirect:home";
	}

}
