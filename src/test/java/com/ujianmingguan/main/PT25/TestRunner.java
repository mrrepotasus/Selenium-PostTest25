package com.ujianmingguan.main.PT25;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = ""
				,features = {"src/test/resources/feature/01SelectItem.feature"
						,"src/test/resources/feature/02PlaceOrder.feature"}
				,glue = "com.ujianmingguan.main.PT25"
				,plugin = {"pretty","html:targer/cucumber-reports.html"})
public class TestRunner extends AbstractTestNGCucumberTests{

	
}