package com.ujianmingguan.main.PT26;


import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.ujianmingguan.pageobject.main.SearchShop;
import com.ujianmingguan.pageobject.utils.Constans;

import io.cucumber.java.en.And;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestSelectItem26 {

	public static WebDriver driver;
	private static ExtentTest extentTest;
	private SearchShop searchshop = new SearchShop();
	
	
	public TestSelectItem26() {
		driver = TestPostTest26Hooks.driver;
		extentTest = TestPostTest26Hooks.extentTest;
	}
	
	@When("User go to web Shop")
	public void user_go_to_web_Shop() {
		driver.get(Constans.URL);
		extentTest = TestPostTest26Hooks.extentTest;
		System.out.println("Masuk ke website");
		extentTest.log(LogStatus.PASS,"User go to web Shop");
	}
	
	
	@And("User click Search first item")
	public void user_click_Search_first_item() {
		searchshop.SearchItem("pink drop");
		System.out.println("Mencari item pertama");
		extentTest.log(LogStatus.PASS,"User click Search first item");
		TestPostTest26Hooks.delay(2);
	}
	
	@And("User add first item to cart")
	public void user_add_first_item_to_cart() {
		TestPostTest26Hooks.scroll(500);
		searchshop.SelectColorSize(1, 1);
		System.out.println("Memasukan item pertama kekeranjang ");
		extentTest.log(LogStatus.PASS,"User add first item to cart");
		TestPostTest26Hooks.delay(3);
	}
	
	@Then("User click Search second cart")
	public void User_click_Search_second_cart() {
		searchshop.SearchItem("denim");
		System.out.println("Mencari item kedua");
		extentTest.log(LogStatus.PASS,"User click Search second cart");
		TestPostTest26Hooks.delay(2);
	}
	
	@And("User add Second item to cart")
	public void user_add_Second_item_to_cart() {
		TestPostTest26Hooks.scroll(500);
		searchshop.SelectColorSize(1, 1);
		System.out.println("Memasukan item kedua kekeranjang");
		extentTest.log(LogStatus.PASS,"User add Second item to cart");
		TestPostTest26Hooks.delay(3);
	}
	
	@Then("User click view cart")
	public void user_click_view_cart() {
		searchshop.ViewCart();
		System.out.println("Lihat keranjang");
		extentTest.log(LogStatus.PASS,"User click view cart");
	}
	
	@And("User click view Checkout")
	public void user_click_view_Checkout() {
		searchshop.checkout();
		System.out.println("Pindah kehalaman check Out");
		extentTest.log(LogStatus.PASS,"User click view Checkout");
		TestPostTest26Hooks.delay(3);
	}
	
}
