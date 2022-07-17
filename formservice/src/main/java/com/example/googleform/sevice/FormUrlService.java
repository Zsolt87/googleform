package com.example.googleform.sevice;

import com.example.googleform.entities.Url;
import com.example.googleform.repository.UrlDocument;
import com.example.googleform.repository.UrlRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class FormUrlService {

    private final UrlRepository urlRepository;

    @Transactional
    public Url retrieveAvailableUrl(){
        Example example = Example.of(UrlDocument.builder().isUsed(false).build());
        Optional<UrlDocument> urlDocumentOptional = urlRepository.findOne(example);

        if(urlDocumentOptional.isPresent()){
            UrlDocument urlDocument = urlDocumentOptional.get();
            urlDocument.setUsed(true);
            urlRepository.save(urlDocument);
        }

        return Url.of(urlDocumentOptional.orElse(UrlDocument.builder().build()).getUrl());
    }

}
