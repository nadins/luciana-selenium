package main.java.testcases;

import static main.java.setup.SeleniumDriver.getDriver;
import static main.java.setup.SeleniumDriver.clearBrowserCache;

import main.java.pages.LuciannaLoginPage;
import main.java.pages.LuciannaMainPage;
import main.java.setup.LucianaHelper;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.*;

/**
 * Created by ad on 18.05.2015.
 */
public class OpenLoginPageTest {

    public static final String EMAIL = "nadin.slusarenko1@gmail.com";
    public static final String PASSWORD = "1qwerty12";
    public static final String INCORRECT_PASSWORD = "111";
    public static final String LOGIN = "NADIN-SLUSARENKO1";


    @Test(groups = {"positive"})
    public void loginWithCorrectCredentials() {
        LuciannaLoginPage loginPage = new LuciannaMainPage().open().goToLoginPage();
        loginPage.login(EMAIL, PASSWORD);
        LucianaHelper.getScreenshot(getDriver());
        assertTrue(loginPage.getWelcomeUser().getText().contains(LOGIN));
    }

    @AfterMethod
    public static void clearCache() {
        clearBrowserCache();
    }

    @Test(groups = {"negative"})
    public void loginWithInCorrectCredentials() {

        LuciannaLoginPage loginPage = new LuciannaMainPage().open().goToLoginPage();
        loginPage.login(EMAIL, INCORRECT_PASSWORD);
        ExpectedConditions.textToBePresentInElement(loginPage.getWoocommerceError(), LOGIN.toLowerCase());
        LucianaHelper.getScreenshot(getDriver());
        assertTrue(loginPage.getWoocommerceError().getText().contains(EMAIL.toLowerCase().substring(0, 17)));

    }

    @AfterClass
    public static void tearDown() {
        clearBrowserCache();
        getDriver().quit();
        getDriver().close();
    }
}
