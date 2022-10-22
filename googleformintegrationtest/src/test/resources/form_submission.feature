Feature: Create new form

  Scenario: Form correctly saved
    Given the service is running
    Given the environment is ready
    When user submits new form correctly
    Then form can be queried