package steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.ru.Если;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.То;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import cucumber.api.junit.Cucumber;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;

public class MyStepdefs {




    @То("^Я ввожу \"([^\"]*)\" поле поиска$")
    public void яВвожуПолеПоиска(String text)  {
        $x("//input[@name='q']").sendKeys(text);
    }

    @И("^Нажимаю Кнопу Найти$")
    public void нажимаюКнопуНайти()  {

        $x("//input[@name='q']").sendKeys(Keys.ENTER);
}

    @Если("^Я открываю главную страницу Google Поиска$")
    public void яОткрываюГлавнуюСтраницуGoogleПоиска() throws Throwable {
     //   Configuration.browser = "chrome";
        open("https://google.com");
    }



    @When("^I open google com$")
    public void iOpenGoogleCom() {
        Configuration.browser = "chrome";
        WebDriverManager.chromedriver().version("86").setup();
        open("https://yandex.ru");

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

    @When("^I open yandex ru$")
    public void iOpenYandexRu(){
        Configuration.browser = "chrome";
        WebDriverManager.chromedriver().version("86").setup();
        open("https://yandex.ru");
     //   $x("(//input[contains(class, input__control)])[4]");

    }

    @Then("^I type \"([^\"]*)\" in the search string on yandex page$")
    public void iTypeInTheSearchStringOnYandexPage(String text)  {
        $x("(//input[contains(class, input__control)])[4]").sendKeys(text);
    }

    @And("^Push Enter Button on yandex page$")
    public void pushEnterButtonOnYandexPage() {
        $x("(//button[@data-bem])[1]").click();

    }

    @And("^I check that the list of results on yandex page is not empty$")
    public void iCheckThatTheListOfResultsOnYandexPageIsNotEmpty(){
        $$x("//li[@class='serp-item']").shouldHave(CollectionCondition.sizeGreaterThan(0));
    }
}