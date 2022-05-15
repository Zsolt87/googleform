package com.example.googleform.repository;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Builder
@Document(collection = "url")
public class UrlDocument {
    @Id
    private String url;
    private boolean isUsed;
}
