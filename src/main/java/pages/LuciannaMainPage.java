package main.java.pages;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by ad on 18.05.2015.
 */
public class LuciannaMainPage extends LuciannaPage<LuciannaMainPage> {
    @Override
    protected ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.titleContains("Products");
    }

    @Override
    public String getPageUrl() {
        return "";
    }

    public LuciannaLoginPage goToLoginPage() {
        return new LuciannaLoginPage().openPage(LuciannaLoginPage.class);
    }

    public LuciannaMainPage open() {
        return new LuciannaMainPage().openPage(LuciannaMainPage.class);
    }

}
