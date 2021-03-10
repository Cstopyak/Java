package com.colbystopyak.language.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.colbystopyak.language.models.Language;
import com.colbystopyak.language.services.MainService;

@Controller
public class MainController {
	private final MainService languageService;

	public MainController(MainService languageService) {
		this.languageService = languageService;
	}

//creating route

	@GetMapping("/")
	public String index(Model model, @ModelAttribute("language") Language emptylanguage) {
		List<Language> languages = languageService.getAllLanguage();
		model.addAttribute("languages", languages);
		return "index.jsp";
	}

//Creating Route
//@RequestMapping(value="languages", method=RequestMethod.POST)
//@PostMapping("languages/new")
//public String create{
//	@RequestParam(value="name") String name,
//	@RequestParam(value="creator") String creator,
//	@RequestParam(value="version") Integer version,
//	)
//}

	@PostMapping("/languages/new")
	public String create(@Valid @ModelAttribute("language") Language filledlanguage, BindingResult result,
			Model model) {

		languageService.createLanguage(filledlanguage);
		System.out.println(filledlanguage);
		return "redirect:/";
	}

	// editing route
	@GetMapping("/languages/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Language editlanguage = languageService.findLanguageById(id);
		model.addAttribute("Language", editlanguage);
		return "edit.jsp";
	}

	@PostMapping("/languages/edit/{id}")
	public String update(@Valid @ModelAttribute("Language") Language language, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			languageService.updateLanguage(language);
			return "redirect:/";

		}
	}

	@GetMapping("/languages/show/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Language showlanguage = languageService.findLanguageById(id);
		model.addAttribute("Language", showlanguage);
		return "show.jsp";
	}
	
	@PostMapping("/languages/show/{id}")
	public String show(@Valid @ModelAttribute("Language") Language language, BindingResult result) {
		if (result.hasErrors()) {
			return "show.jsp";
		}
			return "redirect:/";

		
	}

	// delete route

	@RequestMapping("/languages/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		languageService.deleteLanguageById(id);
		return "redirect:/";
	}
	
//	@DeleteMapping("/shows/{id}")
//		public String deleteShow(@PathVariable("id")Long id) {
//		languageService.deleteShowById(id)
//		return"redirect:/";
//	}
}
