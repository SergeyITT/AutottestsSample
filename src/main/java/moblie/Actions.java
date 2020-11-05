package moblie;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$x;

/*
Класс для хранения дополнительных методов для мобилок, например - свайпы.
В теории его можно фрагментировать и по необходимости и растащить на интерфейсы.
 */

public class Actions {

    /*
    TODO: Подобрать более грамотные значения пропорций экрана для свайпа. Стандартные свайпы с середины - отстой
     */

    public static void swipeScreen(Direction dir) {
        AppiumSetup appiumSetup = AppiumSetup.getInstance(); // Получаем или создаем AppiumSetup (драйвер)
        System.out.println("swipeScreen(): dir: '" + dir + "'"); // Логирование событий в консоль

        final int ANIMATION_TIME = 300;
        final int PRESS_TIME = 500;
        int edgeBorder = 10;
        PointOption pointOptionStart, pointOptionEnd;
        Dimension dims = appiumSetup.driver.manage().window().getSize();

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
            new TouchAction<>(appiumSetup.driver)
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

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT;
    }

    /*
    Метод, расставляющий таймауты
    TODO: Выяснить на сколько такое решение костыльное и как его улучшить
    TODO: Переписать и перегрузить, в теории может пригодиться метод "Ждать, пока <условие>"
     */

    public static void timeOut (int sec){
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SelenideElement getLocatorByResourceId(String id) {

        /*
        Метод, позволяющий писать большинство Android селекторов быстрее и проще + добавляет возможность
        быстро менять пакет в id элемента
        TODO: Добавить методы, позволяющие менять контейнеры, индексы, текст
         */

        String xpath = String.format("//*[@resource-id='%s:id/%s']", AppiumSetup.getAndroidAppPackage(), id);
        SelenideElement element = $x(xpath);
        return element;
    }
}
