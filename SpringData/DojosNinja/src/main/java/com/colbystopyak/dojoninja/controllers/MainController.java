package com.colbystopyak.dojoninja.controllers;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.colbystopyak.dojoninja.models.Dojo;
import com.colbystopyak.dojoninja.models.Ninja;
import com.colbystopyak.dojoninja.services.DojoNinjaService;

@Controller
public class MainController {

	@Autowired
	private DojoNinjaService mainServe;

	// Create a Dojo
	@GetMapping("/dojos/new")
	public String index(@ModelAttribute("dojoobj") Dojo emptyDojo) {
		return "index.jsp";
	}

	@PostMapping("/dojos/new")
	public String createDojo(@Valid @ModelAttribute("dojoobj") Dojo filledDojo, BindingResult results) {
		// checking for errors
		if (results.hasErrors()) {
			// if valids fail, render page
			return "index.jsp";
		}
//		mainServe.createNinja();
//		return"redirect:/ninjas/new";
//		
		
		// valids are correct, create a dojo
		Dojo newDojo = mainServe.createDojo(filledDojo);
		String id = Long.toString(newDojo.getId());
		return "redirect:/dojos/" + id;
	}
	
	//create a ninja
	@GetMapping("/ninjas/new")
	public String index(@ModelAttribute("ninjaobj") Ninja emptyNinja, Model model) {
		List<Dojo>alldojos= mainServe.getAllDojosById();
		model.addAttribute("AllDojo", alldojos);
		
		return "ninja.jsp";
	}
	
	@PostMapping("/ninjas/new")
	public String createDojo(@Valid @ModelAttribute("ninjaobj") Ninja filledNinja, BindingResult results, Model model) {
		// checking for errors
		if (results.hasErrors()) {
			List<Dojo>alldojos= mainServe.getAllDojosById();
			model.addAttribute("AllDojo", alldojos);
			return "ninja.jsp";
		}
		else {
			// valids are correct, create a dojo
			Ninja newNinja = mainServe.createNinja(filledNinja);
			String id = Long.toString(newNinja.getId());
			return "redirect:/ninjas/new";
		}
	}
	//Show the Dojos
	
	@GetMapping("/dojos/{id}")
	public String dojoDetail(@PathVariable("id") Long dojo_id, Model model) {
		//check to see if this works
//		System.out.println(id);
		Dojo oneDojo = mainServe.findDojoById(dojo_id);
		//pass one show to JSP
		model.addAttribute("dojo", oneDojo);
		return "dojos.jsp";
	}
	
	//show ninja take out
	
	@GetMapping("/ninjas/{id}")
	public String ninjaDetail(@PathVariable("id") Long id, Model model) {
		//check to see if this works
//		System.out.println(id);
		
		Ninja oneNinja = mainServe.findNinjaById(id);
		//pass one show to JSP
		model.addAttribute("Ninja", oneNinja);
		return "ninja.jsp";
	}
}
