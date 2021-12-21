Feature: Simple tests


  Scenario Outline:
    Given Open yandex ru
    When Type "<searchInput>" in the search string on yandex page
    And Push Enter Button on yandex page
    Then Check that the list of results on yandex page is not empty

    Examples:
      | searchInput            |
      | Тестовый примеро       |
      | Aцввфывфывфывфывфывфыв |