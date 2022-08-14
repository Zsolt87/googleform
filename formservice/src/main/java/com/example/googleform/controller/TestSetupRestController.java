package com.example.googleform.controller;

import com.example.googleform.sevice.TestSetupRestService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Profile("dev-integration")
@RequestMapping("test-env")
public class TestSetupRestController {
    private TestSetupRestService testSetupRestService;

    @PostMapping
    public ResponseEntity cleanUp(){
        return testSetupRestService.cleanUp();
    }
}
