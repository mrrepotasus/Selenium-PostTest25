package com.ujianmingguan.main.PT25;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.ujianmingguan.pageobject.main.CheckOutShop;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestPlaceOrder25 {

	public static WebDriver driver;
	private CheckOutShop checkoutshop = new CheckOutShop();
	
	public TestPlaceOrder25() {
		driver = TestPostTest25Hooks.driver;
	}
	
	@When("User input data")
	public void user_input_data() {
		delay(2);
		scroll(700);
		delay(2);
		checkoutshop.InputData();
		System.out.println("Memasukan data");
	}
	
	@And("User click place order")
	public void user_click_place_order() {
		checkoutshop.placeorder();
		System.out.println("Submit pesanan");
	}
	
	@Then("User Your order has been received")
	public void user_Your_order_has_been_received() {
		assertEquals(checkoutshop.HasilAkhir(), "Thank you. Your order has been received.");
		System.out.println("Pesanan berhasil");
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
