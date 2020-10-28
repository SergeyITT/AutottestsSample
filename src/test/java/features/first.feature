# language: en

Feature: First test
  @smoke
  Scenario: Test
   When I open yandex ru
   Then I type "Simple sample" in the search string on yandex page
   And Push Enter Button on yandex page
   And I check that the list of results on yandex page is not empty

   Scenario: Test
    When I open google com
    Then I type "Simple sample" in the search string
    And Push Enter Button
    And I check that the list of results is not empty



#  @smoke
#  Функция: Первые тесты
#    Сценарий: Открытие страницы Google и поиск
#      Если Я открываю главную страницу Google Поиска
#      То Я ввожу "Тестирование" поле поиска
#      И Нажимаю Кнопу Найти
#      То Я ввожу "Тестирование2" поле поиска
#      И Нажимаю Кнопу Найти
#      То Я ввожу "Тестирование4" поле поиска
#      И Нажимаю Кнопу Найти
#      То Я ввожу "Тестирование5" поле поиска
#      И Нажимаю Кнопу Найти


