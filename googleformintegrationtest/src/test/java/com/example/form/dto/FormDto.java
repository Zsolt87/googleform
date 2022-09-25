package com.example.form.dto;

import com.example.form.question.CheckBoxQuestion;
import com.example.form.question.FreeTextQuestion;
import com.example.form.question.RadioButtonQuestion;
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