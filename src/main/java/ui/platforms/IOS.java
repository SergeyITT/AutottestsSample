package ui.platforms;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import ui.Config;
import ui.Platform;

import java.nio.file.Path;
import java.nio.file.Paths;

import static com.codeborne.selenide.Selenide.$x;

public class IOS implements Platform {

    // Создает уникальный для платформы драйвер
    private AppiumDriver driver = new IOSDriver(Config.getAppiumUrl(), getCapabilities());

    // Геттер драйвера платформы
    @Override
    public AppiumDriver getDriver() {
        return driver;
    }

    // Геттер уникального для платформы набора Capabilities
    // TODO: Написать Capabilities под IOS
    @Override
    public DesiredCapabilities getCapabilities() {
        DesiredCapabilities Capabilities = new DesiredCapabilities();
        /*
        Capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "...");
        Capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, getAppiumVersion());
        Capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
        Capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
        Capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
        */

        return Capabilities;
    }

    @Override
    public CurrentPlatform whichPlatform() {
        return CurrentPlatform.IOS;
    }

    // Доп. методы
    public static SelenideElement getLocatorByResourceId(String id) {

        /*
        Метод, позволяющий писать большинство UiService.Android селекторов быстрее и проще + добавляет возможность
        быстро менять пакет в id элемента
        TODO: Добавить методы, позволяющие менять контейнеры, индексы, текст
         */

        String xpath = String.format("//*[@resource-id='%s:id/%s']", " ", id);
        SelenideElement element = $x(xpath);
        return element;
    }
}
