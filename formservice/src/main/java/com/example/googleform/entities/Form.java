package com.example.googleform.entities;

import com.example.googleform.entities.question.Question;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class Form {
    private UUID id;
    @Size(min=4)
    private String name;
    @NotNull
    private Integer eventId;
    private FormStatus status;
    private List<Question> questions = new ArrayList();
}
