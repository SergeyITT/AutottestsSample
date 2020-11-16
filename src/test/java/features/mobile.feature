# language: en
@Feature: Test
Feature: Mobile test
  @smoke
  Scenario: Try to start the app
    Given Start the app
    When Try to swipe
    Then Try to swipe
    Then Try to swipe
    Then Stop the app

  @smoke
  Scenario: Try to start the app 2
    Given Start the app
    When Try to swipe
    Then Push the button one
    Then Try to swipe
    Then Stop the app