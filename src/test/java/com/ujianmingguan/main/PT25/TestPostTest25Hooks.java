package com.ujianmingguan.main.PT25;

import org.openqa.selenium.WebDriver;

import com.ujianmingguan.pageobject.drivers.DriverSingleton;
import com.ujianmingguan.pageobject.utils.Constans;

import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;

public class TestPostTest25Hooks {

public static WebDriver driver;
	
	@Before
	public void methodBefore() {
		DriverSingleton.getInstance(Constans.CHROME);
		driver = DriverSingleton.getDriver();
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
	
}
