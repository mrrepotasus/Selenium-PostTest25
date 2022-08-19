package com.ujianmingguan.pageobject.driver.strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome implements DriverStrategy {

	public WebDriver setStrategy() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Ramma\\Desktop\\bootcamp\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.setExperimentalOption("useAutomationExtension", false);
		option.addArguments("--no-sandbox");
		
		return new ChromeDriver(option);
	}
	
}
