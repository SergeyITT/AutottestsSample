package ui;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

public abstract class Config {

    //TODO: Получать значения из конфига мавена
    private static String APPIUM_URL = "http://127.0.0.1:4723/wd/hub";
    private static String APPIUM_VERSION = "1.15.1";
    private static String PLATFORM_NAME = "Android";
    private static String PLATFORM_VERSION = "10.0";
    private static String DEVICE_NAME = "Device";
    private static String ANDROID_APP_PACKAGE = "ru.kinopoisk.dev";
    private static String ANDROID_APP_MAIN_ACTIVITY = "ru.kinopoisk.presentation.screen.tabs.RedirectTabsIntentsActivity";
    private static String ANDROID_APP_PATH_LOCAL = System.getProperty("user.home")+ "/Desktop/test.apk";

    public static URL getAppiumUrl() {
        URL appiumServer = null;
        try {
            appiumServer = new URL(APPIUM_URL);
        } catch (MalformedURLException e) {}
        return appiumServer;
    }
    public static String getAppiumVersion() {return APPIUM_VERSION; }
    public static String getPlatformName() {
        return PLATFORM_NAME;
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
}
