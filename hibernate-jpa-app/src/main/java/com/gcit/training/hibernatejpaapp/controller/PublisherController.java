package com.gcit.training.hibernatejpaapp.controller;

import java.util.List;
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

import com.gcit.training.hibernatejpaapp.dao.PublisherDao;
import com.gcit.training.hibernatejpaapp.entity.Publisher;

@RestController
@RequestMapping("/lms")
public class PublisherController {

	@Autowired
	private PublisherDao publisherDao;
	
	@GetMapping("/publisher")
	public List<Publisher> getAllPublisher() {
	    return publisherDao.findAll();
	}
	
	@GetMapping("/publisher/{pubilsherId}")
	public Optional<Publisher> getPublisherById(@PathVariable Integer publisherId) {
		return publisherDao.findById(publisherId);
	}
	
	// Create a new Note
	@PostMapping("/publisher")
	public Publisher createNote(@Valid @RequestBody Publisher publisher) {
	    return publisherDao.save(publisher);
	}
	
	@PutMapping("/publisher/{publisherId}")
	public Publisher updateNote(@Valid @RequestBody Publisher publisher, @PathVariable Integer publisherId) {
		publisher.setPublisherId(publisherId);
		return publisherDao.save(publisher);
	}
	
	@DeleteMapping("/publisher/{publisherId}")
	public void deleteNote(@PathVariable Integer publisherId) {
		publisherDao.deleteById(publisherId);
	}
	
}









