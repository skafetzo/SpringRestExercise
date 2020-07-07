package com.learning.ote.spring.mvc.controller;

import com.learning.ote.spring.mvc.domain.dto.AuthorDTO;
import com.learning.ote.spring.mvc.domain.dto.BookDTO;
import com.learning.ote.spring.mvc.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public AuthorDTO create(@RequestBody AuthorDTO authorDTO) {
        return authorService.save(authorDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDTO> updateAuthor(@RequestBody AuthorDTO authorDTO, @PathVariable("id") Long authorId){

        AuthorDTO author = authorService.

    }




    @DeleteMapping("{id}")
    void deleteAuthor(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
