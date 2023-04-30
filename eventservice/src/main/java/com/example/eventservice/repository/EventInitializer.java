package com.example.eventservice.repository;

import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

@Component
@AllArgsConstructor
public class EventInitializer implements ApplicationListener<ContextRefreshedEvent> {

    final EventRepository repository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        repository.save(EventEntity.builder()
                .name("Formula 1")
                .id("event1")
                .instant(Instant.now())
                .build());

        repository.save(EventEntity.builder()
                .name("Movie day")
                .id("event2")
                .instant(Instant.now())
                .build());

        repository.save(EventEntity.builder()
                .name("Fun day")
                .id("event3")
                .instant(Instant.now())
                .build());
    }
}
