package com.ujianmingguan.pageobject.drivers;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import com.ujianmingguan.pageobject.driver.strategy.DriverStrategy;
import com.ujianmingguan.pageobject.driver.strategy.DriverStrategyImplementer;

public class DriverSingleton {

	private static DriverSingleton instance = null;
	private static WebDriver driver;
	
	private DriverSingleton(String driver) {
		instantiate(driver);
	}
	
	public WebDriver instantiate(String strategy) {
		DriverStrategy driverStrategy =DriverStrategyImplementer.choosesStrategy(strategy);
		driver = driverStrategy.setStrategy();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
	}
	
	public static DriverSingleton getInstance(String driver) {
		if(instance == null) {
			instance = new DriverSingleton(driver);
		}
		
		return instance;
	}
	
	public static WebDriver getDriver() {
		
		return driver;
	}
}
