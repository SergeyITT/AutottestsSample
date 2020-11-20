# language: en

@smoke
Feature: Mobile test

  Scenario: Try to fix the test ONE2
    Given Start the app
    When Try to swipe
    Then Try to swipe
    Then Try to swipe
    Then Stop the app

  Scenario: Try to fix the test TWO2
    Given Start the app
    When Try to swipe
    Then Push the button one
    Then Try to swipe
    Then Stop the app