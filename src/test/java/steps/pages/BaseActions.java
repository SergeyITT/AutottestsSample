package steps.pages;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import moblie.platform.Android;
import moblie.platform.Platform;

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
   Platform android = Android.getInstance();

   @Given("Start the app")
   public void startApp() throws Throwable {

      /*
      Обязательный шаг перед началом любого теста, т.к. здесь запускается нужный драйвер
      TODO: Сделать так, чтобы метод понимал, когда кончился Splash-screen перед прохождением др. шагов
       */

      android.runDriver(android.getDriver());

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
      Platform StartAndroid = Android.getInstance();
      moblie.Actions.timeOut(3);
      StartAndroid.quitDriver(StartAndroid.getDriver());
   }

   @Then("Try to swipe")
   public void swipeScreen() {

      /*
      Свайпает экран в сторону. Метод лежит в src\main\java\moblie\Actions.java
      TODO: Запилить возможность выбора стороны
       */

      moblie.Actions.swipeScreen(android.getDriver(), moblie.Actions.Direction.LEFT);
   }
}