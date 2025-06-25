package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",          // Path to feature files
        glue = {"stepdefinitions"},                        // Path to step definitions
        plugin = {
                "pretty",                                      // Console output
                "html:target/cucumber-report.html"             // HTML report
        },
        monochrome = true                                  // Clean console output
)
public class TestRunner {
}
