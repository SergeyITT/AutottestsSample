package steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.ru.Если;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.То;
import cucumber.api.java.ru.Тогда;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import org.openqa.selenium.Keys;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;


public class MyStepdefs {


    @То("^Ввести \"([^\"]*)\" в поле поиска$")
    public void яВвожуПолеПоиска(String text) {
        $x("//input[@name='q']").sendKeys(text);
    }

    @И("^Нажать кнопку Найти$")
    public void нажимаюКнопуНайти() {
        $x("//input[@name='q']").sendKeys(Keys.ENTER);
    }

    @Если("^Открыть главную страницу Google Поиска$")
    public void открытьГлавнуюСтраницуGoogleПоиска() {
        open("https://google.com");
    }


    @Then("^I type \"([^\"]*)\" in the search string$")
    public void iTypeInTheSearchString(String text) {
        $x("//input[@name='q']").sendKeys(text);
    }


    @And("^Push Enter Button$")
    public void pushEnterButton() {
        $x("//input[@name='q']").sendKeys(Keys.ENTER);
    }

    @And("^I check that the list of results is not empty$")
    public void iCheckThatTheListOfResultsIsNotEmpty() {
        $$x("//div[@class='g']").shouldHave(CollectionCondition.sizeGreaterThan(0));
    }

    @When("^Open yandex ru$")
    public void openYandexRu() {
        open("https://yandex.ru");
    }

    @Then("^Type \"([^\"]*)\" in the search string on yandex page$")
    public void typeInTheSearchStringOnYandexPage(String text) {
        $x("//*[contains(@class, 'input__control ')]").sendKeys(text);
    }

    @And("^Push Enter Button on yandex page$")
    public void pushEnterButtonOnYandexPage() {
        $x("(//button[@data-bem])[1]").click();

    }

    @And("^Check that the list of results on yandex page is not empty$")
    public void checkThatTheListOfResultsOnYandexPageIsNotEmpty() {
        $$x("//*[contains(@class,'serp-item')]").shouldHave(CollectionCondition.sizeGreaterThan(0));
    }

    @То("^Ввести в поле поиска$")
    public void ввестиВПолеПоиска(List<String> arg) {
        for (int i = 0; i < arg.size(); i++) {
         SelenideElement x = $x("//input[@name='q']");
         x.click();
            ElementsCollection xx =$$x("//input[@name='q']");
        }
    }

    @Тогда("^Проверить что количество результатов больше (\\d+)$")
    public void проверитьЧтоКоличествоРезультатовБольше(int resultCount) {
        $$x("//div[@class='g']").shouldHave(CollectionCondition.sizeGreaterThan(resultCount));
    }

    @Given("Enter values from the table into the login form")
    public void enterValuesFromTheTableIntoTheLoginForm(DataTable dataTable) {
        List<Map<String,String>> userList = dataTable.asMaps(String.class,String.class);
        System.out.println(userList);
        for(Map<String, String> e :userList){
            System.out.println("Login: "+ e.get("login") + " Password: " + e.get("password"));
        }

    }

    @io.cucumber.java.en.And("Something")
    public void something() {
    }

    @Given("My first step")
    public void myFirstStep() {
    }
}
