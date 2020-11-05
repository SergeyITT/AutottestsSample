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

/*
Класс для создания, настройки и запуска Appium драйвера, запускающего приложение.
TODO: Адаптировать класс для запуска IOSDriver()
TODO: Избавиться от хардкода переменных путем вынесения их в локальные переменные среды (Нужно будет для CI)
 */

public class AppiumSetup {
    AppiumDriver<MobileElement> driver;

    private static String ANDROID_APP_PACKAGE = "ru.kinopoisk.dev";
    private static String ANDROID_APP_MAIN_ACTIVITY = "ru.kinopoisk.presentation.screen.tabs.RedirectTabsIntentsActivity";
    private static String APPIUM_URL = "http://127.0.0.1:4723/wd/hub";

    /*
    Создаем singleton:
    Теперь вместо new AppiumSetup() юзаем AppiumSetup.getInstance() там, где нужно получить экземпляр класса AppiumSetup
    Теперь экземпляр класса не будет каждый раз создаваться заново, а будет использовать старый, если он уже
    был создан ранее
    */

    private static AppiumSetup instance; // Создаем экземпляр класса AppiumSetup
    private AppiumSetup(){} // Создаем пустой конструктор
    public static AppiumSetup getInstance(){
        if(instance == null){
            instance = new AppiumSetup();
        }
        return instance;
    } // Метод, возвращающий AppiumSetup - новый или уже существующий


    public void setAndroidDriver(String pathToApp) throws MalformedURLException {
        URL appiumServer = new URL(APPIUM_URL);

        DesiredCapabilities androidCapabilities = new DesiredCapabilities();
        androidCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator1");
        androidCapabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.15.1");
        androidCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        androidCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
        androidCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
        androidCapabilities.setCapability("appPackage", ANDROID_APP_PACKAGE);
        androidCapabilities.setCapability("appActivity", ANDROID_APP_MAIN_ACTIVITY);
        androidCapabilities.setCapability(MobileCapabilityType.APP, pathToApp);

        /*
        Записываем в драйвер ссылку на Appium Server и настроенные DesiredCapabilities.
        Запускаем настроенный драйвер.
        Выставляем для драйвера таймауты ожидания..
         */

        driver = new AndroidDriver(appiumServer, androidCapabilities);
        WebDriverRunner.setWebDriver(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void quitDriver(){
        driver.quit(); // Выключаем драйвер (Приложение закрывается)
    }

    public static String getAndroidAppPackage() {
        return ANDROID_APP_PACKAGE;
    }
}