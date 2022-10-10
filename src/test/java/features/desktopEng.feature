# language: en

Feature: Simple tests


  Scenario: Desktop
    Given Open yandex ru
    When Type "Тестовый пример, ничего особенного" in the search string on yandex page
    And Push Enter Button on yandex page
    Then Check that the list of results on yandex page is not empty

@test
  Scenario: Desktop2
    Given Open yandex ru
    When Type "тесть" in the search string on yandex page
    And Push Enter Button on yandex page
    Then Check that the list of results on yandex page is not empty
