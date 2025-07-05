package com.warehouse.base;

import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.warehouse.config.ConfigReader;

import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    public static WebDriver createDriver(String browser) {
        String driverInstance = ConfigReader.getProperty("DRIVER_INSTANCE");
        String platform = ConfigReader.getProperty("PLATFORM");

        try {
            switch (driverInstance.toUpperCase()) {
                case "LOCAL":
                    return getLocalDriver(browser);

                case "SAUCELAB":
                    return getSauceLabsWebDriver(browser);

                case "SAUCELAB_MOBILE":
                    if (platform.equalsIgnoreCase("android_web")) {
                        return getSauceLabsMobileWebDriver("Android");
                    } else if (platform.equalsIgnoreCase("ios_web")) {
                        return getSauceLabsMobileWebDriver("iOS");
                    }
                    break;

                default:
                    throw new IllegalArgumentException("Unsupported DRIVER_INSTANCE: " + driverInstance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        throw new RuntimeException("Failed to create WebDriver");
    }

    private static WebDriver getLocalDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                return new ChromeDriver();
            case "firefox":
                return new FirefoxDriver();
            case "edge":
                return new EdgeDriver();
            default:
                throw new IllegalArgumentException("Unsupported local browser: " + browser);
        }
    }

    private static WebDriver getSauceLabsWebDriver(String browser) throws Exception {
        String username = ConfigReader.getProperty("sauce_username");
        String accessKey = ConfigReader.getProperty("sauce_access_key");
        String sauceUrl = "https://"+username+":"+accessKey+"@ondemand.eu-central-1.saucelabs.com:443/wd/hub";

        MutableCapabilities sauceOpts = new MutableCapabilities();
		sauceOpts.setCapability("name", "Sample TestNG Test");
		sauceOpts.setCapability("build", "Build-123");
		sauceOpts.setCapability("tags", Arrays.asList("Java", "TestNG"));
		sauceOpts.setCapability("seleniumVersion", "4.0.0");

		ChromeOptions chromeOpts = new ChromeOptions();
		chromeOpts.setExperimentalOption("w3c", true);

		MutableCapabilities caps = new MutableCapabilities();
		caps.setCapability("sauce:options", sauceOpts);
		caps.setCapability("browserName", "chrome");
		caps.setCapability("browserVersion", "latest");
		caps.setCapability("platformName", "Windows 11");
		caps.setCapability(ChromeOptions.CAPABILITY, chromeOpts);

		return new RemoteWebDriver(new URL(sauceUrl), chromeOpts);
    }

    private static WebDriver getSauceLabsMobileWebDriver(String platformType) throws Exception {
        String username = ConfigReader.getProperty("sauce_username");
        String accessKey = ConfigReader.getProperty("sauce_access_key");
        String region = ConfigReader.getProperty("sauce_region");
        String sauceUrl = "https://ondemand." + region + ".saucelabs.com/wd/hub";

        String deviceName = ConfigReader.getProperty("deviceName");
        String platformName = ConfigReader.getProperty("platformName");
        String platformVersion = ConfigReader.getProperty("platformVersion");

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> sauceOptions = new HashMap<>();

        sauceOptions.put("deviceName", deviceName);
        sauceOptions.put("platformName", platformName);
        sauceOptions.put("platformVersion", platformVersion);
        sauceOptions.put("browserName", platformName.equalsIgnoreCase("iOS") ? "Safari" : "Chrome");

        sauceOptions.put("name", "Warehouse Mobile Web Test");
        sauceOptions.put("build", "Build-Mobile-001");
        sauceOptions.put("appiumVersion", "2.0.0");

        options.setCapability("sauce:options", sauceOptions);
        return new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + "@" + sauceUrl), options);
    }

}
