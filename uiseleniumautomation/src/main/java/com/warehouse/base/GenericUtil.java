package com.warehouse.base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.warehouse.utils.LogUtils;

public class GenericUtil {

    WebDriverWait wait;
    public static org.apache.logging.log4j.Logger log = LogUtils.getLogger(GenericUtil.class);

    public static boolean isElementDisplayed(WebElement element, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(WebDriverManager.getDriver(), Duration.ofSeconds(timeoutInSeconds));
            wait.until(ExpectedConditions.visibilityOf(element));
            log.info("Element is visible: " + element);
            return true;
        } catch (Exception e) {
            log.error("Element not visible: " + element + " within timeout: " + timeoutInSeconds);
            return false;
        }
    }

}
