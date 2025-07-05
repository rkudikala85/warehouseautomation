package com.warehouse.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.warehouse.base.GenericUtil;
import com.warehouse.base.NavigationUtil;
import com.warehouse.base.WebDriverManager;

public class DashBoardPage {

	WebDriver driver;

	public DashBoardPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "logout-btn")
	public WebElement logoutLink;
	
	
	public void clickLogoutLink() {
		NavigationUtil.click(logoutLink);
	}
	
	public boolean isLogOutLinkDisplayed() {
		if (GenericUtil.isElementDisplayed(logoutLink, 0)) {
			return true;
		} else {
			return false;
		}
	}
}
