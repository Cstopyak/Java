package com.colbystopyak.ninjagold.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProcessController {
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/process", method = RequestMethod.POST)
	public String process(@RequestParam(value = "location") String location, HttpSession session) {
		String timestamp = new SimpleDateFormat("mm.hh.dd-MMM-yyyy").format(new Date());

		if (location.equals("farm")) {
			Random r = new Random();
			int num = r.nextInt(20 - 10 + 1) + 10;
			int gold = (int) session.getAttribute("gold");
			session.setAttribute("gold", gold + num);
			ArrayList<String> arrayList = (ArrayList<String>) session.getAttribute("activities");
			System.out.println(arrayList);
			arrayList.add("The farm has chosen you to earn " + num + " gold. (" + timestamp + ")");
			
			session.setAttribute("activities", arrayList);
			return "redirect:/";
		}
		return "redirect:/";
	}
} // end process controller
