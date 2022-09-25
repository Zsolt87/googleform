package com.example.form.question;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public abstract class MultipleChoiceQuestion extends Question {
    private final List<String> options = new ArrayList<>();
}
