package com.example.googleform.steps.envsetup;

import com.example.googleform.RunTests;
import io.cucumber.java.en.Given;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Slf4j
public class EnvSetupSteps {

    private static final List<Integer> waitingTime = List.of(60,5,5,2,1,1);

    @SneakyThrows
    @Given("the service is running")
    public void the_service_is_running() {
        HttpRequest request =
                HttpRequest
                        .newBuilder()
                        .uri(new URI(RunTests.HOST + "/actuator/health"))
                        .GET()
                        .build();

        boolean wasSuccessfull = false;
        for (Integer i: waitingTime) {
            try{
                log.info("Trying {i}th times", i);
                HttpResponse response =
                        HttpClient
                                .newHttpClient()
                                .send(request, HttpResponse.BodyHandlers.ofString());

                if(response.statusCode() == 200){
                    wasSuccessfull = true;
                    break;
                }
                log.info("Waiting {} sec", i);
                Thread.sleep(i*1000);

            }catch (Exception e){
                log.info("HTTP exception",e);
            }
        }

        Assertions.assertTrue(wasSuccessfull);

    }

    @SneakyThrows
    @Given("the environment is ready")
    public void the_environment_is_ready() {
        HttpRequest request =
                HttpRequest
                    .newBuilder()
                    .uri(new URI(RunTests.HOST + "/test-env"))
                    .POST(HttpRequest.BodyPublishers.noBody())
                    .build();

        HttpResponse response =
                HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

        Assertions.assertEquals(200, response.statusCode());
    }
}
