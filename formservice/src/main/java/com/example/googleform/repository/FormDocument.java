package com.example.googleform.repository;

import com.example.googleform.model.Event;
import com.example.googleform.model.FormStatus;
import com.example.googleform.model.Url;
import com.example.googleform.model.question.Question;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@Document(collection = "form")
public class FormDocument {
    @Id
    private UUID id;
    @Size(min=4)
    private String name;
    @NotNull
    private Event event;
    private FormStatus status;
    @Builder.Default
    private List<Question> questions = new ArrayList();

    @Indexed(unique = true)
    private Url formUrl;
}
