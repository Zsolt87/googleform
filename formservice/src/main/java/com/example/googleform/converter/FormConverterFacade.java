package com.example.googleform.converter;

import com.example.googleform.model.Form;
import com.example.googleform.model.question.CheckBoxQuestion;
import com.example.googleform.model.question.FreeTextQuestion;
import com.example.googleform.model.question.RadioButtonQuestion;

import java.util.List;
import java.util.stream.Collectors;

public class FormConverterFacade {

    public static List<CheckBoxQuestion> getCheckBoxQuestions(Form model) {
        return model.getQuestions()
                .stream()
                .filter(CheckBoxQuestion.class::isInstance)
                .map(CheckBoxQuestion.class::cast)
                .collect(Collectors.toList());
    }

    public static List<FreeTextQuestion> getFreeTextQuestions(Form model) {
        return model.getQuestions()
                .stream()
                .filter(FreeTextQuestion.class::isInstance)
                .map(FreeTextQuestion.class::cast)
                .collect(Collectors.toList());
    }

    public static List<RadioButtonQuestion> getRadioButtonQuestions(Form model) {
        return model.getQuestions()
                .stream()
                .filter(RadioButtonQuestion.class::isInstance)
                .map(RadioButtonQuestion.class::cast)
                .collect(Collectors.toList());
    }
}
