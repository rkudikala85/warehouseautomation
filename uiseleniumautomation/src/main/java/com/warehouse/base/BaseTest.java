//package com.warehouse.base;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeSuite;
//
//import com.beust.jcommander.Parameter;
//import com.warehouse.config.ConfigReader;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//
//public class BaseTest {
//
//	public static WebDriver driver;
//	@Before
//	public void setUp() {
//		driver = WebDriverManager.initDriver
//				(ConfigReader.getProperty("browser"));
//		String url = ConfigReader.getProperty("qa_url");
//		System.out.println("Site Url : "+ url);
//		driver.get(ConfigReader.getProperty("qa_url"));
//	}
//	
//	@After
//	public void tearDown() {
//		if (driver !=null) {
//			driver.close();
//			driver.quit();
//		}
//	}
//}
