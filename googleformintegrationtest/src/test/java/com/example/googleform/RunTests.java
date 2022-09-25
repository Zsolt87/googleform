package com.example.googleform;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-report.html"},
        features = {"src/test/resources"}
)
public class RunTests {
    public static final String HOST = "http://localhost:5200";
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
}
