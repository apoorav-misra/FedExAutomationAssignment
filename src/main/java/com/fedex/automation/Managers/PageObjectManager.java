package com.fedex.automation.Managers;

import com.fedex.automation.PageObjects.HomePage;
import com.fedex.automation.PageObjects.OtherPages;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjectManager {

    private HomePage homePage;
    private OtherPages otherPages;
    private final WebDriver driver;

    public PageObjectManager(){
        this.driver = DriverManager.getDriver();
    }

    public HomePage getHomePage() {
        return homePage == null ? new HomePage(driver) : homePage;
    }

    public OtherPages getLoginPage() {
        return otherPages == null ? new OtherPages(driver) : otherPages;
    }

    public By getByLocator(WebElement webElement) {
        String element = webElement.toString().split(
                "(?=\\sid:\\s|\\sname:\\s|\\sselector:\\s|\\slink text:|\\sxpath:\\s|" +
                        "By.id:\\s|By.name:\\s|By.tagName:\\s|By.className:\\s|By.cssSelector:\\s|" +
                        "By.linkText:\\s|By.partialLinkText:\\s|By.xpath:\\s)")[1];

        String[] locator = StringUtils.removeEnd(element, "]").split(":\\s");
        String method = locator[0].trim();
        if (method.equals("xpath"))
            return By.xpath(locator[1]);

        String selector = StringUtils.removeEnd(locator[1], "'");
        switch (method) {
            case "id":
            case "By.id":
                return By.id(selector);
            case "name":
            case "By.name":
                return By.name(selector);
            case "By.tagName":
                return By.tagName(selector);
            case "By.className":
                return By.className(selector);
            case "selector":
            case "By.cssSelector":
                return By.cssSelector(selector);
            case "By.linkText":
                return By.linkText(selector);
            case "link text":
            case "By.partialLinkText":
                return By.partialLinkText(selector);
            case "By.xpath":
                return By.xpath(selector);
            default:
                System.out.println("Error! [" + method + "]");
                return null;
        }
    }
}
