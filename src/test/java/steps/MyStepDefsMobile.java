package steps;

import Setup.AppiumSetup;
import com.codeborne.selenide.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import cucumber.api.junit.Cucumber;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;

public class MyStepDefsMobile extends AppiumSetup {

   AppiumDriver<MobileElement> driver;
   String appPackage = "ru.kinopoisk.dev";
   String appMainActivity = "ru.kinopoisk.presentation.screen.tabs.RedirectTabsIntentsActivity";

   @Given("Start the app")
   public void startApp() throws Throwable {
      URL appiumServer = new URL("http://127.0.0.1:4723/wd/hub");
      String pathToApp = "C:\\Users\\swnet\\Desktop\\test2.apk";

      DesiredCapabilities androidCapabilities = new DesiredCapabilities();
      androidCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator1");
      androidCapabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.15.1");
      androidCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
      androidCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
      androidCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
      androidCapabilities.setCapability("appPackage", appPackage);
      androidCapabilities.setCapability("appActivity", appMainActivity);
      androidCapabilities.setCapability(MobileCapabilityType.APP, pathToApp);

      driver = new AndroidDriver(appiumServer, androidCapabilities);
      WebDriverRunner.setWebDriver(driver);
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   }

   @Given("Stop the app")
   public void stopApp() throws Throwable {
      driver.quit();
   }

}
