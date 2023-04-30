package com.example.googleform.steps.form;

import com.example.googleform.RunTests;
import com.example.googleform.steps.form.dto.FormDto;
import io.cucumber.java.en.Given;
import lombok.Getter;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Getter
public class FormPostSteps {
    private HttpResponse<String> response;
    private FormDto formDto;

    private static final String FORM_REQUEST =
            """
                    {
                      "name": "form",
                      "eventId": "39dc8f09-8ec5-48d9-a377-836be013d881",
                      "questionsCheckBox": [
                        {
                          "question": "please choice",
                          "type": "checkbox",
                          "options": [
                            "1",
                            "2",
                            "3"
                          ]
                        }
                      ],
                      "questionsRadioButton": [
                        {
                          "question": "how did you like",
                          "type": "radio_button",
                          "options": [
                            "good",
                            "bad",
                            "mild",
                            "worse"
                          ]
                        }
                      ],
                      "questionsFreeText": [
                        {
                          "question": "what is your name",
                          "type": "text"
                        }
                      ]
                    }
                    """;

    @SneakyThrows
    @Given("user submits new form correctly")
    public void user_submits_new_form_correctly() {

        HttpRequest request =
                HttpRequest
                        .newBuilder()
                        .uri(new URI(RunTests.HOST + "/form"))
                        .header("Content-type", "application/json")
                        .POST(HttpRequest.BodyPublishers.ofString(FORM_REQUEST))
                        .build();

        response =
                HttpClient
                        .newHttpClient()
                        .send(request, HttpResponse.BodyHandlers.ofString());

        Assertions.assertEquals(201, response.statusCode());

        formDto = RunTests.OBJECT_MAPPER.readValue(response.body(), FormDto.class);
    }
}
