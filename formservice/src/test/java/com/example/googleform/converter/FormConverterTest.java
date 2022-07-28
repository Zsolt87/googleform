package com.example.googleform.converter;

import com.example.googleform.data.FormDTO;
import com.example.googleform.entities.Event;
import com.example.googleform.entities.Form;
import com.example.googleform.entities.FormStatus;
import com.example.googleform.entities.Url;
import com.example.googleform.entities.question.FreeTextQuestion;
import com.example.googleform.sevice.EventService;
import com.example.googleform.sevice.FormUrlService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FormConverterTest {

    @Mock
    FormUrlService formUrlService;
    @Mock
    EventService eventService;

    @InjectMocks
    FormConverter underTest;

    @Test
    void convertToModelFromDto() {
        //Given
        UUID eventId = UUID.randomUUID();
        List<FreeTextQuestion> questions = List.of(FreeTextQuestion.builder().question("testFreeQuestion1").build(),
                FreeTextQuestion.builder().question("testFreeQuestion2").build());
        FormDTO formDTO = FormDTO.builder()
                .id(UUID.randomUUID())
                .eventId(eventId)
                .name("Test form")
                .status(FormStatus.STARTED)
                .questionsFreeText(
                        questions
                )
                .build();

        Mockito.when(formUrlService.retrieveAvailableUrl()).thenReturn(Url.of("AAAB"));
        Mockito.when(eventService.getEventById(eventId)).thenReturn(Event.builder()
                .id(eventId)
                .instant(Instant.now())
                .name("testEvent")
                .build()
        );

        //When
        Form result = underTest.convertToModelFromDto(formDTO);

        //Then
        assertAll(
                () -> assertEquals(eventId, result.getEvent().getId()),
                () -> assertEquals(questions, result.getQuestions()));
    }
}