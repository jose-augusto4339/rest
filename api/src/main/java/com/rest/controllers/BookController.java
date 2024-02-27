package com.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.data.vo.v1.BookVO;
import com.rest.services.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService service;

	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
	public List<BookVO> findAll() {
		return service.findAll();
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public BookVO findById(@PathVariable Long id) {
		return service.findById(id);
	}

	@PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public BookVO create(@RequestBody BookVO book) {
		return service.create(book);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public BookVO update(@RequestBody BookVO book) {
		return service.update(book);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}