package com.sharad.controller;

import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;
import java.net.http.HttpRequest;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class showHomeConroller {
	
	/*	@RequestMapping("/home")
		public String showHome(Map<String,Object> map) {
			System.out.println("ShowHomeController.process::shareMemoryObject class name ::"+map.getClass());
			map.put("attr1", "val");
			map.put("sysd",LocalDateTime.now());
			return "welcome";
		}*/
	
	/*
	@RequestMapping("/home")
	public String showHome(Model model) {
		System.out.println("ShowHomeController.process::shareMemoryObject class name ::"+model.getClass());
		model.addAttribute("attr1","val1");
		model.addAttribute("sysd",LocalDateTime.now());
		//return LVN
		return "welcome";
		
	}*/
	
	/*	@RequestMapping("/home")
		public String showHome(ModelMap map) {
			System.out.println("ShowHomeController.process::shareMemoryObject class name ::"+map.getClass());
			map.addAttribute("attr1","val1");
			map.addAttribute("sysd",LocalDateTime.now());
			//return LVN
			return "welcome";
		}*/
	
	/*taking handler method return type as model*/
	
	/*
	@RequestMapping("/home")
	public Model showHome() {
		Model model= new BindingAwareModelMap();
		model.addAttribute("attr1","val1");
		model.addAttribute("sysd", LocalDateTime.now());
		return model;
		
	}*/
	
	/*@RequestMapping("/home")
	public Map<String, Object> showHome(){
		Map<String,Object> map = new HashMap();
		map.put("attr1", "val2");
		map.put("sysd", LocalDateTime.now());
		return map;
	}*/
	
	@RequestMapping("/home")
	public void showHome(Map<String,Object> map) {
		map.put("attr1", "val1");
		map.put("sysd", LocalDateTime.now());
	}
	
	/*If the handler method return run
	 *  --the request path of the handler method taken as LVN*/
	@RequestMapping("/process")
	public String process(Map<String,Object> map) {
		map.put("attr1", "Val1");
		map.put("sysd", new Date());
		return null;                     // take the requestPath as LVN-Logical view Name
	}
	/*
	@RequestMapping("/home1")
	public String home() {
		System.out.println("showHomeConroller.process()");
		return "forward:report";
	}
	
	@RequestMapping("/report")
	public String welcome() {
		System.out.println("showHomeConroller.welcome()");
		return "welcome";
	}
	*/
	@RequestMapping("/home1")
	public String home(HttpServletRequest req) {
		System.out.println("showHomeConroller.home()");
		req.setAttribute("attr1", "val1");
		return "redirect:report?p1=val1&p2=val2";
	}
	@RequestMapping("report")
	public String welcome(HttpServletRequest req) {
		System.out.println("req Attribute"+ req.getAttribute("attr1"));
		return "welcome";
	}
	
	
	/* How to get HttpRequest and HttpResponse object in the handler method ? 
	 *  -- by passing the as a parameter */
	/*
	@RequestMapping("/process1")
	public String process(HttpServletRequest req, HttpServletResponse res){
		System.out.println("showHomeConroller.process()");
		req.setAttribute("attr1", "val1");
		return "welcome";
		
	}*/
	
	/*How to send the output from handler method directly to browser without
	 * involving the viewResolver and viewComponent ?
	 * -- By the help of printWriter 
	 * */
	@RequestMapping("process2")
	public void process(HttpServletResponse res)throws Exception{
		PrintWriter pw= res.getWriter();
		res.setContentType("text/html");
		pw.println("<b>directly from handler method </b>");
	}
}
