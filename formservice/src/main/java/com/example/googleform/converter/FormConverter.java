package com.example.googleform.converter;

import com.example.googleform.data.FormDTO;
import com.example.googleform.model.Form;
import com.example.googleform.model.question.CheckBoxQuestion;
import com.example.googleform.model.question.FreeTextQuestion;
import com.example.googleform.model.question.RadioButtonQuestion;
import com.example.googleform.repository.FormDocument;
import com.example.googleform.sevice.EventService;
import com.example.googleform.sevice.FormUrlService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Component
public class FormConverter implements Converter<FormDTO, Form, FormDocument> {

    private final FormUrlService formUrlService;
    private final EventService eventService;

    @Override
    public FormDTO convertToDto(Form model) {

        FormDecorator formDecorator = new FormDecorator(model);
        List<CheckBoxQuestion> checkBoxQuestions = formDecorator.getCheckBoxQuestions();
        List<FreeTextQuestion> freeTextQuestions = formDecorator.getFreeTextQuestions();
        List<RadioButtonQuestion> radioButtonQuestions = formDecorator.getRadioButtonQuestions();

        return FormDTO.builder().name(model.getName())
                //TODO
                .eventId(model.getEvent() == null ? null : model.getEvent().getId())
                .id(model.getId())
                .questionsCheckBox(checkBoxQuestions)
                .questionsFreeText(freeTextQuestions)
                .questionsRadioButton(radioButtonQuestions)
                .build();
    }

    @Override
    public Form convertToModelFromDto(FormDTO dto) {

        return Form.builder()
                .formUrl(formUrlService.retrieveAvailableUrl())
                .id(dto.getId())
                .name(dto.getName())
                .questions(new FormDTODecorator(dto).getMergedQuestions())
                .status(dto.getStatus())
                .event(eventService.getEventById(dto.getEventId()))
                .build();
    }

    @Override
    public FormDocument convertToDocument(Form form) {
        return FormDocument.builder()
                .name(form.getName())
                .id(form.getId() == null ? UUID.randomUUID() : form.getId() )
                .formUrl(form.getFormUrl())
                .status(form.getStatus())
                .questions(form.getQuestions())
                .event(form.getEvent())
                .build();
    }

    @Override
    public Form convertToModelFromDocument(FormDocument formDocument) {
        return Form.builder()
                .event(formDocument.getEvent())
                .id(formDocument.getId())
                .name(formDocument.getName())
                .status(formDocument.getStatus())
                .questions(formDocument.getQuestions())
                .formUrl(formDocument.getFormUrl())
                .build();
    }
}
