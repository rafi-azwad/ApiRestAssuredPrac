package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import org.testng.annotations.Test;


@CucumberOptions(tags = "@app",
        features = {"src/test/resources/Features"},
        glue = {"ApiStepDefinition"},
        monochrome = true,
        dryRun = false, // runs feature file so false to stop
        plugin = {
                "pretty", "html:build/reports/feature.html"
        })
@Test
public class ExperiBankRunnerTest extends AbstractTestNGCucumberTests {
//        @BeforeClass
//        public static void beforeClass(){
//
//        }
//        @AfterClass
//        public static void AfterClass(){
//
//        }

}