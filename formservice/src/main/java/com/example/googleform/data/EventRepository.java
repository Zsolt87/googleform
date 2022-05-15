package com.example.googleform.data;

import com.example.googleform.entities.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Component
public class EventRepository {
    private final Map<UUID, Event> store = new HashMap<>();

    public EventRepository(){
    }

    @PostConstruct
    public void extracted() {
        for(int i = 0; i < 3 ; i++){
            store.put(UUID.randomUUID(), new Event());
            log.info("Event list {}", store.keySet());
        }
    }

    public Event getEventById(UUID id){
        return store.get(id);
    }

    public Collection<Event> getAll(){
        return store.values();
    }
}
