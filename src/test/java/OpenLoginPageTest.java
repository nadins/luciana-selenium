package java;

import main.java.pages.LuciannaLoginPage;
import main.java.pages.LuciannaMainPage;
import org.junit.AfterClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

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


    @Test
      public void loginWithCorrectCredentials() {
        LuciannaLoginPage loginPage = new LuciannaMainPage().open().goToLoginPage();
        loginPage.login(EMAIL, PASSWORD);
        assertTrue(loginPage.getWelcomeUser().getText().contains(LOGIN));
    }

    @AfterMethod
    public static void clearCache(){
        clearBrowserCache();
    }

    @Test
    public void loginWithInCorrectCredentials() {

        LuciannaLoginPage loginPage = new LuciannaMainPage().open().goToLoginPage();
        loginPage.login(EMAIL, INCORRECT_PASSWORD);
        ExpectedConditions.textToBePresentInElement(loginPage.getWoocommerceError(),LOGIN.toLowerCase());
        assertTrue(loginPage.getWoocommerceError().getText().contains(EMAIL.toLowerCase().substring(0, 17)));

    }

    @AfterClass
    public static void tearDown() {
        clearBrowserCache();
        getDriver().close();

    }
}
