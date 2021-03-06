package com.example.googleform.data;

import com.example.googleform.entities.Form;
import com.example.googleform.entities.FormStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class FormRepository {
    private final Map<UUID, Form> store = new HashMap<>();

    public Form getFormById(UUID id){
        return store.get(id);
    }

    public Collection<Form> getAll(){
        return store.values();
    }

    public UUID insert(Form form){
        UUID uuid=UUID.randomUUID();
        form.setId(uuid);
        form.setStatus(FormStatus.CREATED);
        store.put(uuid, form);
        return uuid;
    }

    public void remove(UUID id){
        store.remove(id);
    }
}
