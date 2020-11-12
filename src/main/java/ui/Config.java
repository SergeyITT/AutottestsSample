package ui;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

public abstract class Config {

    //TODO: Получать значения из конфига мавена
    final private static String APPIUM_URL = "http://127.0.0.1:4723/wd/hub";
    final private static String APPIUM_VERSION = "1.15.1";
    final private static String PLATFORM_NAME = "Android";
    final private static String PLATFORM_VERSION = "10.0";
    final private static String DEVICE_NAME = "Device";
    final private static String ANDROID_APP_PACKAGE = "ru.kinopoisk.dev";
    final private static String ANDROID_APP_MAIN_ACTIVITY = "ru.kinopoisk.presentation.screen.tabs.RedirectTabsIntentsActivity";
    final private static String ANDROID_APP_PATH_LOCAL = System.getProperty("user.home").concat("/Desktop/test.apk");

    public static URL getAppiumUrl() {
        URL appiumServer = null;
        try {
            appiumServer = new URL(APPIUM_URL);
        } catch (MalformedURLException e) {}
        return appiumServer;
    }
    public static String getAppiumVersion() {return APPIUM_VERSION; }
    public static CurrentPlatform getPlatformName() {
        CurrentPlatform currentPlatform = null;
        switch (PLATFORM_NAME.toLowerCase()) {
            case "android":
                currentPlatform = CurrentPlatform.ANDROID;
                break;
            case "ios":
                currentPlatform = CurrentPlatform.IOS;
                break;
            default:
                System.out.printf("ERROR: Undefined platform");
        }
        return currentPlatform;
    }
    public static String getPlatformVersion() {
        return PLATFORM_VERSION;
    }
    public static String getDeviceName() {
        return DEVICE_NAME;
    }
    public static String getAndroidAppPackage() {
        return ANDROID_APP_PACKAGE;
    }
    public static String getAndroidAppMainActivity() {
        return ANDROID_APP_MAIN_ACTIVITY;
    }
    public static String getAndroidAppPathLocal() {
        return Paths.get(ANDROID_APP_PATH_LOCAL).toAbsolutePath().toString();
    }

    public enum CurrentPlatform {
        ANDROID, IOS
    }
}
