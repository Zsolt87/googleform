package com.example.googleform.sevice;

import com.example.googleform.repository.FormRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Profile("dev-integration")
public class TestSetupRestService {
    private final FormRepository formRepository;

    public ResponseEntity cleanUp(){
        formRepository.deleteAll();
        return ResponseEntity.ok().build();
    }
}
