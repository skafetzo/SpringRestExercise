package com.learning.ote.spring.mvc.service;


import com.learning.ote.spring.mvc.domain.dto.AuthorDTO;
import com.learning.ote.spring.mvc.domain.entity.AuthorEntity;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    AuthorDTO findById(Long id);

    List<AuthorEntity> getAllAuthors();

    Optional<AuthorEntity> findAuthorByFirstNameAndLastName(String firstName, String lastName);

    AuthorDTO save(AuthorDTO authorDTO);

    List<AuthorDTO> findTop(Integer limit);

    List<AuthorDTO> FindByNameOrSurname(String firstName, String lastName);

    void delete(Long id);


}
