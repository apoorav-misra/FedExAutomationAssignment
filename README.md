# FedExAutomationAssignment
This repo is being used to demonstrate automation of FedEx website.


# Guidelines for the project
* Create a testing framework using Java, Selenium, Cucumber
* Write scripts that would automate 10 test cases that you see fit to be included in a regression test set.

# Tech Stack Used
* Programming Language - Java
* Automation Library - Selenium
* Development Apporach - Cucumber

# Scenarios Automated
* User clicks on Login Button and entering random username and password to check for error.
* User clicks on Forgot Username/Password.
* User tries to retrieve the user id.
* User tries to reset the passeword.
* User clicks on create user id and verifies whether the navigation is done correctly.
* User clicks on open an account option and verifies whether the navigation is done correctly.
* User enters random tracking number to track the shipment and verifies that error message is received.
* User clicks on shipping button and verifies whether the navigation is done correctly.
* User clicks on search button and check whether search results appear or not.
* User click on rate and transit button and verify delivery details are displayed.


# How to run
* Used a testng.xml file so that the tests can be run from command line.
* Command to run - mvn clean test

# Reports Generated
* Reports will be generated in the following folder: src/target folder
* You can the cucumber.html reports for cucumber generated reports.
* For test ng reports navigate to src/target/surefire-reports/FedExAutomationSuite
