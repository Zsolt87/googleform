package com.example.googleform.sevice;

import com.example.googleform.converter.FormConverter;
import com.example.googleform.model.Form;
import com.example.googleform.repository.FormDocument;
import com.example.googleform.repository.FormRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class FormService {

    private final FormRepository formRepository;
    private final EventService eventService;
    private final FormConverter formConverter;

    public Form getFormById(@NonNull UUID id){
        //return formRepository.findById(id);
        return null;
    }

    public List<Form> getAll(){
        //return formRepository.findAll().stream().map(formDocument -> formConverter.);
        return null;
    }

    public void remove(@NonNull UUID id){
        formRepository.deleteById(id);
    }

    public Form insert(Form form){
        FormDocument formDocument = formConverter.convertToDocument(form);
        formDocument = formRepository.save(formDocument);
        return formConverter.convertToModelFromDocument(formDocument);
    }

//    private boolean validateForm(Form form){
//        UUID eventId = form.getEventId();
//        Event event = eventService.getEventById(form.getEventId());
//
//        if(event == null)
//            throw new IllegalArgumentException(String.format("Could not found event with id %s", eventId));
//
//        return true;
//    }
}

