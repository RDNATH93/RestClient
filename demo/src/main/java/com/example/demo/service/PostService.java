package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.example.demo.model.Post;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PostService {

    @Autowired
    private RestClient restClient;

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${post.endpoint}")
    private String postEndpoint;

    public Post getPostById(Integer id) {
        return restClient.get()
                .uri(postEndpoint + "/" + id)
                .retrieve()
                .body(Post.class);
    }

    public Post createPost(Post post) {
        return restClient.post()
                .uri(postEndpoint)
                .body(post)
                .retrieve()
                .body(Post.class);
    }
}
