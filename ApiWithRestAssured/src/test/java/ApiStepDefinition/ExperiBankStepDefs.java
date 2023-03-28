package ApiStepDefinition;

import Core.HelperAppAutomation;
import POM.AppElements;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;

public class ExperiBankStepDefs {
    DesiredCapabilities dc = new DesiredCapabilities();
    AndroidDriver driver = null;

    @Given("app apk is there")
    public void appApkIsThere() throws InterruptedException, MalformedURLException {
        HelperAppAutomation hlp = new HelperAppAutomation();
        driver = hlp.apkLaunch();
    }

    @When("user enters {string}and {string}")
    public void userEntersUsernameAndPass(String userName, String password) throws InterruptedException {
        AppElements app = new AppElements(driver);
        app.login(userName, password);
    }

    @Then("user will navigate to home screen")
    public void userWillNavigateToHomeScreen() {
        System.out.println("Hoyna");
    }
}
