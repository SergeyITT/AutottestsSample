package ui.platforms;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumCommandInfo;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import ui.Platform;

import java.nio.file.Path;
import java.nio.file.Paths;

import static com.codeborne.selenide.Selenide.$x;

public class Android implements Platform {
    private AppiumDriver driver = new AndroidDriver(getAppiumUrl(), getCapabilities());

    private static String PLATFORM_VERSION = "10.0"; // Здесь будет переменная среды
    private static String DEVICE_NAME = "Android"; // Здесь будет переменная среды
    private static Path PATH_TO_APK = Paths.get(System.getProperty("user.home")+ "/test.apk"); // + "/OneDrive/Desktop/test.apk"
    public static String ANDROID_APP_PACKAGE = "ru.kinopoisk.dev"; // Здесь будет переменная среды
    private static String ANDROID_APP_MAIN_ACTIVITY = "ru.kinopoisk.presentation.screen.tabs.RedirectTabsIntentsActivity"; // Здесь будет переменная среды

    public AppiumDriver getDriver() {
        return driver;
    }
    public DesiredCapabilities getCapabilities() {
        DesiredCapabilities Capabilities = new DesiredCapabilities();
        Capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator1");
        Capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, getAppiumVersion());
        Capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        Capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
        Capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
        Capabilities.setCapability("appPackage", ANDROID_APP_PACKAGE);
        Capabilities.setCapability("appActivity", ANDROID_APP_MAIN_ACTIVITY);
        Capabilities.setCapability(MobileCapabilityType.APP, PATH_TO_APK.toAbsolutePath().toString());
        return Capabilities;


    }
    public static SelenideElement getLocatorByResourceId(String id) {

        /*
        Метод, позволяющий писать большинство UiService.Android селекторов быстрее и проще + добавляет возможность
        быстро менять пакет в id элемента
        TODO: Добавить методы, позволяющие менять контейнеры, индексы, текст
         */

        String xpath = String.format("//*[@resource-id='%s:id/%s']", Android.ANDROID_APP_PACKAGE, id);
        SelenideElement element = $x(xpath);
        return element;
    }
}
