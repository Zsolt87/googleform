package com.example.googleform.sevice;

import com.example.googleform.data.EventRepository;
import com.example.googleform.entities.Event;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;
import java.util.UUID;

@Configuration
public class EventService {

    @Autowired
    EventRepository eventStore;

    public Event getEventById(@NonNull UUID id){
        return eventStore.getEventById(id);
    }

    public Collection<Event> getAll(){
        return eventStore.getAll();
    }
}
