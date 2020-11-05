package steps.pages.PageExample;

import cucumber.api.java.en.Then;

/*
Класс, где хранятся основные методы экрана или страницы, которые конвертируются в методы Cucumber
 */

public class PageActions {

    @Then("Push the button")
    public void pushTheBtn() {
        PageElements.getButton().click();
    }

    @Then("Push the button two")
    public void pushTheBtnTwo() {
        PageElements.getButtonTwo().click();
    }


}
