package com.warehouse.stepdef;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.warehouse.base.WebDriverManager;
import com.warehouse.pages.DashBoardPage;
import com.warehouse.pages.HomePage;
import com.warehouse.pages.RegisterPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterStepDefinition {

	HomePage homePage;
	RegisterPage registerPage;
	DashBoardPage dashboardPage;

	public RegisterStepDefinition() {
		homePage = new HomePage(WebDriverManager.getDriver());
		registerPage = new RegisterPage(WebDriverManager.getDriver());
		dashboardPage = new DashBoardPage(WebDriverManager.getDriver());
	}

	@When("user enter the FirstName {string}")
	public void user_enter_the_first_name(String fname) {
		registerPage.enterFirstName(fname);
	}

	@When("user enter the last name {string}")
	public void user_enter_the_last_name(String lname) {
		registerPage.enterLastName(lname);
	}

	@When("user enter the email address {string}")
	public void user_enter_the_email_address(String string) {
		registerPage.enterEmail(string);
	}

	@When("user enter the password {string}")
	public void user_enter_the_password(String password) {
		registerPage.enterPassword(password);
	}

	@When("user enter the confirm password {string}")
	public void user_enter_the_confirm_password(String confirmPass) {
		registerPage.enterConfirmPassword(confirmPass);
	}

	@When("user select the role as employee {string}")
	public void user_select_the_role_as(String role) {
		registerPage.selectRole(role);
	}

	@When("user click on Register button")
	public void user_click_on_register_button() {
		registerPage.clickRegister();
	}

	@Then("verify the Logoutlink")
	public void verify_the_logoutlink() {
		Assert.assertTrue(dashboardPage.isLogOutLinkDisplayed());
	}

	@When("user click on logout link")
	public void user_click_on_logout_link() {
		dashboardPage.clickLogoutLink();
	}
}
