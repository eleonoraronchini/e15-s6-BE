package com.example.demo.DTO;

import lombok.Data;

@Data
public class BlogDTO {
    private String categoria;
    private String titolo;
    private String contenuto;
    private Long tempoDiLettura;
}
