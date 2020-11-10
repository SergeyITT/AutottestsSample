package steps.pages;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import ui.platforms.Android;
import ui.Container;
import ui.Platform;

/*
Класс с основными методами взаимодействия с приложением, не зависящими от конкретных элементов Page
Предлагаю не наполнять его новыми методами, или добавлять только "базовые" методы, подготавливающие приложение к тестированию.
Методы для конкретных экранов должны быть реализованны отдельно в классах, логически связанных с Page
TODO: Написать методы работы с активити типа Restart the app
 */

public class MobileBaseActions {

   Container container = Container.getInstance();

   @Given("Start the app")
   public void startApp() throws Throwable {

      /*
      Обязательный шаг перед началом любого теста, т.к. здесь запускается нужный драйвер
      TODO: Сделать так, чтобы метод понимал, когда кончился Splash-screen перед прохождением др. шагов
       */

      container.runPlatform(new Android());
      container.getPlatform().timeOut(5);
   }

   @Then("Stop the app")
   public void stopApp() throws Throwable {

      /*
      Вырубаем драйвер после теста - закрываем приложение
      В большинстве случаев - обязательны шаг в конце теста
      Временно сделал тайм аут перед закрытием, чтобы отслеживать последний шаг
      */

      Container container = Container.getInstance();
      container.getPlatform().timeOut(5);
      container.getPlatform().quitDriver();
   }

   @Then("Try to swipe")
   public void swipeScreen() {

      /*
      Свайпает экран в сторону. Метод лежит в src\main\java\moblie\Actions.java
      TODO: Запилить возможность выбора стороны
       */
      container.getPlatform().swipeScreen(Platform.Direction.LEFT);
   }
}