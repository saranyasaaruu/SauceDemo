package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.constants.Constants;
import com.saucedemo.utilities.GenericUtility;
import com.saucedemo.utilities.WaitUtility;

public class CheckOutPage2 {
	WebDriver driver;

	@FindBy(xpath = "//span[@class='title']")
	WebElement titleText;

	@FindBy(xpath = "//button[@id='finish']")
	WebElement finishButton;

	public CheckOutPage2(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isCheckoutPage2Loaded() {
		return titleText.getText().equals(Constants.checkoutPage2Title);
	}

	public void clickonFinish() {
		WaitUtility.impliciteWait(5000, driver);
		GenericUtility.clickOnElement(finishButton);
	}

}
