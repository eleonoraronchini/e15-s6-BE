package com.example.demo.Service;

import com.example.demo.DTO.AutoreDTO;
import com.example.demo.DTO.BlogDTO;
import com.example.demo.Mapper.AutoreMapperDTO;
import com.example.demo.Mapper.BlogMapperDTO;
import com.example.demo.Model.Autore;
import com.example.demo.Model.Blog;
import com.example.demo.Repository.AutoreRepository;
import com.example.demo.Repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

import static com.example.demo.Mapper.AutoreMapperDTO.toEntity;

@Service
public class Services {
    @Autowired
    AutoreRepository autoreRepository;
    @Autowired
    BlogRepository blogRepository;
    @Autowired
    BlogMapperDTO blogMapperDTO;
    @Autowired
    AutoreMapperDTO autoreMapperDTO;

    @GetMapping
    public Page<BlogDTO> getAllBlog (Pageable pageable){
        return blogRepository.findAll(pageable).map(BlogMapperDTO::toDTO);
    }
    public BlogDTO createBlog (BlogDTO blogDTO){
      Blog b = blogMapperDTO.toEntity(blogDTO);
      blogRepository.save(b);
      return blogDTO;
    }

    public AutoreDTO createAutore (AutoreDTO autoreDTO){
        Autore a = autoreMapperDTO.toEntity(autoreDTO);
       autoreRepository.save(a);
       return autoreDTO;

    }

    public Long nuovoAutore (AutoreDTO nuovoAutoreDTO){
        Autore autoreInserito = toEntity(nuovoAutoreDTO);
        return autoreRepository.save(autoreInserito).getId();
    }

    public Optional<Autore> ricercaAutoreId(Long id){
        Optional<Autore> autoreRecuperato = autoreRepository.findById(id);
        return autoreRecuperato;
    }


}
