# language: en

Feature: First test
@smoke
Scenario: Desktop
  Given I open yandex ru
  When I type "Тестовый пример, ничего особенного" in the search string on yandex page
  And Push Enter Button on yandex page
  Then I check that the list of results on yandex page is not empty

  @smoke
  Scenario: Desktop2
    Given I open yandex ru
    When I type "Aцввфывфывфывфывфывфыв" in the search string on yandex page
    And Push Enter Button on yandex page
    Then I check that the list of results on yandex page is not empty


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


