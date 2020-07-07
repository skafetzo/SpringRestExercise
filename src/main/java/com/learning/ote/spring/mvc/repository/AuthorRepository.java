package com.learning.ote.spring.mvc.repository;

import com.learning.ote.spring.mvc.domain.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {

    Optional<AuthorEntity> findAuthorByFirstNameAndLastName(String firstName, String lastName);

}
