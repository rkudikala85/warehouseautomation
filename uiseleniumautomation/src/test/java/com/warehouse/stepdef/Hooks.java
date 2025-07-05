package com.warehouse.stepdef;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.warehouse.base.WebDriverManager;
import com.warehouse.config.ConfigReader;
import com.warehouse.utils.ScreenshotUtil;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        WebDriverManager.initDriver(ConfigReader.getProperty("browser"));
        WebDriver driver = WebDriverManager.getDriver(); // Get from manager
        driver.get(ConfigReader.getProperty("qa_url"));

        // Sauce Labs job name tagging
        if (ConfigReader.getProperty("DRIVER_INSTANCE").equalsIgnoreCase("SAUCELAB") ||
            ConfigReader.getProperty("DRIVER_INSTANCE").equalsIgnoreCase("SAUCELAB_MOBILE")) {
            ((JavascriptExecutor) driver).executeScript("sauce:job-name=" + scenario.getName());
        }
    }

    @After
    public void closeBrowser(Scenario scenario) {
        ScreenshotUtil.takeScreenshot(scenario);
    }
}
