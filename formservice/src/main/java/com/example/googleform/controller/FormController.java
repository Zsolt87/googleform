package com.example.googleform.controller;

import com.example.googleform.entities.Form;
import com.example.googleform.sevice.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.UUID;

@RestController
@Validated
public class FormController {

    @Autowired
    FormService formService;

    @GetMapping("form/{id}")
    public Form get(@PathVariable("id") UUID id){
        return formService.getFormById(id);
    }

    @GetMapping("form")
    public Collection<Form> getAll(){
        return formService.getAll();
    }

    @PostMapping("form")
    public UUID insert(@Valid @RequestBody Form form){
        return formService.insert(form);
    }

    @DeleteMapping("form/{id}")
    public void remove(@PathVariable("id") UUID id){
        formService.remove(id);
    }

}
