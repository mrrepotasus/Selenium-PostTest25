package com.ujianmingguan.main.PT26;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.ujianmingguan.pageobject.main.CheckOutShop;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestPlaceOrder26 {

	public static WebDriver driver;
	private static ExtentTest extentTest;
	private CheckOutShop checkoutshop = new CheckOutShop();
	
	public TestPlaceOrder26() {
		driver = TestPostTest26Hooks.driver;
		extentTest = TestPostTest26Hooks.extentTest;
	}
	
	@When("User input data")
	public void user_input_data() {
		TestPostTest26Hooks.delay(2);
		TestPostTest26Hooks.scroll(700);
		TestPostTest26Hooks.delay(2);
		checkoutshop.InputData();
		System.out.println("Memasukan data");
		extentTest.log(LogStatus.PASS,"User input data");
	}
	
	@And("User click place order")
	public void user_click_place_order() {
		checkoutshop.placeorder();
		System.out.println("Submit pesanan");
		extentTest.log(LogStatus.PASS,"User click place order");
	}
	
	@Then("User Your order has been received")
	public void user_Your_order_has_been_received() {
		assertEquals(checkoutshop.HasilAkhir(), "Thank you. Your order has been received.");
		System.out.println("Pesanan berhasil");
		extentTest.log(LogStatus.PASS,"User Your order has been received");
	}
}
