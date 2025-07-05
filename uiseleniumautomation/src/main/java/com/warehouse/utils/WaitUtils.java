package com.warehouse.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	
	public static WebDriverWait getWait(WebDriver driver, int seconds) {
		return new WebDriverWait(driver, Duration.ofSeconds(seconds));
	}

}
