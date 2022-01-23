Feature: FedEx UI automation assignment
  Background: As a user I want test the basic functionality of FedEx website
    Given I launch the application
    When  I select a region
    Then I verify the page title

  @run
  Scenario Outline: I click on Login button and check its functionality
    When I click on signup/login link
    And I click on Login option
    Then I verify that I am on login page
    When I enter username <username> and password <password>
    Then I verify the message
    Examples:
      |username|password|
      |apooravtest|test@123|

  @run
  Scenario: I click on Forgot User Id and Password Button
    When I click on signup/login link
    And I click on Login option
    Then I verify that I am on login page
    When I click on forgot username or password option
    Then I verify that I am on user id or password reset page

  @run
  Scenario Outline: I try to retrieve user id
    When I click on signup/login link
    And I click on Login option
    Then I verify that I am on login page
    When I click on forgot username or password option
    Then I verify that I am on user id or password reset page
    When I click on retrieve user Id button
    And I enter email id <Email Id> and clicked on submit button
    Then I verify that email has been sent on the <Email Id>
    Examples:
      |Email Id|
      |apoorav.test@gmail.com|

  @run
  Scenario: I try to reset password
    When I click on signup/login link
    And I click on Login option
    Then I verify that I am on login page
    When I click on forgot username or password option
    Then I verify that I am on user id or password reset page
    When I click on reset password button
    And I enter user id apoorav.test and clicked on submit button
    Then I verify the message

  @run
  Scenario: I click on create user id and check its functionality
    When I click on signup/login link
    And I click on create user id option
    Then I verify that I am on create user id page

  @run
  Scenario: I click on open an account option and check its functionality
    When I click on signup/login link
    And I click on open an account option
    Then I verify that I am on open a business account page

  @run
  Scenario: I enter wrong tracking id number and check error message
    When I enter random tracking number
    And I click on track button
    Then I verify the error message on tracking page

  @run
  Scenario: I click on shipping button to check its functionality
    When I click on shipping button
    Then I verify that I am on login page

  @run
  Scenario: I click on search button and search something
    When I click on search button
    And I search carriage
    Then I verify that search results are visible

  @run
  Scenario: I click on rate and transit button to check the functionality
    When I click on rate and transit button
    And I enter from city Noida and to city Pune
    And I enter package details and hit show rates button
    Then I verify that delivery rates and date is displayed


