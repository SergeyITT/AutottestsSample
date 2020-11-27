package steps;

import com.codeborne.selenide.SelenideElement;
import ui.Config;
import static com.codeborne.selenide.Selenide.$x;

public interface Page {

    // Отдает индекс используемой в конфиге платформы
    static int switchLocator() {
        int platformIndex = 0;
        switch (Config.getPlatformName()) {
            case ANDROID: platformIndex = 0; break;
            case IOS: platformIndex = 1; break;
            default: System.out.print("ERROR: Undefined platform. Android set as default platform"); break;
        }
        return platformIndex;
    }

    // Записывает локарторы для всех платформ в массив и отдает нужный по индексу платформы
    static SelenideElement setLocators(SelenideElement Android, SelenideElement ios){
        SelenideElement[] array = {Android, ios};
        return array[Page.switchLocator()];
    }

    // Метод для Android, который ищет элемент по id. Package получает из конфига
    static SelenideElement getLocatorByResourceId(String id) {
        return $x(String.format("//*[@resource-id='%s:id/%s']", Config.getAndroidAppPackage(), id));
    }
}
