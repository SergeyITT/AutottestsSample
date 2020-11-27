package steps.pages.PageExample;

import io.cucumber.java.en.When;

// Класс, где хранятся основные методы экрана или страницы, которые конвертируются в методы Cucumber
public class PageActions {

    @When("Push the button one")
    public void pushTheBtnOne()  throws Throwable {
        PageElements.button_one.click();
    }

    @When("Push the field one")
    public void pushTheFieldOne()  throws Throwable {
        PageElements.text_field_one.click();
    }

    @When("Send value {string} the field two")  // "([^"]*) - String input?, (\\d+) - int input?
    public void pushTheFieldTwo(String value) throws Throwable  {
        PageElements.text_field_one.click();
    }


}
