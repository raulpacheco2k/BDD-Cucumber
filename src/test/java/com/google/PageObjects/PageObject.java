package com.google.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObject {

    protected WebDriver webDriver;
    private final String url;

    public PageObject(String url) {
        System.setProperty("webdriver.chrome.driver", "./docs/drivers/chromedriver.exe");
        this.webDriver = new ChromeDriver();
        this.url = url;
    }

    public PageObject(WebDriver webDriver, String url) {
        System.setProperty("webdriver.chrome.driver", "../docs/drivers/chromedriver.exe");
        this.webDriver = webDriver;
        this.url = url;
    }

    public void beforeEach() {
        this.webDriver.manage().window().maximize();
        this.webDriver.navigate().to(this.url);
    }

    public void afterEach() {
        this.webDriver.quit();
    }


}
