package com.google.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage extends PageObject {

    private final By pageDescriptionBy = By.xpath("//*[@id=\"kp-wp-tab-overview\"]/div[1]/div/div/div/div/div/div[1]/div/div/div/span[1]");

    public GoogleSearchPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public String getPageDescription() {
        return this.webDriver.findElement(pageDescriptionBy).getText();
    }
}
