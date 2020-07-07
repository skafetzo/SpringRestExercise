package com.learning.ote.spring.mvc.controller;

import com.learning.ote.spring.mvc.domain.dto.AuthorDTO;
import com.learning.ote.spring.mvc.domain.dto.BookDTO;
import com.learning.ote.spring.mvc.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorRestController {

    @Autowired
    AuthorService authorService;
    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> findById(@PathVariable("id") Long authorId) {
       AuthorDTO authorDTO = authorService.findById(authorId);

        return ResponseEntity
                .status((authorDTO != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND)
                .body(authorDTO);
    }

    @PostMapping
    public ResponseEntity<AuthorDTO> create(@RequestBody AuthorDTO authorDTO) {

        if (authorDTO.getId() != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(authorDTO);
        }
        AuthorDTO createdAuthorDTO =  authorService.save(authorDTO);
        return ResponseEntity
                .status( HttpStatus.CREATED)
                .body(createdAuthorDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDTO> updateAuthor(@RequestBody AuthorDTO authorDTO, @PathVariable("id") Long authorId){

        authorDTO.setId(authorId);
        AuthorDTO updatedAuthorDTO = authorService.save(authorDTO);
        return ResponseEntity
                .status( HttpStatus.OK)
                .body(updatedAuthorDTO);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {

        authorService.delete(id);
        return ResponseEntity.ok().build();

    }

    @GetMapping
    public ResponseEntity<List<AuthorDTO>> findTop(@RequestParam(required = false) Integer limit,
                                                   @RequestParam(required = false) String firstName,
                                                   @RequestParam(required = false) String lastName) {

        List<AuthorDTO> authorDTOs = authorService.findByParameters(limit, firstName, lastName);

        return ResponseEntity
                .status( HttpStatus.OK)
                .body(authorDTOs);
    }
}
