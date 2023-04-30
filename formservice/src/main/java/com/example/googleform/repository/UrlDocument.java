package com.example.googleform.repository;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Data
@Builder
@Document(collection = "url")
public class UrlDocument implements Comparable<UrlDocument>{

    @Id
    private String url;
    private boolean isUsed;

    @Override
    public int compareTo(UrlDocument o) {
        return o.getUrl().compareTo(this.url);
    }
}
