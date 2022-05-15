package com.example.googleform.sevice;

import com.example.googleform.entities.Url;
import com.example.googleform.repository.UrlDocument;
import com.example.googleform.repository.UrlRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class FormUrlService {

    private UrlRepository urlRepository;

    @Transactional
    public Optional<UrlDocument> retrieveAvailableUrl(){
        Example example = Example.of(UrlDocument.builder().isUsed(false).build());
        Optional<UrlDocument> urlDocumentOptional = urlRepository.findOne(example);

        if(urlDocumentOptional.isPresent()){
            UrlDocument urlDocument = urlDocumentOptional.get();
            urlDocument.setUsed(true);
            urlRepository.save(urlDocument);
        }

        return urlDocumentOptional;
    }

    public Url generateUrl(){
        StringBuilder strBuilder = new StringBuilder();
        for(int i = 0; i < 5; i++){
            strBuilder.append((char)((Math.random() * ('Z' + 1 - 'A')) + 'A'));
        }

        return new Url(strBuilder.toString());
    }


}
