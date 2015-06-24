package main.java.features;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.pages.LuciannaLoginPage;
import main.java.pages.LuciannaMainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class Application {

    protected WebDriver driver;
    LuciannaLoginPage loginPage;


    public static final String EMAIL = "nadin.slusarenko1@gmail.com";

    @Before
    public void setup() {
        driver = new FirefoxDriver();
    }

    @Given("^I open lucianna$")
    public void I_open_lucianna() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
         loginPage = new LuciannaMainPage().open(driver).goToLoginPage(driver);

    }

    @When("^I enter login \"([^\"]*)\" and password \"([^\"]*)\"in search textbox$")
    public void I_enter_params(String login, String password) {
        loginPage.login(login, password);
    }

    @Then("^I should be logged in$")
    public void I_should_get_correct_result() {
        assertTrue(loginPage.getWoocommerceError().getText().contains(EMAIL.toLowerCase()));

        driver.close();
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

}
