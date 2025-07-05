package com.warehouse.stepdef;

import org.apache.log4j.Logger;
import org.testng.Assert;
import com.warehouse.base.WebDriverManager;
import com.warehouse.config.ConfigReader;
import com.warehouse.pages.HomePage;
import com.warehouse.pages.LoginPage;
import com.warehouse.pages.RegisterPage;
import com.warehouse.utils.LogUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeStepDefinition {

	
	HomePage homePage;
	RegisterPage registerPage;
	LoginPage loginPage;

	public HomeStepDefinition() {
		homePage = new HomePage(WebDriverManager.getDriver()); // Pass initialized driver
		registerPage = new RegisterPage(WebDriverManager.getDriver());
		loginPage = new LoginPage(WebDriverManager.getDriver());
	}
	@Given("user navigate to site url")
	public void user_navigate_to_site_url() {
		WebDriverManager.getDriver().get(ConfigReader.getProperty("qa_url"));
	}

	@Then("verify register link displyed")
	public void verify_register_link_displyed() throws InterruptedException {
		Assert.assertTrue(homePage.isRegisterLinkDisplayed(), "Register link is not displayed");
	}

	@Then("verify login link displayed")
	public void verify_login_link_displayed() {
		Assert.assertTrue(homePage.isLoginLinkDisplayed(), "Login link is not displayed");
	}

	@When("user click on register link")
	public void user_click_on_register_link() {
		homePage.clickRegisterLink();
	}

	@Then("verify the register page title {string}")
	public void verify_the_register_page_title(String string) {
		Assert.assertEquals(registerPage.getTitle(), string);
	}

	@When("user click on Login link")
	public void user_click_on_login_link() {
		homePage.clickLoginLink();
	}

	@Then("verify the login page title {string}")
	public void verify_the_login_page_title(String string) throws InterruptedException {
		Assert.assertEquals(loginPage.getTitle(), string);
	}

}
