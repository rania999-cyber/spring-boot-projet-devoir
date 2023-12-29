package com.example.Service;

import java.util.List;

import com.example.Entity.Book;

public interface BookService {

    // Récupérer la liste de tous les livres
    List<Book> getAllBooks();

    // Récupérer un livre par son ID
    Book getBookById(Long id);

    // Ajouter un nouveau livre
    void addBook(Book book);

    // Mettre à jour les informations d'un livre existant
    void updateBook(Long id, Book updatedBook);

    // Supprimer un livre par son ID
    void deleteBook(Long id);
}


