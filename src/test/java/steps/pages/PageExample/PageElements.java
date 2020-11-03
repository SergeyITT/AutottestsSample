package steps.pages.PageExample;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.MobileElement;
import moblie.AppiumSetup;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PageElements {

    private static PageElements instance; // Создаем экземпляр класса AppiumSetup
    private PageElements(){} // Создаем пустой конструктор
    public static PageElements getInstance(){
        if(instance == null){
            instance = new PageElements();
        }
        return instance;
    } // Метод, возвращающий AppiumSetup - новый или уже существующий

    SelenideElement button = $(By.id("ru.kinopoisk.dev:id/button_payment"));


}
