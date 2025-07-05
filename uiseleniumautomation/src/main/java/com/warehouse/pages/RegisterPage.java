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

	/**
	 * This is Constructor with driver parameter
	 * 
	 * @param driver
	 */
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * To find the title of the Current Web page
	 * 
	 * @return
	 */
	public String getTitle() {
		return driver.getTitle();
	}

	@FindBy(id = "firstName")
	public WebElement firstNametxt;
	@FindBy(id = "lastName")
	public WebElement lastNametxt;
	@FindBy(id = "email")
	public WebElement emailtxt;
	@FindBy(id = "password")
	public WebElement passwordtxt;
	@FindBy(id = "confirmPassword")
	public WebElement confirmPasstxt;
	@FindBy(id = "role")
	public WebElement roleDropDown;
	@FindBy(className = "btn")
	public WebElement registerButton;
	@FindBy(id = "firstNameError")
	public WebElement firstName_error_msg;
	@FindBy(id = "lastNameError")
	public WebElement lastName_error_msg;
	@FindBy(id = "emailError")
	public WebElement email_error_msg;
	@FindBy(id = "passwordError")
	public WebElement password_error_msg;
	@FindBy(id = "roleError")
	public WebElement role_error_msg;

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

	/**
	 * This is enter the confirmation password in the confirm password field
	 * 
	 * @param confirmPass
	 */
	public void enterConfirmPassword(String confirmPass) {
		NavigationUtil.type(confirmPasstxt, confirmPass);
	}

	/**
	 * This is to set the value in the role dropdown
	 * 
	 * @param role
	 */
	public void selectRole(String role) {
		NavigationUtil.selectValue(roleDropDown, role);
	}

	/**
	 * Click on Register button on register page
	 */
	public void clickRegister() {
		NavigationUtil.submit(registerButton);
	}

	/**
	 * This method is going to clear all the fields in the register screen
	 */
	public void clearRegisterFields() {
		firstNametxt.clear();
		lastNametxt.clear();
		emailtxt.clear();
		passwordtxt.clear();
		confirmPasstxt.clear();
	}

	/**
	 * To find the text of FirstName error Message
	 * 
	 * @return
	 */
	public String getFirstNameErrorMessage() {
		return NavigationUtil.getElementText(firstName_error_msg);
	}

	/**
	 * To find the text of LastName error Message
	 * 
	 * @return
	 */
	public String getLastNameErrorMessage() {
		return NavigationUtil.getElementText(lastName_error_msg);
	}

	/**
	 * To find the text of Email Address error Message
	 * 
	 * @return
	 */
	public String getEmailErrorMessage() {
		return NavigationUtil.getElementText(email_error_msg);
	}

	/**
	 * To find the text of Password error Message
	 * 
	 * @return
	 */
	public String getPasswordErrorMessage() {
		return NavigationUtil.getElementText(password_error_msg);
	}

	/**
	 * To find the text of Role Drop-down error Message
	 * 
	 * @return
	 */
	public String getRoleErrorMessage() {
		return NavigationUtil.getElementText(role_error_msg);
	}

}
