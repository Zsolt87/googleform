package com.example.googleform.steps.form.dto;

import com.example.googleform.steps.form.question.CheckBoxQuestion;
import com.example.googleform.steps.form.question.FreeTextQuestion;
import com.example.googleform.steps.form.question.RadioButtonQuestion;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class FormDto {
    UUID id;
    String name;
    UUID eventId;
    String status;

    List<CheckBoxQuestion> questionsCheckBox;
    List<RadioButtonQuestion> questionsRadioButton;
    List<FreeTextQuestion> questionsFreeText;
}