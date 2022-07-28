package com.example.googleform.steps.form;

import io.cucumber.java.en.Given;
import org.junit.jupiter.api.Assertions;

public class FormStepsDefinition {
    @Given("the environment is ready")
    public void the_environment_is_ready() {
        Assertions.assertTrue(true);
    }
}
