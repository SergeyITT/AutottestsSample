package features;
import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
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
    RunTest() {


    }
}


