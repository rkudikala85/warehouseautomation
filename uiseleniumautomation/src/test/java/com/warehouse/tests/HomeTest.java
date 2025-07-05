//package com.warehouse.tests;
//
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import com.warehouse.base.BaseTest;
//import com.warehouse.pages.HomePage;
//import com.warehouse.pages.LoginPage;
//import com.warehouse.pages.RegisterPage;
//
//public class HomeTest extends BaseTest {
//
//	HomePage homePage;
//	RegisterPage registerPage;
//	LoginPage loginPage;
//
//	public HomeTest() {
//		homePage = new HomePage(driver);
//		registerPage = new RegisterPage(driver);
//		loginPage = new LoginPage(driver);
//	}
//
//	@Test
//	public void verifyHomePageElements() {
//		Assert.assertTrue(homePage.isElementDisplayed(homePage.registerLink), "register link not displayed");
//		Assert.assertTrue(homePage.isElementDisplayed(homePage.loginLink), "Login link not displayed");
//	}
//	@Test
//	public void verifyRegisterLink() {
//		homePage.clickRegisterLink();
//		Assert.assertEquals(registerPage.getTitle(), "Register");
//	}
//	
//	@Test
//	public void verifyLoginLink() {
//		homePage.clickLoginLink();
//		Assert.assertEquals(loginPage.getTitle(), "Login");
//	}
//}
