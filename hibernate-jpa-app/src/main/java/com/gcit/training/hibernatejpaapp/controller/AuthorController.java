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

import com.gcit.training.hibernatejpaapp.dao.AuthorDao;
import com.gcit.training.hibernatejpaapp.entity.Author;

@RestController
@RequestMapping("/lms")
public class AuthorController {

	@Autowired
	private AuthorDao authorDao;
	
	@GetMapping("/author/{pubilsherId}")
	public Optional<Author> getAuthorById(@PathVariable Integer authorId) {
		return authorDao.findById(authorId);
	}
	
	// Create a new Note
	@PostMapping("/author")
	public Author createNote(@Valid @RequestBody Author author) {
	    return authorDao.save(author);
	}
	
	@PutMapping("/author/{authorId}")
	public Author updateNote(@Valid @RequestBody Author author, @PathVariable Integer authorId) {
		author.setAuthorId(authorId);
		return authorDao.save(author);
	}
	
	@DeleteMapping("/author/{authorId}")
	public void deleteNote(@PathVariable Integer authorId) {
		authorDao.deleteById(authorId);
	}
}
