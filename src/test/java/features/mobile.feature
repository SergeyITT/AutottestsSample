# language: en

Feature: Mobile test
  @smoke
  Scenario: Try to start the app
    Given Start the app
    Then Try to swipe
    Then Try to swipe
    Then Try to swipe
    Then Push the button
    Then Stop the app