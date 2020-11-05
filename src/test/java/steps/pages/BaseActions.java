package steps.pages;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import moblie.Actions;
import moblie.AppiumSetup;

/*
Класс с основными методами взаимодействия с приложением, не зависящими от конкретных элементов Page
Предлагаю не наполнять его новыми методами, или добавлять только "базовые" методы, подготавливающие приложение к тестированию.
Методы для конкретных экранов должны быть реализованны отдельно в классах, логически связанных с Page
TODO: Написать метод Restart the app
 */

public class BaseActions {

   /*
   Создаем Appium драйвер для запуска приложения.
   Подробнее: AutottestsSample\src\main\java\moblie\AppiumSetup.java
   */
   private AppiumSetup appiumSetup = AppiumSetup.getInstance();

   @Given("Start the app")
   public void startApp() throws Throwable {

      /*
      Обязательный шаг перед началом любого теста, т.к. здесь запускается нужный драйвер
      TODO: Адаптировать под запуск IOS
      TODO: Сделать так чтобы сборки можно было брать из облака
      TODO: Сделать так, чтобы метод понимал, когда кончился Splash-screen перед прохождением др. шагов
       */

      //По умолчанию путь до apk для Андройда - Рабочий стол юзера, файл - test.apk
      String pathToApp = System.getProperty("user.home") + "/Desktop/test.apk";
      appiumSetup.setAndroidDriver(pathToApp);

      // Поставил сюда таймаут, т.к. нужно какое то время, чтобы пропал Splash-screen.
      moblie.Actions.timeOut(5);
   }

   @Then("Stop the app")
   public void stopApp() throws Throwable {

      /*
      Вырубаем драйвер после теста - закрываем приложение
      В большинстве случаев - обязательны шаг в конце теста
      Временно сделал тайм аут перед закрытием, чтобы отслеживать последний шаг
      */

      moblie.Actions.timeOut(3);
      appiumSetup.quitDriver();
   }

   @Then("Try to swipe")
   public void swipeScreen() {

      /*
      Свайпает экран в сторону. Метод лежит в src\main\java\moblie\Actions.java
      TODO: Запилить возможность выбора стороны
       */

      moblie.Actions.swipeScreen(moblie.Actions.Direction.LEFT);
   }
}