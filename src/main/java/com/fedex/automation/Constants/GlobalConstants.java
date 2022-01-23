package com.fedex.automation.Constants;

public final class GlobalConstants {

    private GlobalConstants(){}

    public static final String loginPageTitle = "Enter your user ID and password to log in";
    public static final String invalidCredentialsMessage = "Login incorrect. Either the user ID or password combination is incorrect or the account has been locked. Please try again or reset your password.";
    public static final String loginErrorMessage = "We are having trouble establishing a connection. Please refresh the page.";
    public static final String emailSentMessage = "An email with your user ID(s) has been sent to";
    public static final String openAccountMessage = "Open a FedEx account";
    public static final String trackingErrorMessage = "No record of this tracking number can be found at this time, please check the number and try again later. For further assistance, please contact Customer Service.";
    private static final String resourcePathMain = System.getProperty("user.dir")+"/src/main/resources";
    private static final String configFilePath = resourcePathMain + "/configProperties.properties";
    private static final String resourcePathTest = System.getProperty("user.dir")+"/src/test/resources";
    private static final String extentReportFilePath = resourcePathTest + "/extent-config.xml";

    public static String getExtentReportFilePath() {
        return extentReportFilePath;
    }

    public static String getConfigFilePath() {
        return configFilePath;
    }
}
