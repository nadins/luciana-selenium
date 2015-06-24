package main.java.testcases;

import main.java.pages.LuciannaLoginPage;
import main.java.pages.LuciannaMainPage;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static main.java.setup.SeleniumDriver.clearBrowserCache;
import static main.java.setup.SeleniumDriver.getDriver;
import static org.testng.Assert.assertTrue;

/**
 * Created by ad on 18.05.2015.
 */
public class OpenLoginPageTest {

    public static final String EMAIL = "nadin.slusarenko1@gmail.com";
    public static final String PASSWORD = "1qwerty12";
    public static final String INCORRECT_PASSWORD = "111";
    public static final String LOGIN = "NADIN-SLUSARENKO1";


    WebDriver driver;

    @BeforeTest
    @Parameters({"browser"})
    public void setUpNode(String browser) throws MalformedURLException {

        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\ad\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
                driver = new ChromeDriver();
                driver.get("http://luciana.integro.kiev.ua/");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    driver.quit();
                }

            case "firefox":
                DesiredCapabilities capability = DesiredCapabilities.firefox();
                try {
                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                capability.setBrowserName("firefox");
                capability.setVersion("38.0.1");

            default:
                break;
        }

    }


    @Test(groups = {"positive"}, priority = 1)
    public void loginWithCorrectCredentials() {
        LuciannaLoginPage loginPage = new LuciannaMainPage().open(driver).goToLoginPage(driver);
        loginPage.login(EMAIL, PASSWORD);
//        LucianaHelper.getScreenshot(getDriver());
        assertTrue(loginPage.getWelcomeUser().getText().contains(LOGIN));
    }

    @AfterMethod
    public static void clearCache() {
        clearBrowserCache();
    }

    @Test(groups = {"negative"}, priority = 2)
    public void loginWithInCorrectCredentials() {

        LuciannaLoginPage loginPage = new LuciannaMainPage().open(driver).goToLoginPage(driver);
        loginPage.login(EMAIL, INCORRECT_PASSWORD);
        ExpectedConditions.textToBePresentInElement(loginPage.getWoocommerceError(), LOGIN.toLowerCase());
//        LucianaHelper.getScreenshot(getDriver());
        assertTrue(loginPage.getWoocommerceError().getText().contains(EMAIL.toLowerCase()));

    }

    @AfterClass
    public static void tearDown() {
        clearBrowserCache();
        getDriver().quit();
        getDriver().close();
    }
}
