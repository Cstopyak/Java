package com.colbystopyak.counter.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/")
	public String index(Model model, HttpSession session) {

		Integer count = (Integer) session.getAttribute("count");
		if (count == null) {
			session.setAttribute("count", 0);

		}
		count++;
		session.setAttribute("count", count);
		model.addAttribute("count", count);
		return "index.jsp";
	}

	@RequestMapping("/counter")
	public String counter(Model model, HttpSession session) {
		
		Integer count = (Integer) session.getAttribute("count");
		if (count == null) {
			session.setAttribute("count", 0);

		}
		count++;
		session.setAttribute("count", count);
		model.addAttribute("count", count);
		return "counter.jsp";
	}

}
