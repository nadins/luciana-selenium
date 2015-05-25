package main.java.testsforrefactoring;



import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by ad on 25.05.2015.
 */
public class TestAddToCart {

        private WebDriver driver;
        private String baseUrl;
        private boolean acceptNextAlert = true;
        private StringBuffer verificationErrors = new StringBuffer();

        @Before
        public void setUp() throws Exception {
            driver = new FirefoxDriver();
            baseUrl = "http://luciana.integro.kiev.ua/";
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }

        @Test
        public void testUntitled() throws Exception {
            driver.get(baseUrl + "/?page_id=7");
            driver.findElement(By.linkText("Бра")).click();
            driver.findElement(By.xpath("(//img[@alt='Placeholder'])[2]")).click();
            driver.findElement(By.xpath("(//img[@alt='Placeholder'])[2]")).click();
            driver.findElement(By.name("quantity")).clear();
            driver.findElement(By.name("quantity")).sendKeys("2");
            driver.findElement(By.name("quantity")).clear();
            driver.findElement(By.name("quantity")).sendKeys("2");
            driver.findElement(By.name("quantity")).click();
            driver.findElement(By.name("quantity")).clear();
            driver.findElement(By.name("quantity")).sendKeys("3");
            driver.findElement(By.name("quantity")).clear();
            driver.findElement(By.name("quantity")).sendKeys("3");
            driver.findElement(By.name("quantity")).click();
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            driver.findElement(By.linkText("К оплате")).click();
            driver.findElement(By.linkText("К оплате")).click();
            driver.findElement(By.id("payment_method_bacs")).click();
            driver.findElement(By.id("payment_method_bacs")).click();
            driver.findElement(By.name("login")).click();
            driver.findElement(By.name("login")).click();
            driver.findElement(By.id("payment_method_bacs")).click();
            driver.findElement(By.id("payment_method_bacs")).click();
            driver.findElement(By.id("billing_first_name")).clear();
            driver.findElement(By.id("billing_first_name")).sendKeys("qq");
            driver.findElement(By.id("billing_first_name")).clear();
            driver.findElement(By.id("billing_first_name")).sendKeys("qq");
            driver.findElement(By.id("billing_last_name")).clear();
            driver.findElement(By.id("billing_last_name")).sendKeys("qq");
            driver.findElement(By.id("billing_last_name")).clear();
            driver.findElement(By.id("billing_last_name")).sendKeys("qq");
            driver.findElement(By.id("billing_city")).clear();
            driver.findElement(By.id("billing_city")).sendKeys("qqqqq");
            driver.findElement(By.id("billing_city")).clear();
            driver.findElement(By.id("billing_city")).sendKeys("qqqqq");
            driver.findElement(By.id("billing_address_1")).clear();
            driver.findElement(By.id("billing_address_1")).sendKeys("qqqq  qq");
            driver.findElement(By.id("billing_address_1")).clear();
            driver.findElement(By.id("billing_address_1")).sendKeys("qqqq  qq");
            driver.findElement(By.id("payment_method_bacs")).click();
            driver.findElement(By.id("payment_method_bacs")).click();
            driver.findElement(By.id("billing_state")).clear();
            driver.findElement(By.id("billing_state")).sendKeys("343222");
            driver.findElement(By.id("billing_state")).clear();
            driver.findElement(By.id("billing_state")).sendKeys("343222");
            driver.findElement(By.id("billing_postcode")).clear();
            driver.findElement(By.id("billing_postcode")).sendKeys("3535353");
            driver.findElement(By.id("billing_postcode")).clear();
            driver.findElement(By.id("billing_postcode")).sendKeys("3535353");
            driver.findElement(By.name("login")).click();
            driver.findElement(By.name("login")).click();
            driver.findElement(By.id("payment_method_bacs")).click();
            driver.findElement(By.id("payment_method_bacs")).click();
        //    assertTrue(driver.findElement(By.id("payment_method_bacs").getText().contains(EMAIL.toLowerCase())));

        }

        @After
        public void tearDown() throws Exception {
            driver.quit();
            String verificationErrorString = verificationErrors.toString();
            if (!"".equals(verificationErrorString)) {
                fail(verificationErrorString);
            }
        }

           }

