package com.fedex.automation.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
                 features = "src/test/resources/features",
                 glue = "com.fedex.automation.stepdefs",
                 plugin = {"pretty","html:target/cucumber-html-reports.html", "json: target/cucumber/cucumber.json"},
                 tags = "@run",
                 monochrome = true
)

public class runner extends AbstractTestNGCucumberTests {

}
