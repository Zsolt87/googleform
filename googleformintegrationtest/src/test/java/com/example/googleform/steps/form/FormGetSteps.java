package com.example.googleform.steps.form;

import com.example.googleform.RunTests;
import io.cucumber.java.en.Given;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FormGetSteps {
    HttpResponse<String> response;
    FormPostSteps formPostSteps;

    public FormGetSteps(FormPostSteps formPostSteps) {
        this.formPostSteps = formPostSteps;
    }

    @SneakyThrows
    @Given("form can be queried")
    public void form_can_be_queried() {
        HttpRequest request =
                HttpRequest
                        .newBuilder()
                        .uri(new URI(RunTests.HOST + "/form/" + formPostSteps.getFormDto().getId().toString()))
                        .GET()
                        .build();

        response =
                HttpClient
                        .newHttpClient()
                        .send(request, HttpResponse.BodyHandlers.ofString());

        Assertions.assertEquals(200, response.statusCode());
    }
}
