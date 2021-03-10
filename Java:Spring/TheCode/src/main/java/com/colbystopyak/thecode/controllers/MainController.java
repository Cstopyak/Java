package com.colbystopyak.thecode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MainController {
	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
	
//	@RequestMapping("/code")
//	public String code() {
//		return "code.jsp";
//	}
}
