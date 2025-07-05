package com.warehouse.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.warehouse.config.ConfigReader;
import com.warehouse.utils.LogUtils;

public class WebDriverManager {

	// parallel execution support.
    private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    private static WebDriver driver;

    public static WebDriver initDriver(String browser) {
        boolean isParallel = Boolean.parseBoolean(ConfigReader.getProperty("parallelExecution"));

        if (isParallel) {
            WebDriver webDriver = DriverFactory.createDriver(browser);
            webDriver.manage().window().maximize();
            threadLocalDriver.set(webDriver);
            return getDriver();
        } else {
            driver = DriverFactory.createDriver(browser);
            driver.manage().window().maximize();
            return driver;
        }
    }

    public static WebDriver getDriver() {
        boolean isParallel = Boolean.parseBoolean(ConfigReader.getProperty("parallelExecution"));
        return isParallel ? threadLocalDriver.get() : driver;
    }

    public static void quitDriver() {
        boolean isParallel = Boolean.parseBoolean(ConfigReader.getProperty("parallelExecution"));
        if (isParallel && threadLocalDriver.get() != null) {
            threadLocalDriver.get().quit();
            threadLocalDriver.remove();
        } else if (driver != null) {
            driver.quit();
        }
    }
}
