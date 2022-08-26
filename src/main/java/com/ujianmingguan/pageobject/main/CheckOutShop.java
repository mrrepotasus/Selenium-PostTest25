package com.ujianmingguan.pageobject.main;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ujianmingguan.pageobject.drivers.DriverSingleton;

import net.bytebuddy.asm.Advice.Enter;

public class CheckOutShop {
	
	private WebDriver driver;
	
	public CheckOutShop() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@id='billing_first_name']")
	private WebElement FirstNameTxt;
	@FindBy(xpath = "//input[@id='billing_last_name']")
	private WebElement LastNameTxt;
	@FindBy(xpath = "//input[@id='billing_company']")
	private WebElement CompanyTxt;
	@FindBy(xpath = "//input[@class=\"select2-search__field\"]")
	private WebElement CountrySelect;
	@FindBy(xpath = "//input[@id='billing_address_1']")
	private WebElement StreetTxt;
	@FindBy(xpath = "//input[@id='billing_city']")
	private WebElement TownTxt;
	@FindBy(xpath = "//input[@class=\"select2-search__field\"]")
	private WebElement StateSelect;
	@FindBy(xpath = "//input[@id='billing_postcode']")
	private WebElement PinTxt;
	@FindBy(xpath = "//input[@id='billing_phone']")
	private WebElement PhoneTxt;
	@FindBy(xpath = "//input[@id='terms']")
	private WebElement CheckBox;
	@FindBy(xpath = "//button[@id='place_order']")
	private WebElement btnPlaceOrder;
	@FindBy(xpath = "//p[@class='woocommerce-thankyou-order-received']")
	private WebElement GetSuccess;
	@FindBy(xpath = "//span[@id='select2-billing_country-container']")
	private WebElement btnCountry;
	@FindBy(xpath = "//span[@id='select2-billing_state-container']")
	private WebElement btnState;
	@FindBy(xpath = "//input[@id='billing_email']")
	private WebElement inputemail;

	public void InputData() {
		FirstNameTxt.sendKeys("Ramma");
		LastNameTxt.sendKeys("putra");
		CompanyTxt.sendKeys("juara coding");
		inputemail.sendKeys("rammatest@gmail.com");
		btnCountry.click();
		CountrySelect.sendKeys("Indonesia",Keys.ENTER);
		StreetTxt.sendKeys("jln.kalimantan 1");
		btnState.click();
		StateSelect.sendKeys("Bali",Keys.ENTER);
		TownTxt.sendKeys("jaktim");
		PinTxt.sendKeys("80111");
		PhoneTxt.sendKeys("081081081081");
		
		delay(2);
		CheckBox.click();
		delay(2);
		
	}
	public void placeorder() {
		btnPlaceOrder.click();
	}
	
	public String HasilAkhir() {
		return GetSuccess.getText();
	}
	
	static void delay(int detik) {
		try {
			Thread.sleep(1000*detik);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
}
}
