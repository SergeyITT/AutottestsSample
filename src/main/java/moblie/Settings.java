package moblie;

import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Settings {

    AppiumDriver<MobileElement> driver;
    String appPackage = "ru.kinopoisk.dev";
    String appMainActivity = "ru.kinopoisk.presentation.screen.tabs.RedirectTabsIntentsActivity";


    public void set(String URL, String pathToApp) throws MalformedURLException {
        URL appiumServer = new URL(URL);


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
}
