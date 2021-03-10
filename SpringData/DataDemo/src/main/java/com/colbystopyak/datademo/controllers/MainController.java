package com.colbystopyak.datademo.controllers;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.colbystopyak.datademo.models.Book;
import com.colbystopyak.datademo.services.BookService;

//@Controller
public class MainController {
	
	private final BookService bookServ;
	
	
	public MainController(BookService bookServ) {
		super();
		this.bookServ = bookServ;
	}


	@GetMapping("")
	public String index(Model model) {
		 List<Book> allBooks = bookServ.getallBooks();
		 model.addAttribute("books", allBooks);
		return "index.jsp";
	}
	
	@PostMapping("/books/new")
	public String create(@RequestParam(value="title") String title,
			@RequestParam(value="description") String description,
			@RequestParam(value="language") String language,
			@RequestParam(value="numOfPages") Integer numOfPages) {
		bookServ.createBook(title, description, language, numOfPages);
		return "redirect:/";
	}
//	@RequestMapping("/show/{id}")
//	public String show(@PathVariable("id") Long id, Model model) {
//		Book book = bookServ.findBook(id);
//		model.addAttribute("books", book);
//		return"show.jsp";
//	}
	

}
