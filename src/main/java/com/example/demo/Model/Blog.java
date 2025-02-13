package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Entity(name = "blogposts")
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoria;
    private String titolo;
    private String contenuto;
    private Long tempoDiLettura;
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Autore autore;
    private String cover;

}
