package com.example.demo.Controller;

import com.example.demo.DTO.BlogDTO;
import com.example.demo.Service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BlogController {

    @Autowired
    Services services;
    @PostMapping("/blog")
    public BlogDTO cretaeBlog (@RequestBody BlogDTO blogDTO){
        if(blogDTO.getTitolo() == null) {
            throw new RuntimeException("Non è possibile creare un blog senza titolo.");
        } return services.createBlog(blogDTO);



    }
}
