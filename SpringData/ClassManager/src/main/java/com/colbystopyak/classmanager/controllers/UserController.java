package com.colbystopyak.classmanager.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.colbystopyak.classmanager.models.User;
import com.colbystopyak.classmanager.services.UserService;
import com.colbystopyak.classmanager.validators.UserValidator;

@Controller
public class UserController {
	@Autowired 
	private UserService uServ;
	
	@Autowired
	private UserValidator uValid;
	
	@GetMapping("/registration")
	public String registration(@ModelAttribute("user")User emptyUser) {
		return "register.jsp";
	}
	
	@PostMapping("/registration")
	public String processRegister(
			@Valid @ModelAttribute("user")User filledUser, BindingResult results, 
			HttpSession session 
	) {
		uValid.validate(filledUser, results);
		if(results.hasErrors()) {
			return "register.jsp";
		}
//		CREATE USER
		User newUser = uServ.registerUser(filledUser);
//		SAVE THE USER'S ID IN SESSION THEN REDIRECT TO DASHBOARD
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/courses";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login.jsp";
	}
	
	@PostMapping("/login")
	public String processLogin(
			@RequestParam("email")String postEmail,
			@RequestParam("password")String postPassword,
			RedirectAttributes redirectAttributes,
			HttpSession session
	) {
//		IF EMAIL IS NOT FOUND OR IF PASSWORD DOES NOT MATCH
		if( !uServ.authenticateUser(postEmail, postPassword)) {
			redirectAttributes.addFlashAttribute("error", "INVALID CREDENTIALS");
			return "redirect:/login";
		}
//		FIND USER FROM DB AND THEN SET USER ID IN SESSION
		User loggedUser = uServ.findByEmail(postEmail);
		session.setAttribute("user_id", loggedUser.getId());
		return "redirect:/courses";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
	
}