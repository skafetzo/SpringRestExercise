package com.learning.ote.spring.mvc.service;


import com.learning.ote.spring.mvc.domain.entity.AuthorEntity;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    AuthorEntity findById(Long id);

    List<AuthorEntity> getAllAuthors();

    Optional<AuthorEntity> findAuthorByFirstNameAndLastName(String firstName, String lastName);

}
