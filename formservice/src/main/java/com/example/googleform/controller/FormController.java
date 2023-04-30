package com.example.googleform.controller;

import com.example.googleform.converter.FormConverter;
import com.example.googleform.data.FormDTO;
import com.example.googleform.model.Form;
import com.example.googleform.sevice.FormService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collection;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("form")
@Slf4j
public class FormController {

    private final FormService formService;
    private final FormConverter formConverter;

    @GetMapping("{id}")
    public Form get(@PathVariable("id") UUID id){
        return formService.getFormById(id);
    }

    @GetMapping
    public Collection<Form> getAll(){
        return formService.getAll();
    }

    @PostMapping
    @SneakyThrows
    public ResponseEntity<FormDTO> insert(@Valid @RequestBody FormDTO formDTO){
        Form form = formService.insert(formConverter.convertToModelFromDto(formDTO));
        FormDTO formDto = formConverter.convertToDto(form);
        return ResponseEntity.created(new URI("/form/" + formDto.getId())).body(formDto);
    }

    @DeleteMapping("{id}")
    public void remove(@PathVariable("id") UUID id){
        formService.remove(id);
    }

}
