package com.warehouse.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.warehouse.base.WebDriverManager;

public class SauceUtil {

    public static void takeScreenshot(io.cucumber.java.Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) WebDriverManager.getDriver();
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());

            ((JavascriptExecutor) WebDriverManager.getDriver())
                .executeScript("sauce:job-result=" + (scenario.isFailed() ? "failed" : "passed"));
        }
        WebDriverManager.getDriver().quit(); // Use quit instead of close
    }
}
