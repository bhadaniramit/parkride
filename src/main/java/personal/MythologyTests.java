package personal;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber.html",
                "json:target/results/cucumber.json"},
        features = {"src/main/resources/features/Wiki.feature"},
        tags = "@auto",
        glue = {"src/main/java/personal/"},
        dryRun = true
)

public class MythologyTests {

}
