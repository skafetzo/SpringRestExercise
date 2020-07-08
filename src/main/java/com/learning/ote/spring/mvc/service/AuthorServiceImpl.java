package com.learning.ote.spring.mvc.service;

import com.learning.ote.spring.mvc.converter.AuthorConverter;
import com.learning.ote.spring.mvc.converter.BookConverter;
import com.learning.ote.spring.mvc.domain.dto.AuthorDTO;
import com.learning.ote.spring.mvc.domain.dto.BookDTO;
import com.learning.ote.spring.mvc.domain.entity.AuthorEntity;
import com.learning.ote.spring.mvc.domain.entity.BookEntity;
import com.learning.ote.spring.mvc.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    private AuthorRepository authorRepository;


    @Override
    public List<AuthorEntity> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public AuthorDTO findById(Long id) {

        AuthorEntity author;
        AuthorDTO authorDTO;
        try {
            author = authorRepository.findById(id).get();
            authorDTO = AuthorConverter.convert(author);

        } catch (NoSuchElementException e) {
            return null;
        }

        return authorDTO;
    }

    @Override
    public Optional<AuthorEntity> findAuthorByFirstNameAndLastName(String firstName, String lastName) {
        return authorRepository.findAuthorByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public AuthorDTO save(AuthorDTO authorDTO) {
        AuthorEntity author = AuthorConverter.convert(authorDTO);
        authorRepository.save(author);
        return AuthorConverter.convert(author);
    }

    @Override
    public List<AuthorDTO> findTop(Integer limit) {
        List<AuthorEntity> authors;

        if (limit==null){
            authors = authorRepository.findAllByOrderByLastName();
        } else {
            Pageable pageable = PageRequest.of(0, limit);
            authors = authorRepository.findAllByOrderByLastName(pageable);
        }
        return authors.stream()
                .map(AuthorConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public List<AuthorDTO> FindByNameOrSurname(String firstName, String lastName) {
        List<AuthorEntity> authors = new ArrayList<>();

        if(firstName!=null && lastName!=null){
            authors = authorRepository.findByFirstNameStartsWithAndLastNameStartsWith(firstName, lastName);
        }
        else if(firstName!=null && lastName==null) {
            authors = authorRepository.findByFirstNameStartsWith(firstName);
        }
        else if(firstName==null && lastName!=null) {
            authors = authorRepository.findByLastNameStartsWith(lastName);
        }

        return authors.stream()
                .map(AuthorConverter::convert)
                .collect(Collectors.toList());

    }

   @Override
    public void delete(Long id) {

        authorRepository.deleteById(id);
    }


}
