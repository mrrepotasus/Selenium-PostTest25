package com.ujianmingguan.main;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ujianmingguan.pageobject.main.CheckOutShop;
import com.ujianmingguan.pageobject.drivers.DriverSingleton;
import com.ujianmingguan.pageobject.main.RegisterShop;
import com.ujianmingguan.pageobject.main.SearchShop;

public class TestUjianMingguKe4 {
	
	public static WebDriver driver;
	private RegisterShop registershop;
	private SearchShop searchshop;	
	private CheckOutShop checkoutshop;

	@BeforeClass
	public void setup() {
		DriverSingleton.getInstance("Firefox");
		driver = DriverSingleton.getDriver();
		String url = "https://shop.demoqa.com/";
		driver.get(url);
	}
	@BeforeMethod
	public void pageObject() {
		registershop = new RegisterShop();
		searchshop = new SearchShop();
		checkoutshop = new CheckOutShop();
	}
	
	@Test(priority = 1)
	public void TestRegistrasiDanLogin() {
		registershop.register("admin91","admin91@gmail.com","ADMINtest12344");
		delay(3);
		registershop.login("admin91@gmail.com","ADMINtest12344");
		delay(2);
		System.out.println("Test 1 Success");
	}
	
	@Test(priority = 2)
	public void TestPembelianDanCompare() {
		searchshop.SearchItem("denim");
		delay(3);
		scroll(500);
		searchshop.SelectColorSize(1, 1);
		delay(3);
		searchshop.compare();
		delay(3);
		scroll(-500);
		delay(1);
		searchshop.SearchItem("pink drop");
		delay(3);
		scroll(500);
		searchshop.SelectColorSize(1, 1);
		delay(3);
		searchshop.compare();
		delay(5);
		searchshop.ViewCart();
		System.out.println("Test 2 Success");
	}
	
	@Test(priority = 3)
	public void TestIdentitasUserDanCheckOut() {
		scroll(500);
		delay(3);
		checkoutshop.InputData();
		delay(2);
		checkoutshop.HasilAkhir();
		System.out.println("Test 3 Success");
		assertEquals(checkoutshop.HasilAkhir(), "Thank you. Your order has been received.");
		System.out.println("Berhasil");
	}
	
	@AfterClass
	public void closeBrowser() {
		delay(5);
		driver.quit();
		
	}
	
	static void delay(int detik) {
		try {
			Thread.sleep(1000 * detik);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
	
	static void scroll(int vertikal) {
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+vertikal+")");
	}
}
