package com.example.Service;

import java.util.List;

import com.example.Entity.Book;


public interface BookService {

 
    List<Book> getAllBooks();

    Book getBookById(Long id);

    void addBook(Book book);

    void updateBook(Long id, Book updatedBook);

    void deleteBook(Long id);
}

