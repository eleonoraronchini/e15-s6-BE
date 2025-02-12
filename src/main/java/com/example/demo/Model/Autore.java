package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Entity
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Autore {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;


    public Autore(String nome, String cognome, LocalDate dataDiNascita) {

        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
    }
}