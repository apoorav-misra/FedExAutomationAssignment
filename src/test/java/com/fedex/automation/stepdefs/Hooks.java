package com.fedex.automation.stepdefs;

import com.fedex.automation.Managers.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks {

    @Before
    public void beforeTest(){
        DriverManager.initializeDriver();
    }

    @After
    public void afterTest(){
        DriverManager.quitDriver();
    }
}
