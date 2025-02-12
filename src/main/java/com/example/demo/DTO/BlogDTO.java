package com.example.demo.DTO;

import com.example.demo.Model.Autore;
import lombok.Data;

@Data
public class BlogDTO {
    private String categoria;
    private String titolo;
    private String contenuto;
    private Long tempoDiLettura;
    private Autore autore;
}
