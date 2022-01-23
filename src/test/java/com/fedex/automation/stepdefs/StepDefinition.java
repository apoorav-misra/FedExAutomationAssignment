package com.fedex.automation.stepdefs;

import com.fedex.automation.Constants.GlobalConstants;
import com.fedex.automation.Enums.WaitTypes;
import com.fedex.automation.Managers.DriverManager;
import com.fedex.automation.Managers.PageObjectManager;
import com.fedex.automation.PageObjects.HomePage;
import com.fedex.automation.PageObjects.OtherPages;
import com.fedex.automation.Utils.Waits;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class StepDefinition {
    PageObjectManager pageObjectManager = new PageObjectManager();
    HomePage homePage = pageObjectManager.getHomePage();
    OtherPages otherPages = pageObjectManager.getLoginPage();

    @Given("^I launch the application$")
    public void i_launch_the_application(){
        DriverManager.loadUrl();
        homePage.searchLocation.click();
    }

    @When("^I select a region$")
    public void i_select_a_region(){
        homePage.region.click();
        homePage.closeButton.click();
    }

    @Then("^I verify the page title$")
    public void i_verify_page_title(){
        assertThat(homePage.pageTitle.isDisplayed()).isTrue();
    }

    @When(("^I click on signup/login link$"))
    public void i_click_on_signup_or_login_link() {
        homePage.signUpOrLoginOption.click();
    }

    @And("^I click on Login option$")
    public void i_click_on_login_option(){
        homePage.login.click();
    }

    @Then("^I verify that I am on login page$")
    public void i_verify_i_am_on_login_page() {
        Waits.performExplicitWait(WaitTypes.VISIBLE,pageObjectManager.getByLocator(otherPages.loginPageTitle));
        assertThat(otherPages.loginPageTitle.isDisplayed()).isTrue();
        assertThat(otherPages.loginPageTitle.getText().trim()).isEqualTo(GlobalConstants.loginPageTitle);
    }

    @When("^I enter username (.*) and password (.*)$")
    public void i_enter_username_and_password(String username, String password){
        otherPages.userId.sendKeys(username);
        otherPages.password.sendKeys(password);
        otherPages.loginButton.click();
        System.out.println("clicked");
    }

    @Then("^I verify the message$")
    public void i_verify_the_message() {
        Waits.performExplicitWait(WaitTypes.VISIBLE,pageObjectManager.getByLocator(otherPages.loginErrorMessage));
        if(otherPages.loginErrorMessage.isDisplayed())
            assertThat(otherPages.loginErrorMessage.getText().trim()).isEqualTo(GlobalConstants.loginErrorMessage);
        else
            assertThat(otherPages.invalidCredentials.getText().trim()).isEqualTo(GlobalConstants.invalidCredentialsMessage);
    }

    @And("^I click on create user id option$")
    public void i_click_on_create_user_id_option(){
        homePage.createUserId.click();
    }

    @Then("^I verify that I am on create user id page$")
    public void i_verify_i_am_on_create_user_id_page(){
        assertThat(otherPages.createUserId.isDisplayed()).isTrue();
    }

    @When("^I click on forgot username or password option$")
    public void i_click_on_forgot_username_or_password(){
        otherPages.forgotUserIdOrPassword.click();
    }

    @Then("^I verify that I am on user id or password reset page$")
    public void i_verify_that_i_am_on_reset_userid_password_page() {
        Waits.performExplicitWait(WaitTypes.VISIBLE,pageObjectManager.getByLocator(otherPages.forgotCredentialsHeader));
        assertThat(otherPages.forgotCredentialsHeader.isDisplayed()).isTrue();
        assertThat(otherPages.resetPasswordButton.isEnabled()).isTrue();
        assertThat(otherPages.retrieveUserIdButton.isEnabled()).isTrue();
    }

    @When("^I click on retrieve user Id button$")
    public void i_click_on_retrieve_user_id_button(){
        otherPages.retrieveUserIdButton.click();
    }

    @When("^I click on reset password button$")
    public void i_click_on_reset_password_button(){
        otherPages.resetPasswordButton.click();
    }

    @And("^I enter email id (.*) and clicked on submit button$")
    public void i_enter_email_address_and_clicked_on_submit_button(String email){
        Waits.performExplicitWait(WaitTypes.VISIBLE,pageObjectManager.getByLocator(otherPages.emailIdInput));
        otherPages.emailIdInput.sendKeys(email);
        otherPages.submitButton.click();
    }

    @Then("^I verify that email has been sent on the (.*)$")
    public void i_verify_that_email_has_been_sent(String email){
        Waits.performExplicitWait(WaitTypes.VISIBLE,pageObjectManager.getByLocator(otherPages.loginErrorMessage));
        assertThat(otherPages.loginErrorMessage.isDisplayed()).isTrue();
        assertThat(otherPages.loginErrorMessage.getText().trim()).isEqualTo(GlobalConstants.loginErrorMessage);
    }

    @When("^I enter user id (.*) and clicked on submit button$")
    public void i_enter_user_id_and_clicked_on_submit_button(String userId){
        Waits.performExplicitWait(WaitTypes.VISIBLE,pageObjectManager.getByLocator(otherPages.userId));
        otherPages.userId.sendKeys(userId);
        otherPages.submitButton.click();
    }

    @And("^I click on open an account option$")
    public void i_click_on_open_an_account_option(){
        homePage.openAnAccount.click();
    }

    @Then("^I verify that I am on open a business account page$")
    public void i_verify_that_i_am_on_open_a_business_account_page() {
        Waits.performExplicitWait(WaitTypes.VISIBLE,pageObjectManager.getByLocator(otherPages.openABusinessAccount));
        assertThat(otherPages.openABusinessAccount.isDisplayed()).isTrue();
        otherPages.openABusinessAccount.click();
        assertThat(otherPages.openABusinessAccountHeader.getText()).isEqualToIgnoringWhitespace(GlobalConstants.openAccountMessage);
    }

    @When("^I enter random tracking number$")
    public void i_enter_tracking_number(){
        Random random = new Random();
        int number = random.nextInt(99999999);
        homePage.trackingNumberInput.sendKeys(String.valueOf(number));
    }

    @And("^I click on track button$")
    public void i_click_on_track_button(){
        Waits.sleep(3000);
        homePage.trackButton.click();
    }

    @Then("^I verify the error message on tracking page$")
    public void i_verify_the_error_message_on_tracking_page() {
        Waits.performExplicitWait(WaitTypes.VISIBLE,pageObjectManager.getByLocator(otherPages.trackingErrorMessage));
        assertThat(otherPages.trackingErrorMessage.isDisplayed()).isTrue();
        assertThat(otherPages.trackingErrorMessage.getText().trim()).isEqualTo(GlobalConstants.trackingErrorMessage);
    }

    @When("^I click on shipping button$")
    public void i_click_on_shipping_button(){
        homePage.shippingButton.click();
    }

    @When("^I click on search button$")
    public void i_click_on_search_button(){
        homePage.searchButton.click();
    }

    @And("^I search (.*)$")
    public void i_search_a_parameter(String parameter){
        homePage.searchInput.sendKeys(parameter);
        homePage.searchLink.click();
    }

    @Then("^I verify that search results are visible$")
    public void i_verify_search_results_are_visible() {
        Waits.performExplicitWait(WaitTypes.VISIBLE,pageObjectManager.getByLocator(otherPages.searchResults));
        assertThat(otherPages.searchResults.isDisplayed()).isTrue();
    }

    @When("^I click on rate and transit button$")
    public void i_click_on_rate_and_transit_button(){
        homePage.rateAndTransitButton.click();
    }

    @And("^I enter from city (.*) and to city (.*)$")
    public void i_enter_from_address_and_to_address(String fromCity, String toCity){
        Waits.performExplicitWait(WaitTypes.VISIBLE,pageObjectManager.getByLocator(otherPages.fromAddress));
        otherPages.fromAddress.sendKeys(fromCity);
        Waits.sleep(5000);
        otherPages.fromAddress.sendKeys(Keys.ARROW_DOWN, Keys.RETURN);
        Waits.performExplicitWait(WaitTypes.VISIBLE,pageObjectManager.getByLocator(otherPages.toAddress));
        otherPages.toAddress.sendKeys(toCity);
        Waits.sleep(5000);
        otherPages.toAddress.sendKeys(Keys.ARROW_DOWN, Keys.RETURN);
    }

    @And("I enter package details and hit show rates button")
    public void i_enter_other_details_and_hit_show_rate_button(){
        Waits.performExplicitWait(WaitTypes.VISIBLE,pageObjectManager.getByLocator(otherPages.packageWeight));
        otherPages.packageWeight.sendKeys("20");
        otherPages.showRates.click();
    }

    @Then("^I verify that delivery rates and date is displayed$")
    public void i_verify_that_delivery_rate_and_date_is_displayed(){
        Waits.performExplicitWait(WaitTypes.VISIBLE,pageObjectManager.getByLocator(otherPages.ratesDeliveryMessage));
        assertThat(otherPages.ratesDeliveryMessage.isDisplayed()).isTrue();
    }
}
