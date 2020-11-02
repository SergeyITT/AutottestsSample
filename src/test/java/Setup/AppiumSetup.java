package Setup;

import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class AppiumSetup {
    AppiumDriver<MobileElement> driver;
    String appPackage = "com.ittest.nextfight";
    String appMainActivity = "com.ittest.nextfight.MainActivity";

    @BeforeEach
    protected void setUp() throws Exception  {
        URL appiumServer = new URL("http://127.0.0.1:4723/wd/hub");
        String pathToApp = "C:\\Users\\swnet\\Desktop\\test.apk";

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

    @After
    protected void tearDown() throws Exception {
        driver.quit();
    }
}
