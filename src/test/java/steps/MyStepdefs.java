package steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.ru.Если;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.То;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MyStepdefs {



    @То("^Ввести \"([^\"]*)\" в поле поиска$")
    public void яВвожуПолеПоиска(String text)  {
        $x("//input[@name='q']").sendKeys(text);
    }

    @И("^Нажать кнопку Найти$")
    public void нажимаюКнопуНайти()  {
        $x("//input[@name='q']").sendKeys(Keys.ENTER);
}

    @Если("^Открыть главную страницу Google Поиска$")
    public void открытьГлавнуюСтраницуGoogleПоиска(){
        open("https://google.com");
    }


    @Then("^I type \"([^\"]*)\" in the search string$")
    public void iTypeInTheSearchString(String text)  {
        $x("//input[@name='q']").sendKeys(text);
    }



    @And("^Push Enter Button$")
    public void pushEnterButton() {
        $x("//input[@name='q']").sendKeys(Keys.ENTER);
    }

    @And("^I check that the list of results is not empty$")
    public void iCheckThatTheListOfResultsIsNotEmpty()  {
       $$x("//div[@class='g']").shouldHave(CollectionCondition.sizeGreaterThan(0));
    }

    @When("^Open yandex ru$")
    public void openYandexRu(){
        open("https://yandex.ru");
    }

    @Then("^Type \"([^\"]*)\" in the search string on yandex page$")
    public void typeInTheSearchStringOnYandexPage(String text)  {
        $x("//*[contains(@class, 'input__control ')]").sendKeys(text);
    }

    @And("^Push Enter Button on yandex page$")
    public void pushEnterButtonOnYandexPage() {
        $x("(//button[@data-bem])[1]").click();

    }

    @And("^Check that the list of results on yandex page is not empty$")
    public void checkThatTheListOfResultsOnYandexPageIsNotEmpty(){
        $$x("//*[contains(@class,'serp-item')]").shouldHave(CollectionCondition.sizeGreaterThan(0));
    }
}