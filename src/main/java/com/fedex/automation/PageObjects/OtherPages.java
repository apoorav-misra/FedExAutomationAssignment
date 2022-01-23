package com.fedex.automation.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class OtherPages {

    public OtherPages(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.ID, using = "title")
    public WebElement loginPageTitle;

    @FindBy(how = How.ID, using = "userId")
    public WebElement userId;

    @FindBy(how = How.ID, using = "password")
    public WebElement password;

    @FindBy(how=How.ID, using = "login-btn")
    public WebElement loginButton;

    @FindBy(how = How.ID, using = "invalidCredentials")
    public WebElement invalidCredentials;

    @FindBy(how = How.XPATH, using = "//p[contains(text(),'We are having trouble')]")
    public WebElement loginErrorMessage;

    @FindBy(how = How.XPATH, using = "//b[contains(text(),'Create a User ID')]")
    public WebElement createUserId;

    @FindBy(how = How.CSS, using = "a#requestCode-btn")
    public WebElement forgotUserIdOrPassword;

    @FindBy(how = How.CSS, using = "h1#loginSolutionsTitle")
    public WebElement forgotCredentialsHeader;

    @FindBy(how = How.CSS, using = "button#reset-btn")
    public WebElement resetPasswordButton;

    @FindBy(how = How.CSS, using = "button#retrieve-btn")
    public WebElement retrieveUserIdButton;

    @FindBy(how = How.ID, using = "email")
    public WebElement emailIdInput;

    @FindBy(how = How.ID, using = "submit-btn")
    public WebElement submitButton;

    @FindBy(how = How.ID, using = "email-sent-msg")
    public WebElement emailSentMessage;

    @FindBy(how = How.CSS, using = "a[title='Open a Business Account']")
    public WebElement openABusinessAccount;

    @FindBy(how = How.XPATH, using = "//h2[contains(text(),'Open a FedEx account')]")
    public WebElement openABusinessAccountHeader;

    @FindBy(how = How.CSS, using = "span.systemErrorMessageTop")
    public WebElement trackingErrorMessage;

    @FindBy(how = How.XPATH, using = "//div[@class='search-result-count']")
    public WebElement searchResults;

    @FindBy(how = How.CSS, using = "input#fromGoogleAddress")
    public WebElement fromAddress;

    @FindBy(how = How.CSS, using = "input#toGoogleAddress")
    public WebElement toAddress;

    @FindBy(how = How.XPATH, using = "//input[starts-with(@id,'package-details') and @type='text']")
    public WebElement packageWeight;

    @FindBy(how = How.CSS, using = "button#e2ePackageDetailsSubmitButtonRates")
    public WebElement showRates;

    @FindBy(how = How.XPATH, using = "//h5[contains(text(),'Here are the rates and delivery dates')]")
    public WebElement ratesDeliveryMessage;
}
