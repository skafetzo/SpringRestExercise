package com.learning.ote.spring.mvc.repository;

import com.learning.ote.spring.mvc.domain.entity.AuthorEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {

    Optional<AuthorEntity> findAuthorByFirstNameAndLastName(String firstName, String lastName);

    List<AuthorEntity> findAllByOrderByLastName(Pageable pageable);

    List<AuthorEntity> findAllByOrderByLastName();

    List<AuthorEntity> findByFirstNameStartsWithAndLastNameStartsWith(String firstName, String lastName);

    List<AuthorEntity> findByFirstNameStartsWith(String firstName);

    List<AuthorEntity> findByLastNameStartsWith(String lastName);


}
