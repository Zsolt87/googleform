package com.example.googleform.data;

import com.example.googleform.entities.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Configuration
public class EventRepository {
    Map<UUID, Event> store = new HashMap<>();

    //TODO delete
    public EventRepository(){
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
