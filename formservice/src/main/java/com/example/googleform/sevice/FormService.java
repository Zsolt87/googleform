package com.example.googleform.sevice;

import com.example.googleform.data.FormRepository;
import com.example.googleform.entities.Event;
import com.example.googleform.entities.Form;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;
import java.util.UUID;

@Configuration
public class FormService
{
    @Autowired
    FormRepository formStore;

    @Autowired
    EventService eventService;

    public Form getFormById(@NonNull UUID id){
        return formStore.getFormById(id);
    }

    public Collection<Form> getAll(){
        return formStore.getAll();
    }

    public void remove(@NonNull UUID id){
        formStore.remove(id);
    }

    public UUID insert(Form form){
        return formStore.insert(form);
    }

    private boolean validateEvent(UUID eventId){
        Event event = eventService.getEventById(eventId);

        if(event == null)
            throw new IllegalArgumentException(String.format("Could not found event with id %s", eventId));

        return true;
    }
}
