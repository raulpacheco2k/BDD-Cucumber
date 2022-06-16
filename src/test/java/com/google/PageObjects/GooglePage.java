package com.google.PageObjects;

import org.openqa.selenium.By;

public class GooglePage extends PageObject {

    private final By googleSearchButtonBy = By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]");
    private final By searchInputBy = By.name("q");

    public GooglePage() {
        super("https://www.google.com");
    }

    public GooglePage fillSearchInput(String string) {
        this.webDriver.findElement(this.searchInputBy).sendKeys(string);
        return this;
    }

    public GoogleSearchPage search() {
        this.webDriver.findElement(this.googleSearchButtonBy).click();
        return new GoogleSearchPage(this.webDriver, webDriver.getCurrentUrl());
    }
}
