package com.example.googleform.converter;

import com.example.googleform.data.FormDTO;
import com.example.googleform.model.question.Question;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class FormDTODecorator {
    private final FormDTO formDTO;

    public List<Question> getMergedQuestions(){
        return List.of(
                formDTO.getQuestionsCheckBox(),
                formDTO.getQuestionsFreeText(),
                formDTO.getQuestionsRadioButton())
                .stream()
                .flatMap(List::stream).collect(Collectors.toList());
    }
}
