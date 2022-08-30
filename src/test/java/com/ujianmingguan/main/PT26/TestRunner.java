package com.ujianmingguan.main.PT26;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = ""
				,features = {"src/test/resources/feature/01SelectItem.feature"
						,"src/test/resources/feature/02PlaceOrder.feature"}
				,glue = "com.ujianmingguan.main.PT26"
				,plugin = {"pretty","html:target/cucumber-reports.html"
						,"json:target/extent-report.html"})
public class TestRunner extends AbstractTestNGCucumberTests{

	
}