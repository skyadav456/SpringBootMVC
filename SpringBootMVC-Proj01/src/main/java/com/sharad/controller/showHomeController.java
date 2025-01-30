package com.sharad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class showHomeController {
	/*
		@RequestMapping("/home")
		public String showHomePage() {
			return "welcome";
		}*/

	@RequestMapping("/")
	public String showHomePage() {
		//lVN
		return "welcome";
	}
}
