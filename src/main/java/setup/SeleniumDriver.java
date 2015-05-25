package main.java.setup;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumDriver {

    static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {
            driver = new FirefoxDriver();
//            DesiredCapabilities capability = DesiredCapabilities.firefox();
//            try {
//                 driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            }
//            capability.setBrowserName("firefox" );
//            capability.setVersion("38.0.1");
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
