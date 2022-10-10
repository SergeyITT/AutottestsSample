# language: en
Feature: Data Tables


  Scenario: Data tables adv example
    Given Enter values from the table into the login form
      | login  | password |
      | First  | 11111    |
      | Second | 22222    |
    Then Check that the list of results on yandex page is not empty
