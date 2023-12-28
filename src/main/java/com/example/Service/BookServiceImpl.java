package com.example.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Entity.Book;
import com.example.Repository.BookRepo;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepo bookRepo;

    @Override
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepo.findById(id).orElse(null);
    }

    @Override
    public void addBook(Book book) {
        bookRepo.save(book);
    }

    @Override
    public void updateBook(Long id, Book updatedBook) {
         bookRepo.save(updatedBook);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepo.deleteById(id);
    }
}

