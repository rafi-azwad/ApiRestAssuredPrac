package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


@CucumberOptions(tags = "@smoke", features = {"src/test/resources/Features/login.feature"}, glue = {"WebStepDefinition"}, monochrome = true,
        dryRun = false, // runs feature file so false to stop
        plugin = {
                "pretty", "html:build/reports/feature.html"
        })
@Test
public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
//        @BeforeClass
//        public static void beforeClass(){
//
//        }
//        @AfterClass
//        public static void AfterClass(){
//
//        }

}