package com.example.googleform.client;

import com.example.googleform.model.Event;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EventServiceRestClientTest {

    private static final String HOST = "testhost";
    private static final int PORT = 8080;
    private static final ObjectMapper OBJECTMAPPER = new ObjectMapper();

    @Mock
    private RestTemplate restTemplate;

    private EventServiceRestClient underTest;

    @BeforeAll
    static void beforeAllTest(){
        OBJECTMAPPER.registerModule(new JavaTimeModule());
    }

    @BeforeEach
    void initBeforeEachTest(){
        underTest = new EventServiceRestClient(HOST,PORT,restTemplate, OBJECTMAPPER);
    }

    @Test
    @SneakyThrows
    void shouldEventClientReturnEventWhenEventPresented() {
        //Given
        String testId = "123e4567-e89b-12d3-a456-426614174000";
        URI uri = new URI(HOST + ":" +PORT + "/api/eventEntities/" + testId);

        Mockito.when(restTemplate.exchange(Mockito.eq(uri), Mockito.eq(HttpMethod.GET), Mockito.any(), Mockito.eq(String.class)))
                .thenReturn(ResponseEntity.ok("""
                        {
                                        "id": "123e4567-e89b-12d3-a456-426614174000",
                        				"instant": "2022-08-20T09:30:28.673680Z",
                        				"name": "Formula 1"
                        				
                        			}
                        """));

        //When
        Optional<Event> eventOptional = underTest.getEventById(testId);

        //Then
        assertTrue(eventOptional.isPresent());
        assertEquals(testId, eventOptional.get().getId().toString());
    }

    @Test
    @SneakyThrows
    void shouldEventClientReturnEventWhenExternalServiceNotAvailable() {
        //Given
        String testId = "123e4567-e89b-12d3-a456-426614174000";
        URI uri = new URI(HOST + ":" +PORT + "/api/eventEntities/" + testId);

        Mockito.when(restTemplate.exchange(Mockito.eq(uri), Mockito.eq(HttpMethod.GET), Mockito.any(), Mockito.eq(String.class)))
                .thenReturn(ResponseEntity.internalServerError().build());

        //When
        Optional<Event> eventOptional = underTest.getEventById(testId);

        //Then
        assertTrue(eventOptional.isEmpty());
    }
}