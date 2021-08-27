package navigationwiki;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber.html",
                "json:target/results/cucumber.json"},
        features = {"src/test/resources/features/wiki.feature"},
        tags = "@auto",
        glue = {"src/main/java/navigationwiki"}
)

public class MythologyTests {

}
