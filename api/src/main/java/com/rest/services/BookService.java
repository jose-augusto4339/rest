package com.rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.data.vo.v1.BookVO;
import com.rest.exceptions.ResourceNotFoundException;
import com.rest.mapper.DozerMapper;
import com.rest.model.Book;
import com.rest.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository repository;

	public List<BookVO> findAll() {

		return DozerMapper.parseListObject(repository.findAll(), BookVO.class);
	}

	public BookVO findById(Long id) {

		Book entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Nenhum livro encontrado para o ID passado."));
		
		return DozerMapper.parseObject(entity, BookVO.class);
	}

	public BookVO create(BookVO book) {
		Book entity = DozerMapper.parseObject(book, Book.class);
		BookVO vo = DozerMapper.parseObject(repository.save(entity), BookVO.class);
		return vo;
	}

	public BookVO update(BookVO book) {

		Book entity = repository.findById(book.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Nenhum livro encontrado para o ID passado."));
		
		entity.setName(book.getName());
		BookVO vo = DozerMapper.parseObject(repository.save(entity), BookVO.class);
		return vo;
	}

	public void delete(Long id) {
    
		Book entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Nenhum livro encontrado para o ID passado."));
		
		repository.delete(entity);
	}
}
