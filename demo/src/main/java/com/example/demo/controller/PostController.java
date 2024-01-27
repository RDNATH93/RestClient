package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Post;
import com.example.demo.service.PostService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/v1")
public class PostController {

    @Autowired
    private PostService postSevice;

    // other fields annotated with @Value initialized with value from .yml file

    // other service classes with @Autowired annotation

    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Integer id) {
        Post post = postSevice.getPostById(id);
        return new ResponseEntity<Post>(post, HttpStatus.OK);
    }

    @PostMapping("/posts/add")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post createdPost = postSevice.createPost(post);
        return new ResponseEntity<Post>(createdPost, HttpStatus.CREATED);
    }
}
