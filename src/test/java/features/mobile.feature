# language: en

Feature: Mobile test
  @smoke
  Scenario: Try to start the app
    Given Start the app
    When Try to swipe
    Then Try to swipe
    Then Try to swipe
    Then Stop the app