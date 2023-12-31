package com.example.Service;

import com.example.Entity.Emprunt;

import java.util.List;

public interface EmpruntService {
    List<Emprunt> getAll();
    Emprunt getById(int id);
    Emprunt update(Emprunt emprunt, int id);
    void delete(int id);
    Emprunt save(Emprunt empEntity);
}

