package steps.pages.PageExample;

import com.codeborne.selenide.SelenideElement;
import moblie.Actions;

/*
Класс Page Object паттерна, где условно находится описание конкретного экрана / страницы
TODO: Адаптировать геттеры для кроссплатформы
 */

public class PageElements {

    /*
    Надежнее всего пользоваться селектором по xpath. Здесь используется удобный для мобилок метод, который
    упрощает написание локаторов. Но в чистом виде локатор выглядит так:
    SelenideElement element = $x("//*[@resource-id='appPackage:id/id']");
     */

    private static SelenideElement button = Actions.getLocatorByResourceId("button_payment");
    private static SelenideElement buttonTwo = Actions.getLocatorByResourceId("button_payment_two");

    public static SelenideElement getButton() {
        return button;
    }
    public static SelenideElement getButtonTwo() {
        return buttonTwo;
    }
}
