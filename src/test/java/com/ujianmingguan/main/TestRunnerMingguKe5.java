package com.ujianmingguan.main;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(tags = ""
				,features = "src/test/resources/feature/Login.feature"
				,glue = "")

public class TestRunnerMingguKe5 extends AbstractTestNGCucumberTests {
	
	
}
