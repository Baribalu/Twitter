package com.cgm.twitter.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/friends")
public class FriendsController {

	@RequestMapping(method = RequestMethod.GET)
	public String friends(ModelMap model, HttpServletRequest request) {
		String username = (String)request.getSession().getAttribute("username");
		model.addAttribute("friends",userService.getFriends(username));
		return "friends";
	}
	
}
