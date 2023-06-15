package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.constants.Constants;
import com.saucedemo.utilities.GenericUtility;
import com.saucedemo.utilities.WaitUtility;

public class CheckOutCompletePage {
	WebDriver driver;

	@FindBy(xpath = "//h2[@class='complete-header']")
	WebElement titleText;

	@FindBy(xpath = "//button[@id='back-to-products']")
	WebElement backtoHomeButton;

	public CheckOutCompletePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isCheckoutPageCompleteLoaded() {
		WaitUtility.impliciteWait(5000, driver);
		return titleText.getText().equals(Constants.checkoutCompleteHeader);
	}

	public void clickonBacktoHomeButton() {
		WaitUtility.impliciteWait(5000, driver);
		GenericUtility.clickOnElement(backtoHomeButton);

	}

}
