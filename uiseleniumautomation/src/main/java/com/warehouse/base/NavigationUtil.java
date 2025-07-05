package com.warehouse.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.warehouse.utils.LogUtils;

public class NavigationUtil {

    public static org.apache.logging.log4j.Logger log = LogUtils.getLogger(NavigationUtil.class);

    public static void click(WebElement element) {
        if (GenericUtil.isElementDisplayed(element, 30)) {
            log.info("Clicking on: " + element);
            element.click();
        }
    }
    public static void submit(WebElement element) {
        if (GenericUtil.isElementDisplayed(element, 30)) {
            log.info("Clicking on: " + element);
            element.click();
        }
    }

    public static void type(WebElement element, String value) {
        if (GenericUtil.isElementDisplayed(element, 30)) {
            element.clear();
            log.info("Entering value: '" + value + "' into element: " + element);
            element.sendKeys(value);
        }
    }

    public static void selectValue(WebElement element, String value) {
        if (GenericUtil.isElementDisplayed(element, 30)) {
            log.info("Selecting value: " + value + " from dropdown: " + element);
            Select select = new Select(element);
            select.selectByVisibleText(value);
        }
    }

    // Frame, Windows, Alerts to be implemented as needed
}
