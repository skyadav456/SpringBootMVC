package com.sharad.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sharad.service.ISeasonFinderService;

@Controller
public class SeasonOperationController {

	@Autowired
	public ISeasonFinderService service;
	
	@RequestMapping("/")
	public String showHome() {
		return "welcome";
	}
	
	
	@RequestMapping("/season")
	public String showSeason(Map<String, Object> map) {
		// use Service
		String season = service.findSeason();
		map.put("resultMsg", season);
		return "display";
	}
	
}
