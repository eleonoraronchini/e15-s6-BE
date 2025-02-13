package com.example.demo.Mapper;

import com.example.demo.DTO.AutoreDTO;
import com.example.demo.Model.Autore;
import org.springframework.stereotype.Component;

@Component
public class AutoreMapperDTO {

    public static AutoreDTO toDTO (Autore autore){
        AutoreDTO autoreDTO = new AutoreDTO();
        autoreDTO.setNome(autore.getNome());
        autoreDTO.setCognome(autore.getCognome());
        autoreDTO.setEmail(autore.getEmail());
        autoreDTO.setDataDiNascita(autore.getDataDiNascita());
        autoreDTO.setAvatar(autore.getAvatar());
        return autoreDTO;
    }

    public static Autore toEntity (AutoreDTO autoreDto){
        Autore autore = new Autore();
        autore.setNome(autoreDto.getNome());
        autore.setCognome(autoreDto.getCognome());
        autore.setEmail(autoreDto.getEmail());
        autore.setDataDiNascita(autoreDto.getDataDiNascita());
        autore.setAvatar(autoreDto.getAvatar());
        return autore;
    }
}
