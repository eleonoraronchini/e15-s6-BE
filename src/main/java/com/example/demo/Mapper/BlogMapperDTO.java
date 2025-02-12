package com.example.demo.Mapper;

import com.example.demo.DTO.BlogDTO;
import com.example.demo.Model.Blog;
import org.springframework.stereotype.Component;

@Component
public class BlogMapperDTO {

    public static BlogDTO toDTO (Blog blog){
        BlogDTO blogDTO = new BlogDTO();
        blogDTO.setTitolo(blog.getTitolo());
        blogDTO.setContenuto(blog.getContenuto());
        blogDTO.setCategoria(blog.getCategoria());
        blogDTO.setTempoDiLettura(blog.getTempoDiLettura());
     return blogDTO;
    }

    public static Blog toEntity (BlogDTO blogDTO){
        Blog blog = new Blog();
        blog.setTitolo(blogDTO.getTitolo());
        blog.setContenuto(blogDTO.getContenuto());
        blog.setCategoria(blogDTO.getCategoria());
        blog.setTempoDiLettura(blogDTO.getTempoDiLettura());
      return blog;
    }
}
