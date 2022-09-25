package com.example.googleform.steps.envsetup;

import com.example.googleform.RunTests;
import io.cucumber.java.en.Given;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class EnvSetupSteps {

    HttpResponse response;

    @SneakyThrows
    @Given("the environment is ready")
    public void the_environment_is_ready() {
        HttpRequest request =
                HttpRequest
                    .newBuilder()
                    .uri(new URI(RunTests.HOST + "/test-env"))
                    .POST(HttpRequest.BodyPublishers.noBody())
                    .build();

        response =
                HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

        Assertions.assertEquals(200, response.statusCode());
    }
}
