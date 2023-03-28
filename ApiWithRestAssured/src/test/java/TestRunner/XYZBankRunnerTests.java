package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(tags = "@topToBottom", features = {"src/test/resources/Features/xyzBank.feature"}, glue = {"WebStepDefinition"}, monochrome = true,
        dryRun = false, // runs feature file so false to stop
        plugin = {
                "pretty", "html:build/reports/feature.html"
        })
@Test
public class XYZBankRunnerTests extends AbstractTestNGCucumberTests {


}
