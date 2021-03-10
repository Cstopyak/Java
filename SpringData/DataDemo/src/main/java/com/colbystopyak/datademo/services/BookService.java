package com.colbystopyak.datademo.services;

import java.util.List;
//import java.util.Optional;
import java.util.Optional;

import javax.swing.text.html.Option;
import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.colbystopyak.datademo.models.Book;
import com.colbystopyak.datademo.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public List<Book> getallBooks() {
		return bookRepository.findAll();
	}

	public Book findBook(Long id) {
//	        Optional<Book> optionalBook = bookRepository.findById(id);
//	        if(optionalBook.isPresent()) {
//	            return optionalBook.get();
//	        } else {
//	            return null;
//	        }
		return bookRepository.findById(id).orElse(null);
	}

	public void createBook(String title, String description, String language, Integer numOfPages) {
		// TODO Auto-generated method stub
		Book newBook = new Book(title, description, language, numOfPages);
		bookRepository.save(newBook);
	}

	public void createBook(Book filledBook) {
		// TODO Auto-generated method stub
		bookRepository.save(filledBook);
	}

	public void deleteBook(Long id) {
		// TODO Auto-generated method stub
		bookRepository.deleteById(id);
	}

//	public void updateBook(@Valid Book filledBook) {
//		// TODO Auto-generated method stub
//		Optional<Book> updbook = bookRepository.findById(filledBook);
//		if (updbook != null) {
//			updbook.get().setTitle(title);
//
//			return Book.get();
//		}
//		return;
//	}

}
