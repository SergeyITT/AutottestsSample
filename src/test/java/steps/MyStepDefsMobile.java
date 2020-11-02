package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import moblie.Actions;
import moblie.AppiumSetup;

public class MyStepDefsMobile {
   private AppiumSetup appiumSetup = AppiumSetup.getInstance();

   @Given("Start the app")
   public void startApp() throws Throwable {
      String pathToApp = System.getProperty("user.home") + "/Desktop/test.apk";
      appiumSetup.setAndroidDriver(pathToApp);
      Actions.timeOut(5);
   }

   @Then("Try to swipe")
   public void swipeScreen() {
      Actions.swipeScreen(Actions.Direction.LEFT);
   }

   @When("Stop the app")
   public void stopApp() throws Throwable {
      Actions.timeOut(3);
      appiumSetup.quitDriver();
   }

}
