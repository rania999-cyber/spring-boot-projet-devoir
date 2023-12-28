package com.example.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Book;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @GetMapping
    public String getAllBooks() {
        return "List of all books";
    }

    @GetMapping("/{id}")
    public String getBookById(@PathVariable Long id) {
         
        return "Details for book with ID: " + id;
    }

     
    @PostMapping
    public String addBook(@RequestBody Book book) {
         
        return "Book added successfully";
    }

    @PutMapping("/{id}")
    public String updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        
        return "Book with ID " + id + " updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
         
        return "Book with ID " + id + " deleted successfully";
    }
}

