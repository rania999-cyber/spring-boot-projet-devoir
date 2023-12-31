package com.example.Entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

 
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "Emprunt")
public class Emprunt {
 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(nullable = false, name = "date_debut")
    private LocalDate date_debut;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(nullable = false, name= "date_fin")
    private LocalDate date_fin;


}
