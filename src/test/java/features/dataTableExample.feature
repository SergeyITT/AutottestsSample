# language: ru
Функция: Первые тесты

  Сценарий: Открытие страницы Google и поиск
    Если Открыть главную страницу Google Поиска
    То Ввести в поле поиска
      | Первый |
      | Второй |
      | Третий |
  И Нажать кнопку Найти
  Тогда Проверить что количество результатов больше 0