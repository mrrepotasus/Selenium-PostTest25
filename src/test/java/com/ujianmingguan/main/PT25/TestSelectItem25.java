package com.ujianmingguan.main.PT25;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.ujianmingguan.pageobject.drivers.DriverSingleton;
import com.ujianmingguan.pageobject.main.CheckOutShop;
import com.ujianmingguan.pageobject.main.RegisterShop;
import com.ujianmingguan.pageobject.main.SearchShop;
import com.ujianmingguan.pageobject.utils.Constans;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestSelectItem25 {

	public static WebDriver driver;
	private SearchShop searchshop = new SearchShop();
	
	
	public TestSelectItem25() {
		driver = TestPostTest25Hooks.driver;
		
	}
	
	@When("User go to web Shop")
	public void user_go_to_web_Shop() {
		driver.get(Constans.URL);
		System.out.println("Masuk ke website");
	}
	
	
	@And("User click Search first item")
	public void user_click_Search_first_item() {
		searchshop.SearchItem("pink drop");
		System.out.println("Mencari item pertama");
		delay(2);
	}
	
	@And("User add first item to cart")
	public void user_add_first_item_to_cart() {
		scroll(500);
		searchshop.SelectColorSize(1, 1);
		System.out.println("Memasukan item pertama kekeranjang ");
		delay(3);
	}
	
	@Then("User click Search second cart")
	public void User_click_Search_second_cart() {
		searchshop.SearchItem("denim");
		System.out.println("Mencari item kedua");
		delay(2);
	}
	
	@And("User add Second item to cart")
	public void user_add_Second_item_to_cart() {
		scroll(500);
		searchshop.SelectColorSize(1, 1);
		System.out.println("Memasukan item kedua kekeranjang");
		delay(3);
	}
	
	@Then("User click view cart")
	public void user_click_view_cart() {
		searchshop.ViewCart();
		System.out.println("Lihat keranjang");
	}
	
	@And("User click view Checkout")
	public void user_click_view_Checkout() {
		searchshop.checkout();
		System.out.println("Pindah kehalaman check Out");
		delay(3);
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
