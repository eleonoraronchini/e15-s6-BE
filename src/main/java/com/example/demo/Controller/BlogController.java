package com.example.demo.Controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.demo.DTO.AutoreDTO;
import com.example.demo.DTO.BlogDTO;
import com.example.demo.Model.Autore;
import com.example.demo.Service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BlogController {

    @Autowired
    Services services;
    @Autowired
    Cloudinary cloudinary;

    @PostMapping("/blog")
    @ResponseStatus(HttpStatus.CREATED)
    public BlogDTO cretaeBlog(@RequestBody BlogDTO blogDTO) {
        if (blogDTO.getTitolo() == null) {
            throw new RuntimeException("Non è possibile creare un blog senza titolo.");
        }
        return services.createBlog(blogDTO);

    }

    @PostMapping("/autore")
    @ResponseStatus(HttpStatus.CREATED)
    public AutoreDTO createAutore(@RequestBody AutoreDTO autoreDTO) {
        if (autoreDTO.getNome() == null) {
            throw new RuntimeException("Non è stato possibile creare autore. Inserisci il nome.");
        }
        return services.createAutore(autoreDTO);

    }

    @GetMapping("/byId/{idAutore}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Autore> ricercaById(@PathVariable Long idAutore) {
        Optional<Autore> autoreRicercato = services.ricercaAutoreId(idAutore);
        if (autoreRicercato.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(autoreRicercato.get(), HttpStatus.OK);

        }
    }

    // autore con avatar
    @PostMapping("/nuovoAutoreConAvatar")
    public AutoreDTO nuovoAutoreconAvatar(@RequestPart("avatarAutore") MultipartFile avatarAutore, @RequestPart @Validated AutoreDTO autoreDTO, BindingResult validazione){

        if(validazione.hasErrors()){
            String messaggioErr = "errore validazione \n";
            for (ObjectError errore : validazione.getAllErrors()){
                messaggioErr += errore.getDefaultMessage() + " \n";
            }
        }
        try {
            Map mappa = cloudinary.uploader().upload(avatarAutore.getBytes(), ObjectUtils.emptyMap());
            // Recupero l'invio
            String urlImage = (String) mappa.get("secure_url");
            autoreDTO.setAvatar(urlImage);
            Long idGenerato = services.nuovoAutore(autoreDTO);
            return autoreDTO;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}