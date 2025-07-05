package com.warehouse.pages;

import java.awt.geom.GeneralPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.warehouse.base.GenericUtil;
import com.warehouse.base.NavigationUtil;

public class RegisterPage {

	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getTitle() {
		return driver.getTitle();
	}
	
	@FindBy(id = "firstName")
	public WebElement firstNametxt;
	@FindBy(id = "lastName")
	public WebElement lastNametxt;
	@FindBy(id="email")
	public WebElement emailtxt;
	@FindBy(id="password")
	public WebElement passwordtxt;
	@FindBy(id = "confirmPassword")
	public WebElement confirmPasstxt;
	@FindBy(id = "role")
	public WebElement roleDropDown;
	@FindBy(className = "btn")
	public WebElement registerButton;
	
	public void enterFirstName(String fname) {
		NavigationUtil.type(firstNametxt, fname);
	}
	
	public void enterLastName(String lname) {
		NavigationUtil.type(lastNametxt, lname);
	}
	
	public void enterEmail(String email) {
		NavigationUtil.type(emailtxt, email);
	}
	
	public void enterPassword(String pass) {
		NavigationUtil.type(passwordtxt, pass);
	}
	
	public void enterConfirmPassword(String confirmPass) {
		NavigationUtil.type(confirmPasstxt, confirmPass);
	}
	
	public void selectRole(String value)
	{	
		NavigationUtil.selectValue(roleDropDown, value);
	}
	
	public void clickRegister() {
		NavigationUtil.submit(registerButton);
	}
	
	

	
	
	
	
	
	
	
	
}
