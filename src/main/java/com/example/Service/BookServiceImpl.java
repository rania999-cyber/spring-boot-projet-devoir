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

    // Récupérer la liste de tous les livres
    @Override
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    // Récupérer un livre par son ID
    @Override
    public Book getBookById(Long id) {
        return bookRepo.findById(id).orElse(null);
    }

    // Ajouter un nouveau livre
    @Override
    public void addBook(Book book) {
        bookRepo.save(book);
    }

    // Mettre à jour les informations d'un livre existant
    @Override
    public void updateBook(Long id, Book updatedBook) {
        // La méthode save() peut être utilisée pour ajouter un nouveau livre ou mettre à jour un livre existant
        // Elle enregistre l'entité fournie dans la base de données
        bookRepo.save(updatedBook);
    }

    // Supprimer un livre par son ID
    @Override
    public void deleteBook(Long id) {
        bookRepo.deleteById(id);
    }
}

