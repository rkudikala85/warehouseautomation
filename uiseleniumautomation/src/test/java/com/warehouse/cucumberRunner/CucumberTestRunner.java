package com.warehouse.cucumberRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/features", 
		glue = "com.warehouse.stepdef", 
		plugin = { "pretty",
		"json:target/cucumber.json", // This must match the path in pom.xml
		"html:target/cucumber-html-report" }, 
		tags = "@functional")

public class CucumberTestRunner extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true) // 💥 Enable parallel execution
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
