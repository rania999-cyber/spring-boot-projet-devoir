package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.Emprunt;

public interface EmpruntRepository extends JpaRepository<Emprunt, Integer> {
}

