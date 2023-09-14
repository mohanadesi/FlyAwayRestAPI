package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources", // Path to your feature files
    glue = "steps" // Package where your step definitions are located
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}
