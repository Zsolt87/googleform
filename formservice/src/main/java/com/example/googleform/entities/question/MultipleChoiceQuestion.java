package com.example.googleform.entities.question;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public abstract class MultipleChoiceQuestion extends Question{
    private final List<String> options = new ArrayList<>();
}
