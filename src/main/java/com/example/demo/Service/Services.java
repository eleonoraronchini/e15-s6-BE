package com.example.demo.Service;

import com.example.demo.DTO.BlogDTO;
import com.example.demo.Mapper.BlogMapperDTO;
import com.example.demo.Model.Blog;
import com.example.demo.Repository.AutoreRepository;
import com.example.demo.Repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class Services {
    @Autowired
    AutoreRepository autoreRepository;
    @Autowired
    BlogRepository blogRepository;
    @Autowired
    BlogMapperDTO blogMapperDTO;

    @GetMapping
    public Page<BlogDTO> getAllBlog (Pageable pageable){
        return blogRepository.findAll(pageable).map(BlogMapperDTO::toDTO);
    }
    public BlogDTO createBlog (BlogDTO blogDTO){
      Blog b = blogMapperDTO.toEntity(blogDTO);
      blogRepository.save(b);
      return blogDTO;
    }
}
