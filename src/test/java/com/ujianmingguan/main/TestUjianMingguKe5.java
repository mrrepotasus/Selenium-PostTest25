package com.ujianmingguan.main;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.ujianmingguan.pageobject.drivers.DriverSingleton;
import com.ujianmingguan.pageobject.main.CheckOutShop;
import com.ujianmingguan.pageobject.main.SearchShop;
import com.ujianmingguan.pageobject.utils.Constans;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestUjianMingguKe5 {

	public static WebDriver driver;
	private SearchShop searchshop;	
	private CheckOutShop checkoutshop;
	boolean istDone;
	
	@Before
	public void setup() {
		DriverSingleton.getInstance("Firefox");
		searchshop = new SearchShop();
		checkoutshop = new CheckOutShop();
	}
	
	@After
	public void closeBrowser() {
		delay(3);
		if(istDone) {
			driver.close();
		}
	}
	
	@Given("User go to web Shop")
	public void user_go_to_web_Shop() {
		driver = DriverSingleton.getDriver();
		driver.get(Constans.URL);
	}
	
	
	@When("User click Search first item")
	public void user_click_Search_first_item() {
		searchshop.SearchItem("pink drop");
		delay(2);
	}
	
	@And("User add first item to cart")
	public void user_add_first_item_to_cart() {
		scroll(500);
		searchshop.SelectColorSize(1, 1);
		delay(3);
	}
	
	@Then("User click Search second cart")
	public void User_click_Search_second_cart() {
		searchshop.SearchItem("denim");
		delay(2);
	}
	
	@And("User add Second item to cart")
	public void user_add_Second_item_to_cart() {
		scroll(500);
		searchshop.SelectColorSize(1, 1);
		delay(3);
	}
	
	@Then("User click view cart")
	public void user_click_view_cart() {
		searchshop.ViewCart();
	}
	
	@And("User click view Checkout")
	public void user_click_view_Checkout() {
		searchshop.checkout();
		delay(3);
	}
	
	@When("User input data")
	public void user_input_data() {
		scroll(500);
		delay(3);
		checkoutshop.InputData();
	}
	
	@And("User click place order")
	public void user_click_place_order() {
		checkoutshop.placeorder();
	}
	
	@Then("User Your order has been received")
	public void user_Your_order_has_been_received() {
		assertEquals(checkoutshop.HasilAkhir(), "Thank you. Your order has been received.");
		istDone=true;
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
