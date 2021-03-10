package com.colbystopyak.datademo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.colbystopyak.datademo.models.Book;
import com.colbystopyak.datademo.services.BookService;

@Controller
public class BindController {
	
	private final BookService bookServ;
	
	
	public BindController(BookService bookServ) {
		super();
		this.bookServ = bookServ;
	}


	@GetMapping("")
	public String index(Model model, @ModelAttribute("book") Book emptybook) {
		 List<Book> allBooks = bookServ.getallBooks();
		 model.addAttribute("books", allBooks);
		return "indexbind.jsp";
	}
	
	@PostMapping("/books/new")
	public String create(@Valid @ModelAttribute("book") Book filledBook, BindingResult results) {
		if(results.hasErrors()) {
			return "indexbind.jsp";
		}
		bookServ.createBook(filledBook);
		return "redirect:/";
	}
	
//	@RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
//    public String update(@Valid @ModelAttribute("book") Book filledbook, BindingResult result) {
//        if (result.hasErrors()) {
//            return "/books/edit.jsp";
//        } else {
//            bookServ.updateBook(filledbook);
//            return "redirect:/books";
//        }
//    }
    
    @RequestMapping(value="/books/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        bookServ.deleteBook(id);
        return "redirect:/books";
    }
    
    @RequestMapping("/books/show/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Book book = bookServ.findBook(id);
		model.addAttribute("books", book);
		return"show.jsp";
	}

}
