package com.example.Controller;

import com.example.Entity.Book;
import com.example.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Endpoint pour récupérer tous les livres
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    // Endpoint pour récupérer un livre par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        // Vérifie si le livre existe et renvoie la réponse appropriée
        return book != null ? ResponseEntity.ok(book) : ResponseEntity.notFound().build();
    }

    // Endpoint pour ajouter un nouveau livre
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body("Book added successfully");
    }

    // Endpoint pour mettre à jour un livre existant
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        bookService.updateBook(id, updatedBook);
        return ResponseEntity.ok("Book with ID " + id + " updated successfully");
    }

    // Endpoint pour supprimer un livre par son ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok("Book with ID " + id + " deleted successfully");
    }
}


