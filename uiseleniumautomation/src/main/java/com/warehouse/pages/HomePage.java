package com.warehouse.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.warehouse.base.GenericUtil;
import com.warehouse.base.NavigationUtil;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public String getCurrentPageUrl() {
		return driver.getCurrentUrl();
	}
	
	// Page Objects
	
	@FindBy(linkText = "Register")
	public WebElement registerLink;
	@FindBy(linkText = "Login")
	public WebElement loginLink;
	
	
	// Page Methods
	public void clickLoginLink() {
		NavigationUtil.click(loginLink);
	}
	
	public void clickRegisterLink() {
		NavigationUtil.click(registerLink);
	}
	
	public boolean isRegisterLinkDisplayed() {
		return GenericUtil.isElementDisplayed(registerLink, 30);
	}
	
	public boolean isLoginLinkDisplayed() {
		return GenericUtil.isElementDisplayed(loginLink, 30);
	}
}
