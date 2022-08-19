package com.ujianmingguan.pageobject.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ujianmingguan.pageobject.drivers.DriverSingleton;

public class LoginShop {

	private WebDriver driver;
	
	public LoginShop() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	



	}
	


