package com.colbystopyak.dojosurvey.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SurveyController {
	@RequestMapping(value="/survey", method=RequestMethod.POST)
	public String survey(@RequestParam(value="name") String name, @RequestParam(value="location") String location, @RequestParam(value="Favlanguage") String Favlanguage, @RequestParam(value="comment") String comment, HttpSession session) {
		session.setAttribute("name", name);
		session.setAttribute("location", location);
		session.setAttribute("Favlanguage", Favlanguage);
		session.setAttribute("comment", comment);
		return "survey.jsp";
	}
}
