package com.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
