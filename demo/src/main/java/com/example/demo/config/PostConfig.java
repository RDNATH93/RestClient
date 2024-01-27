package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClient.Builder;

@Configuration
public class PostConfig {

    /*
     * created a @Bean of type AuthorizedClientServiceOAuth2AuthorizedClientManager
     * with ClientRegistrationRepository and OAuth2AuthorizedClientService
     * 
     * also setting up OAuth2AuthorizedClientProvider for client credential grant
     * type support
     * 
     */

    @Bean
    public RestClient restClient(RestClient.Builder builder) {

        // cloning RestClient builder because i need customize restclient for two clients
        Builder restClientBuilder = builder.clone();
        return restClientBuilder
                // .requestFactory(new JdkClientHttpRequestFactory())
                // .requestInterceptor(interceptor)
                .build();
    }
}
