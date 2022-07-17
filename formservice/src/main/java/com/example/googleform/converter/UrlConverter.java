package com.example.googleform.converter;

import com.example.googleform.entities.Url;
import com.example.googleform.repository.UrlDocument;
import org.springframework.stereotype.Component;

@Component
public class UrlConverter implements Converter<String, Url, UrlDocument> {

    @Override
    public String convertToDto(Url url) {
        return null;
    }

    @Override
    public Url convertToModelFromDto(String s) {
        return null;
    }

    @Override
    public UrlDocument convertToDocument(Url url) {
        return UrlDocument.builder().url(url.getUrl()).build();
    }

    @Override
    public Url convertToModelFromDocument(UrlDocument urlDocument) {
        return null;
    }
}
