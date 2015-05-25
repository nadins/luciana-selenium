package main.java.testcases;

import main.java.features.Application;
import net.thucydides.core.annotations.Story;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * Created by ad on 18.05.2015.
 */
public class SampleTest {

    @Test
    public void testRegistration(){
        System.out.println("Registration");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://luciana.integro.kiev.ua/");
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            driver.quit();
        }

    }

    @Test(dependsOnMethods={"testRegistration"})
    public void testLogin(){
        System.out.println("Login to lucianna");
    }

    @Test(dependsOnMethods={"testLogin"})
    public void testChangePassword(){
        System.out.println("Change password");
    }
    @Test
    public void testSomeAssert(){
        System.out.println("Change password");
    }
}
