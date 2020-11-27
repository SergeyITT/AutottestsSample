package features;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue =      "steps",
        tags = "@smoke"
//        dryRun = false,
//        strict = false,
//        snippets = SnippetType.UNDERSCORE
    //    name = "^Успешно*"

)

public class RunTest {
    @BeforeClass
    public static void startApp(){
            Configuration.startMaximized = true;
            WebDriverManager.chromedriver().browserVersion("86").setup();
            SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @AfterClass
    public static void afterApp(){
            SelenideLogger.removeListener("allure");
    }
}


