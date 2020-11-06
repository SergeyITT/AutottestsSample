package moblie;

import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/*
Класс для создания, настройки и запуска Appium драйвера, запускающего приложение.
TODO: Адаптировать класс для запуска IOSDriver()
TODO: Избавиться от хардкода переменных путем вынесения их в локальные переменные среды (Нужно будет для CI)
TODO: Научить  PATH_TO_APP брать сборки из облака или репозитория
 */

public class AppiumSetup {
    AppiumDriver<MobileElement> driver;

    private static String PLATFORM = "Android".toLowerCase(); // Здесь будет переменная среды
    private static String PLATFORM_VERSION = "10"; // Здесь будет переменная среды
    private static String DEVICE_NAME = "Test device"; // Здесь будет переменная среды
    private static String PATH_TO_APP = System.getProperty("user.home") + "/Desktop/test.apk"; // Здесь будет метод
    private static String APPIUM_VERSION = "1.15.1";
    private static String APPIUM_URL = "http://127.0.0.1:4723/wd/hub"; // Теоритически - константа, но это не точно

    private static String ANDROID_APP_PACKAGE = "ru.kinopoisk.dev"; // Здесь будет переменная среды
    private static String ANDROID_APP_MAIN_ACTIVITY = "ru.kinopoisk.presentation.screen.tabs.RedirectTabsIntentsActivity"; // Здесь будет переменная среды

    /*
    Создаем singleton:
    Теперь вместо new AppiumSetup() юзаем AppiumSetup.getInstance() там, где нужно получить экземпляр класса AppiumSetup
    Теперь экземпляр класса не будет каждый раз создаваться заново, а будет использовать старый, если он уже
    был создан ранее
    */

    private static AppiumSetup instance; // Создает экземпляр класса AppiumSetup
    private AppiumSetup(){} // Создает пустой конструктор класса AppiumSetup
    public static AppiumSetup getInstance(){
        if(instance == null){
            instance = new AppiumSetup();
        }
        return instance;
    } // Возвращает AppiumSetup: новый или переиспользует уже существующий

    // Инициализирует и запускает драйвер
    public void setDriver() throws MalformedURLException {

        switchDriverPlatform(); //Инициализирует драйвер для нужной платформы
        WebDriverRunner.setWebDriver(driver); //Запускает настроенный драйвер.
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //Выставляет для драйвера таймауты ожидания
        System.out.printf("Set driver: \nPlatform: %s\nOS version: %s", getCurrentPlatform(), PLATFORM_VERSION ); // Лог

    }

    // Выключаем драйвер (Приложение закрывается)
    public void quitDriver(){
        driver.quit();
    }

    // Инициализирует драйвер для нужной платформы
    private void switchDriverPlatform() throws MalformedURLException {
        URL appiumServer = new URL(APPIUM_URL);

        switch (getCurrentPlatform()) {
            case ANDROID:
                driver = new AndroidDriver(appiumServer, getCapabilities());
                break;
            case IOS:
                driver = new IOSDriver(appiumServer, getCapabilities());
                break;
            case DESKTOP:
                System.out.printf("ERROR: Use another one class for this platform: " + getCurrentPlatform());
                System.out.printf("In there use: %s, %s", Platform.ANDROID, Platform.IOS);
                break;
            default:
                System.out.printf("ERROR: Unexpected platform: " + getCurrentPlatform());
                System.out.printf("Try to use: %s, %s", Platform.ANDROID, Platform.IOS);
                break;
        }
    }

    // Отдает Capabilities для нужной платформы
    private static DesiredCapabilities getCapabilities() {
        DesiredCapabilities Capabilities = new DesiredCapabilities();

        switch (getCurrentPlatform()) {
            case ANDROID:
                Capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator1");
                Capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, APPIUM_VERSION);
                Capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM);
                Capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
                Capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
                Capabilities.setCapability("appPackage", ANDROID_APP_PACKAGE);
                Capabilities.setCapability("appActivity", ANDROID_APP_MAIN_ACTIVITY);
                Capabilities.setCapability(MobileCapabilityType.APP, PATH_TO_APP);
            case IOS:
                // TODO: Добавить IOS Capabilities
        }

        return Capabilities;
    }

    // Получает строку с нужной платформой и конвертирует в enum
    public static Platform getCurrentPlatform() {
        Platform platform = null;

        switch (PLATFORM) {
            case "android":
                platform = Platform.ANDROID;
                break;
            case "ios":
                platform =  Platform.IOS;
                break;
            case "desktop":
                platform =  Platform.DESKTOP;
                break;
            default:
                System.out.printf("ERROR: Unexpected platform: " + getCurrentPlatform());
                System.out.printf("Try to use: %s, %s, %s", Platform.ANDROID, Platform.IOS, Platform.DESKTOP);
                break;
        }
        return platform;
    }

    //Список поддерживаемых платформ
    //TODO: Научиться обрабатывать "Desktop"
    public enum Platform {
        ANDROID, IOS, DESKTOP
    }

    /*
    Геттеры настраиваемых переменных: Переменные окружения можно вызывать откуда угодно, но это может быть
    не всегда удобно, думаю проще будет забирать переменные отсюда
     */

    public static String getAndroidAppPackage() {
        return ANDROID_APP_PACKAGE;
    }
}