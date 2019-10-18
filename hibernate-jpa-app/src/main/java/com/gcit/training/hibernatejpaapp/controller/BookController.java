package com.gcit.training.hibernatejpaapp.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcit.training.hibernatejpaapp.dao.BookDao;
import com.gcit.training.hibernatejpaapp.entity.Book;

@RestController
@RequestMapping("/lms")
public class BookController {

	@Autowired
	private BookDao bookDao;
	
	@GetMapping("/book/{bookId}")
	public Optional<Book> getBookById(@PathVariable Integer bookId) {
		return bookDao.findById(bookId);
	}
	
	// Create a new Note
	@PostMapping("/book")
	public Book createNote(@Valid @RequestBody Book book) {
	    return bookDao.save(book);
	}
	
	@PutMapping("/book/{bookId}")
	public Book updateNote(@Valid @RequestBody Book book, @PathVariable Integer bookId) {
		book.setBookId(bookId);
		return bookDao.save(book);
	}
	
	@DeleteMapping("/book/{bookId}")
	public void deleteNote(@PathVariable Integer bookId) {
		bookDao.deleteById(bookId);
	}
}