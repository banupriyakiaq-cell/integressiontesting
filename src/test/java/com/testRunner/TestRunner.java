package com.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
			features = {"src\\test\\resources\\com.Feature\\newinstitute.feature"},
			glue = {"com.Stepdefanition","com.hooksClass"},
			//tags="@verify",
			plugin = {"pretty","html:target/cucumber-report.html"})
	 
	public class TestRunner extends AbstractTestNGCucumberTests {
	 
	}

