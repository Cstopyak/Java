package com.colbystopyak.displaydate.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
                "dd-MMM-yyyy");
        String LocalDate = dateFormat.format(new Date());
        model.addAttribute("date", LocalDate);
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		SimpleDateFormat timeFormat = new SimpleDateFormat(
                "HH:mm:a");
        String LocalTime = timeFormat.format(new Date());
        model.addAttribute("time", LocalTime);
		return "time.jsp";
	}
}
