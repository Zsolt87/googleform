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
@RequestMapping("login")
@Slf4j
public class LoginController {

    @GetMapping("oauth2/code/github")
    public void get(){
        log.info("login");
    }


}
