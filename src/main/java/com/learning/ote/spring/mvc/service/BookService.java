package com.learning.ote.spring.mvc.service;

import com.learning.ote.spring.mvc.domain.entity.AuthorEntity;
import com.learning.ote.spring.mvc.domain.entity.BookEntity;
import com.learning.ote.spring.mvc.domain.dto.BookDTO;

import java.util.List;

public interface BookService {

    BookDTO findById(Long id);

    List<BookDTO> findAll();

    List<BookEntity> findByAuthor(AuthorEntity author);

    List<BookEntity> findByAuthorAndYear(AuthorEntity author, String year);

    List<BookDTO> findByTitle(String title);

    BookDTO save(BookDTO bookDTO);

}
