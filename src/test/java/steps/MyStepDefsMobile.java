package steps;

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
import moblie.Settings;
import org.openqa.selenium.By;
import cucumber.api.junit.Cucumber;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;

public class MyStepDefsMobile {
   private Settings settings = page(Settings.class);
   AppiumDriver<MobileElement> driver;
   String appPackage = "ru.kinopoisk.dev";
   String appMainActivity = "ru.kinopoisk.presentation.screen.tabs.RedirectTabsIntentsActivity";


   @Given("Start the app")
   public void startApp() throws Throwable {
       settings.set("http://127.0.0.1:4723/wd/hub","C:\\Users\\swnet\\Desktop\\test2.apk");
   }

   @Given("Stop the app")
   public void stopApp() throws Throwable {
      driver.quit();
   }

}
