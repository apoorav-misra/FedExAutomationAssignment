package com.fedex.automation.Managers;

import com.fedex.automation.Enums.DriverTypes;
import com.fedex.automation.Utils.ConfigFileProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class DriverManager {
   private static WebDriver driver;
   static ConfigFileProvider fileProvider = new ConfigFileProvider();
   private static final HashMap<String,String> configMap = (HashMap<String, String>) fileProvider.getPropertiesValues();

    public static void initializeDriver(){
        if(configMap.get("browser").equalsIgnoreCase(DriverTypes.Chrome.toString())) {
            ChromeOptions options = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
        }
        else if(configMap.get("browser").equalsIgnoreCase(DriverTypes.Firefox.toString())){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static void loadUrl(){
        driver.get(configMap.get("url"));
    }

    public static void quitDriver(){
        if(Objects.nonNull(driver))
            driver.quit();
    }
}
