package steps.pages.PageExample;

import com.codeborne.selenide.SelenideElement;
import steps.Page;
import ui.platforms.Android;
import ui.platforms.IOS;

// Класс Page Object паттерна, где условно находится описание конкретного экрана / страницы
public class PageElements implements Page {

    /*
    ПРО ЛОКАТОРЫ:
    Надежнее всего пользоваться селектором по xpath. Здесь используется удобный для мобилок метод, который
    упрощает написание локаторов. Но в чистом виде локатор выглядит так:
    SelenideElement element = $x("//*[@resource-id='appPackage:id/id']");

    ПРО РЕАЛИЗАЦИЮ PAGE OBJECT:
    Для того, чтобы одни и те же тесты работали и на IOS и на Android, был написан метод,
    присваивающий платформам индекс, и переключающий геттеры локаторов на использование
    1 из элементов массива. В шаблоне это - 0 для Android, 1 - для IOS.
    Таким образом, создавая локатор, мы создаем массив типа SelenideElement и записываем
    туда все локаторы для необходимых платформ в строгом порядке. В шаблоне это: { Android, Ios }
    Далее, в геттере возвращаем необходимый элемент массива. Индекс элемента массива определяется методом
    в интерфейсе Page. Метод с определением индекса смотрит на геттер PLATFORM_NAME из Config,
    который возвращает enum с тестируемой платформой
     */


    public static SelenideElement
            button = Page.getCurrentLocator(Android.getLocatorByResourceId("button_payment"),
            IOS.getLocatorByResourceId("button_payment")),
            button2 = Page.getCurrentLocator(Android.getLocatorByResourceId("button_payment"),
            IOS.getLocatorByResourceId("button_payment"));
}


