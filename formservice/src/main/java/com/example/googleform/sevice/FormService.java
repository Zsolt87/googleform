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
        validateForm(form);
        return formStore.insert(form);
    }

    private boolean validateForm(Form form){
        UUID eventId = form.getEventId();
        Event event = eventService.getEventById(form.getEventId());

        if(event == null)
            throw new IllegalArgumentException(String.format("Could not found event with id %s", eventId));

        return true;
    }
}
