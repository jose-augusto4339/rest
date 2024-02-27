package com.rest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="book")
public class Book extends BaseMedia{

	private static final long serialVersionUID = 1L;
	
	public Book() {
		super();
	}

	public Book(Long id, String name) {
		super(id, name);
	}
	
	
}
