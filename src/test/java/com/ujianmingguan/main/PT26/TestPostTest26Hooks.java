package com.ujianmingguan.main.PT26;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.ujianmingguan.pageobject.drivers.DriverSingleton;
import com.ujianmingguan.pageobject.utils.Constans;
import com.ujianmingguan.pageobject.utils.TestScenario;
import com.ujianmingguan.pageobject.utils.Utils;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class TestPostTest26Hooks {

	public static WebDriver driver;
	public static ExtentTest extentTest;
	public static ExtentReports reports = new ExtentReports("target/extent-report.html");

	@Before
	public void methodBefore() {
		DriverSingleton.getInstance(Constans.CHROME);
		driver = DriverSingleton.getDriver();
		TestScenario[] tests = TestScenario.values();
		extentTest = reports.startTest(tests[Utils.testCount].getTestName());
		Utils.testCount++;
	}
	
	@AfterStep
	public void getResultStatus(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			String screenshotpath = Utils.getScreenshot(driver, scenario.getName().replace(" ","_"));
			extentTest.log(LogStatus.FAIL, scenario.getName()+"\n"
			+extentTest.addScreenCapture(screenshotpath));
		}
	}
	
	@After
	public void closeObejct() {
		reports.endTest(extentTest);
		reports.flush();
	}
	
	@AfterAll
	public static void methodAfter() {
		delay(3);
		DriverSingleton.CloseObjectInstance();;
	}
	
	static void delay(int detik) {
		try {
			Thread.sleep(1000*detik);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	static void scroll(int vertikal) {
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+vertikal+")");
	}
}
