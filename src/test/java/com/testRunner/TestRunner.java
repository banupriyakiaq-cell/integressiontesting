package com.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
			features = {"src\\test\\resources\\com.Feature"},
			glue = {"com.Stepdefanition","com.hooksClass"},
			  //tags="@admin",
			plugin = {"pretty","html:target/cucumber-report.html"})
	 
	public class TestRunner extends AbstractTestNGCucumberTests {
	 
	}

