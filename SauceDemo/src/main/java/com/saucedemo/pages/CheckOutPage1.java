package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.constants.Constants;
import com.saucedemo.utilities.GenericUtility;
import com.saucedemo.utilities.WaitUtility;

public class CheckOutPage1 {
	WebDriver driver;

	@FindBy(xpath = "//span[@class='title']")
	WebElement titleText;

	@FindBy(xpath = "//input[@id='first-name']")
	WebElement firstName;

	@FindBy(xpath = "//input[@id='last-name']")
	WebElement lastName;

	@FindBy(xpath = "//input[@id='postal-code']")
	WebElement postalCode;

	@FindBy(xpath = "//input[@id='continue']")
	WebElement continueButton;

	public CheckOutPage1(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isCheckoutPage1Loaded() {
		return titleText.getText().equals(Constants.checkoutPage1Title);
	}

	public void sendValuesforCheckout() {
		GenericUtility.sendValues(firstName, "Saranya");
		GenericUtility.sendValues(lastName, "A R");
		GenericUtility.sendValues(postalCode, "695608");
		WaitUtility.impliciteWait(5000, driver);
	}

	public void clickonContinue() {
		GenericUtility.clickOnElement(continueButton);
	}

}
