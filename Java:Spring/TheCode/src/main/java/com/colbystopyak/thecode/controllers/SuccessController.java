package com.colbystopyak.thecode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SuccessController {
	@RequestMapping("/code")
	public String success(@RequestParam(value = "code") String code, RedirectAttributes error) {
		if (code.equals("bushido")) {

			return "code.jsp";
		} 
		else {
			error.addFlashAttribute("error", "You must train harder!");

			return "redirect:/";
		}
	}
	
//	@RequestMapping("/createError")
//    public String flashMessages(RedirectAttributes redirectAttributes) {
//        redirectAttributes.addFlashAttribute("error", "A test error!");
//        return "redirect:/";
//    }

}
