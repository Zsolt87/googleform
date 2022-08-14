Feature: Create new form

  Scenario: Form correctly saved
    Given the environment is ready
    When user submits new form
    Then form is saved