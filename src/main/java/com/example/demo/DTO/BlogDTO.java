package com.example.demo.DTO;

import com.example.demo.Model.Autore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BlogDTO {
    @NotBlank(message = "'categoria' non può essere dei caratteri vuoti")
    @NotNull(message = "'categoria' non può essere vuota")
    private String categoria;
    @NotBlank(message = "'titolo' non può essere dei caratteri vuoti")
    @NotNull(message = "'titolo' non può essere vuota")
    private String titolo;
    @NotBlank(message = "'contenuto' non può essere dei caratteri vuoti")
    @NotNull(message = "'contenuto' non può essere vuota")
    private String contenuto;
    @NotNull(message = "'tempoDiLettura' non può essere null")
    private Long tempoDiLettura;
    @NotNull(message = "'Autore' non può essere vuoto")
    private Autore autore;
    private String cover;
}
