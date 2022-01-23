package com.fedex.automation.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.CSS, using = "button.close")
    public WebElement closeButton;

    @FindBy(how = How.XPATH, using = "//img[@alt='FedEx India Homepage']")
    public WebElement pageTitle;

    @FindBy(how = How.CSS, using = "a#fxg-dropdown-signIn")
    public WebElement signUpOrLoginOption;

    @FindBy(how = How.CSS, using = "a.fxg-geo-locator__global-link")
    public WebElement searchLocation;

    @FindBy(how = How.XPATH, using = "//p[contains(text(),'India')]/a")
    public WebElement region;

    @FindBy(how = How.CSS, using = "a[title='Log In']")
    public WebElement login;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Create User ID')]")
    public WebElement createUserId;

    @FindBy(how = How.CSS, using = "a[title='Open an Account']")
    public WebElement openAnAccount;

    @FindBy(how = How.NAME, using = "trackingnumber")
    public WebElement trackingNumberInput;

    @FindBy(how = How.XPATH, using = "(//button[contains(text(),'Track')])[2]")
    public WebElement trackButton;

    @FindBy(how = How.XPATH, using = "(//button[@class='fxg-cube__content'])[3]")
    public WebElement shippingButton;

    @FindBy(how = How.XPATH, using = "//div[@class='fxg-user-options__option fxg-user-options__search-btn   ']//child::span")
    public WebElement searchButton;

    @FindBy(how = How.ID, using = "fxg-search-text")
    public WebElement searchInput;

    @FindBy(how = How.CSS, using = "a#fxg-search-icon")
    public WebElement searchLink;

    @FindBy(how = How.XPATH, using = "(//button[@class='fxg-cube__content'])[1]")
    public WebElement rateAndTransitButton;

}
