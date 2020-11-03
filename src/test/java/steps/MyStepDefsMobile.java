package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import moblie.Actions;
import moblie.AppiumSetup;

public class MyStepDefsMobile {

   /*
   Создаем Appium драйвер для запуска приложения.
   Подробнее:  *\AutottestsSample\src\main\java\moblie\AppiumSetup.java
   */
   private AppiumSetup appiumSetup = AppiumSetup.getInstance();

   /*
   Обязательный шаг перед началом любого теста, т.к. здесь запускается нужный драйвер
   TODO: Адаптировать под запуск IOS
    */
   @Given("Start the app")
   public void startApp() throws Throwable {
      String pathToApp = System.getProperty("user.home") + "/Desktop/test.apk";
      appiumSetup.setAndroidDriver(pathToApp);
      Actions.timeOut(5);
   }

   /*
   Вырубаем драйвер после теста - закрываем приложение
   В большинстве случаев - обязательны шаг
    */
   @Then("Stop the app")
   public void stopApp() throws Throwable {
      Actions.timeOut(3);
      appiumSetup.quitDriver();
   }

   @When("Try to swipe")
   public void swipeScreen() {
      Actions.swipeScreen(Actions.Direction.LEFT);
   }

}
