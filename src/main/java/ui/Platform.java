package ui;

import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public interface Platform {

    // Отдает драйвер наследника
    AppiumDriver getDriver();

    // Отдает настроенные Capabilities по Config
    DesiredCapabilities getCapabilities();

    // Отдает enum используемой платформы
    CurrentPlatform getCurrentPlatformName();

    // Получает инстанс Container и запускает хранящийся там драйвер
    default void runDriver() {
        Container container = Container.getInstance();
        AppiumDriver driver = container.getPlatform().getDriver();

        WebDriverRunner.setWebDriver(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    };

    // Получает инстанс Container и выключает хранящийся там драйвер
    default void quitDriver() {
        Container container = Container.getInstance();
        container.getPlatform().getDriver().quit();
    };

    // Скроллит экран по заданному Direction
    default void swipeScreen(Direction dir) {
        Container container = Container.getInstance();
        System.out.println("swipeScreen(): dir: '" + dir + "'"); // Логирование событий в консоль

        final int ANIMATION_TIME = 300;
        final int PRESS_TIME = 500;
        int edgeBorder = 10;
        PointOption pointOptionStart, pointOptionEnd;
        Dimension dims = container.getPlatform().getDriver().manage().window().getSize();

        switch (dir) {
            case DOWN:
                pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);
                pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
                break;
            case UP:
                pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);
                pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
                break;
            case LEFT:
                pointOptionStart = PointOption.point(dims.width * 3 / 4, dims.height / 2);
                pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
                break;
            case RIGHT:
                pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);
                pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
        }

        try {
            new TouchAction<>(container.getPlatform().getDriver())
                    .press(pointOptionStart)
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
            // ignore
        }
    }

    // Слепой таймаут
    default void timeOut (int sec){
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT;
    }
    enum CurrentPlatform {
        ANDROID, IOS
    }

}
