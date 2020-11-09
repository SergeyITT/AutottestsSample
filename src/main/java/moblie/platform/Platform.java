package moblie.platform;

import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public interface Platform {

    String APPIUM_VERSION = "1.15.1";
    String APPIUM_URL = "http://127.0.0.1:4723/wd/hub"; // Теоритически - константа, но это не точно

    AppiumDriver getDriver();
    DesiredCapabilities getCapabilities();

    default void runDriver(AppiumDriver driver) {

        WebDriverRunner.setWebDriver(driver); //Запускает настроенный драйвер.
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //Выставляет для драйвера таймауты ожидания
        //System.out.printf("Set driver: \nPlatform: %s\nOS version: %s", getCurrentPlatform(), PLATFORM_VERSION ); // Лог
    };
    default void quitDriver(AppiumDriver driver) {
        driver.quit();
    };
    default URL getAppiumUrl() {
        URL appiumServer = null;
        try {
            appiumServer = new URL(APPIUM_URL);
        } catch (MalformedURLException e) {

        }
        return appiumServer;
    }
    default String getAppiumVersion(){
        return APPIUM_VERSION;
    };



}
