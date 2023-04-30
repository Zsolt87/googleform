package com.example.googleform.converter;

import com.example.googleform.model.Form;
import com.example.googleform.model.question.CheckBoxQuestion;
import com.example.googleform.model.question.FreeTextQuestion;
import com.example.googleform.model.question.Question;
import com.example.googleform.model.question.RadioButtonQuestion;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
public class FormDecorator {
    private final Form form;

    private Map<Class, List<Question>> groupByQuestionType() {
        return form.getQuestions().stream().collect(Collectors.toMap(
                k -> k.getClass(),
                v -> List.of(v),
                (v1, v2) -> {
                    List<Question> result = new ArrayList<>(v1);
                    result.addAll(v2);
                    return result;
                }
        ));
    }

    public List<CheckBoxQuestion> getCheckBoxQuestions() {
        return form.getQuestions()
                .stream()
                .filter(i -> i instanceof CheckBoxQuestion)
                .map(CheckBoxQuestion.class::cast)
                .collect(Collectors.toList());
    }

    public List<FreeTextQuestion> getFreeTextQuestions() {
        return form.getQuestions()
                .stream()
                .filter(FreeTextQuestion.class::isInstance)
                .map(FreeTextQuestion.class::cast)
                .collect(Collectors.toList());
    }

    public List<RadioButtonQuestion> getRadioButtonQuestions() {
        return form.getQuestions()
                .stream()
                .filter(RadioButtonQuestion.class::isInstance)
                .map(RadioButtonQuestion.class::cast)
                .collect(Collectors.toList());
    }
}
