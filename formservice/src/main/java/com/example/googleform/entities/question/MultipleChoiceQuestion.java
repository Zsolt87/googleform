package com.example.googleform.entities.question;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class MultipleChoiceQuestion extends  Question{
    private final List<String> options = new ArrayList<>();
}
