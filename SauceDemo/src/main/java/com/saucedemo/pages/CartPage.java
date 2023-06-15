package com.saucedemo.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.saucedemo.utilities.GenericUtility;
import com.saucedemo.utilities.StringUtility;

public class CartPage {
	WebDriver driver;

	@FindBy(xpath = "//div[@id='shopping_cart_container']")
	WebElement cartButton;

	@FindBy(xpath = "//div[@class='inventory_item_price']")
	WebElement Prices;

	@FindBy(xpath = "//button[@class='btn btn_secondary btn_small cart_button']")
	WebElement removeButton;

	@FindBy(xpath = "//button[@id='checkout']")
	WebElement checkoutButton;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOncartButton() {
		GenericUtility.clickOnElement(cartButton);
	}

	public void removeProductsLessThanPrice() {
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
		for (WebElement element : list) {
			String price = element.getText();
			String priceonly = StringUtility.deleteAChar(price);
			/*
			 * StringBuilder builder = new StringBuilder(price); String priceonly =
			 * builder.deleteCharAt(0).toString();
			 */
			float p = Float.parseFloat(priceonly);
			if (p < 15.00) {
				removeButton.click();
			}

		}
	}

	public void clickCheckout() {
		GenericUtility.clickOnElement(checkoutButton);
	}

}
