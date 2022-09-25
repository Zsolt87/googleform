package com.example.googleform.client;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@AllArgsConstructor
public class RestClient {

    
    private final RestTemplate restTemplate;
}
