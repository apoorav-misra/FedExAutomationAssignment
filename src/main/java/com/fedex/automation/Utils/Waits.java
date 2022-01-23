package com.fedex.automation.Utils;

import com.fedex.automation.Enums.WaitTypes;
import com.fedex.automation.Managers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Waits {

    private Waits(){}

    public static void performImplicitWait(){
        DriverManager.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public static void sleep(long milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void performExplicitWait(WaitTypes types,By by){
        WebElement element = null;
        if(types == WaitTypes.VISIBLE){
            new WebDriverWait(DriverManager.getDriver(),30).
                          until(ExpectedConditions.visibilityOfElementLocated(by));
        }
        else if(types == WaitTypes.PRESENCE){
            element = new WebDriverWait(DriverManager.getDriver(),10).
                          until(ExpectedConditions.presenceOfElementLocated(by));
        }
        else if(types == WaitTypes.CLICKABLE){
            element = new WebDriverWait(DriverManager.getDriver(),10).
                          until(ExpectedConditions.elementToBeClickable(by));
        }
        else if(types == WaitTypes.NONE){
            element = DriverManager.getDriver().findElement(by);
        }
    }
}
