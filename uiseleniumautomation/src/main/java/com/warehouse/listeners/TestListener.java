//package com.warehouse.listeners;
//
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//import com.warehouse.base.WebDriverManager;
//import com.warehouse.utils.ScreenshotUtil;
//
//public class TestListener implements ITestListener {
//	
//	
//	public void onTestFailure(ITestResult result) {
//		ScreenshotUtil.takeScreenshot(WebDriverManager.getDriver(),result.getName());
//	}
//	
//	public void onTestPass() {
//	
//
//	}
//
//	public void onTestSkip() {
//		
//	}
//}
