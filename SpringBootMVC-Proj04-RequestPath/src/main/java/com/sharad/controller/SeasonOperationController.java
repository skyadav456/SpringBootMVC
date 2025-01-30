package com.sharad.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sharad.service.ISeasonFinderService;

@Controller
//@RequestMapping("/season")
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
	
	/* ==========================================*/
	
	
	@RequestMapping("/report")
	public String show_report() {
		System.out.println("SeasonOperationController.show_report()");
		return "show_report";
	}
	
	@RequestMapping("/REPORT")
	public String show_report1() {
		System.out.println("SeasonOperationController.show_report1()");
		return "show_report1";
	}
	
	/*@RequestMapping({"/report","/report2"})
	public String report() {
		System.out.println("SeasonOperationController.show_report()");
		return "show_report";
	}*/
	
	
	
	/*
	@GetMapping
	public String showHome1() {
		return "welcome";
	}
	
	@PostMapping
	public String showHome2() {
		return "Welcome";
	}
	*/
	
	
	/*if two handler method of two different controller classes are 
	  having same request path with same request mode then the 
	  "ambiguous mapping" or java.lang.illagalStateException  error coused 
	  
	  solution -- along with method level request path provide the controller level
	  global path using @RequestMapping
	*/	
	
	@GetMapping("/all")
	public String showAllData() {
		return "forward:report";
	}
}
