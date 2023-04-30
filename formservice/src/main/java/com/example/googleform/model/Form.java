package com.example.googleform.model;

import com.example.googleform.model.question.Question;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
public class Form {
    private UUID id;
    @Size(min=4)
    private String name;
    @NotNull
    private Event event;
    private FormStatus status;
    @Builder.Default
    private List<Question> questions = new ArrayList();

    private Url formUrl;
}
