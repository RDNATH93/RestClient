package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.test.web.client.MockRestServiceServer;

import com.example.demo.model.Post;
import com.example.demo.service.PostService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RestClientTest(PostService.class)
class PostServiceTest {

    @Autowired
    MockRestServiceServer server;

    @Autowired
    PostService postService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void shouldReturnAPosts() throws JsonProcessingException {
        // given
        Post data = new Post(1, 1, "Hello, World!", "This is my first post!");

        // when
        this.server
                .expect(requestTo("https://jsonplaceholder.typicode.com/posts/1"))
                .andRespond(withSuccess(objectMapper.writeValueAsString(data), MediaType.APPLICATION_JSON));

        // then
        Post post = postService.getPostById(1);
        assertThat(post.userId()).isEqualTo(1);
    }

}

/*
 *  is it possible to do like this
 *  @Mock
 *   RestClient restClient;
 * 
 *  Mockito.when(restClient.get()
 *                         .uri(ArgumentMatchers.anyString())
 *                         .retrieve()
 *                         .body(ArgumentMatchers.any()) 
 *              ).thenReturn(post);
 * 
 */