package main.java.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumDriver {

    static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new FirefoxDriver();
        }
        return driver;
    }


    public static void clearBrowserCache()
    {
        driver.manage().deleteAllCookies(); //delete all cookies
        try {
            Thread.sleep(10000); //wait 5 seconds to clear cookies.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
