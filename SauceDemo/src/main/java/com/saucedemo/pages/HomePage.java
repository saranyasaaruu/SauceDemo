package com.saucedemo.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.saucedemo.constants.Constants;
import com.saucedemo.utilities.GenericUtility;
import com.saucedemo.utilities.PageUtility;
import com.saucedemo.utilities.WaitUtility;

public class HomePage {
	WebDriver driver;

	@FindBy(xpath = "//div[text()='Swag Labs']")
	WebElement welcomeName;

	@FindBy(xpath = "//select[@class='product_sort_container']")
	WebElement selectBox;

	@FindBy(xpath = "//button[text()='Add to cart']")
	WebElement addtoCartButton;

	@FindBy(xpath = "//span[@class='shopping_cart_badge']")
	WebElement CartText;

	@FindBy(xpath = "//div[@class='bm-burger-button']")
	WebElement sideMenu;

	@FindBy(xpath = "//a[@id='logout_sidebar_link']")
	WebElement logOut;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isHomePageLoaded() {
		return getWelcomeText().equals(Constants.welcomeText);
	}

	public String getWelcomeText() {
		return welcomeName.getText();

	}

	public void clickonDropDown() {
		GenericUtility.clickOnElement(selectBox);
	}

	public boolean sortProductsPriceLowHigh() {
		String a = "Price (low to high)";
		PageUtility.selectBoxByVisibleText(selectBox, a);
		WaitUtility.waitforElementtoBeClickable(selectBox, driver);
		return true;
	}

	public void clickOnAddtoCart() {

		List<WebElement> list = driver.findElements(By.xpath("//button[text()='Add to cart']"));
		for (WebElement element : list) {
			GenericUtility.clickOnElement(element);
		}
	}

	public boolean isCartLoaded() {
		return CartText.getText().equals(Constants.maxCartCount);
	}

	public void clickonsideMenu() {
		GenericUtility.clickOnElement(sideMenu);
	}

	public void clickonlogOut() {
		GenericUtility.clickOnElement(logOut);
	}

}
