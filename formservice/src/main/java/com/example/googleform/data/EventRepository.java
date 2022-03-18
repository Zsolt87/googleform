package com.example.googleform.data;

import com.example.googleform.entities.Event;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Configuration
public class EventRepository {
    Map<UUID, Event> store = new HashMap<>();

    public Event getEventById(UUID id){
        return store.get(id);
    }

    public Collection<Event> getAll(){
        return store.values();
    }
}
