# language: ru

@test
  Функция: Первые тесты
    Сценарий: Открытие страницы Google и поиск
      Если Открыть главную страницу Google Поиска
      То Ввести "Тестирование" в поле поиска
      И Нажать кнопку Найти
      То Ввести "Тестирование2" в поле поиска
      И Нажать кнопку Найти
      То Ввести "Тестирование3" в поле поиска
      И Нажать кнопку Найти
      То Ввести "Тестирование5" в поле поиска
      И Нажать кнопку Найти

