package com.rent.read.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rent.read.entity.Books;
import com.rent.read.repository.BookRepository;

@RestController
@RequestMapping("/admin")
public class BookController {

	@Autowired
    private BookRepository bookRepository;

    @PostMapping("/books")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Books> addBook(@RequestBody Books book) {
        Books savedBook = bookRepository.save(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @GetMapping("/books")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Books> getAllBooks() {
        return bookRepository.findAll();
    }
}
