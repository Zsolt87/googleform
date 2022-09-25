package com.example.googleform.client;

import com.example.googleform.model.Event;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Optional;

@Component
@Slf4j
public class EventServiceRestClient {

    private final String host;
    private final int port;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public EventServiceRestClient(@Value("${googleform.event-service.host}") String host,
                                  @Value("${googleform.event-service.port}") int port,
                                  RestTemplate restTemplate,
                                  ObjectMapper objectMapper) {
        this.host = host;
        this.port = port;
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @SneakyThrows
    public Optional<Event> getEventById(String id) {
        URI uri = new URI(String.format("%s:%s/api/eventEntities/%s", host, port, id));

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-type", "application/json");

        HttpEntity<Void> requestEntity = new HttpEntity<>(null, headers);

        ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);

        if (result.getStatusCode().toString().startsWith("2")) {
            return Optional.ofNullable(objectMapper.readValue(result.getBody(), Event.class));
        } else {
            log.warn("Event service reponse was not successful: {}", result);
            return Optional.empty();
        }
    }

}
