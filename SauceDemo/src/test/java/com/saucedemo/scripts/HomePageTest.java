package com.saucedemo.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.LoginPage;

public class HomePageTest extends TestHelper {

	@Test
	public void verifySortProductsPriceLowHigh() {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("standard_user", "secret_sauce");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickonDropDown();
		boolean val = homepage.sortProductsPriceLowHigh();
		Assert.assertEquals(true, val);
		System.out.println("Products Sorted from Price Low to High !!!");

	}

	@Test
	public void verifyProductsAddedToCart() {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("standard_user", "secret_sauce");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickonDropDown();
		homepage.sortProductsPriceLowHigh();
		homepage.clickOnAddtoCart();
		boolean val = homepage.isCartLoaded();
		Assert.assertTrue(val);
		System.out.println("Products added to cart !!!");

	}

}
