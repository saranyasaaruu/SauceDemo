package com.saucedemo.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CheckOutPage1;
import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.LoginPage;


public class CartPageTest extends TestHelper {

	@Test
	public void verifyProductsRemoveFromCart() {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("standard_user", "secret_sauce");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickonDropDown();
		homepage.sortProductsPriceLowHigh();
		homepage.clickOnAddtoCart();
		CartPage cartpage = new CartPage(webDriver);
		cartpage.clickOncartButton();
		cartpage.removeProductsLessThanPrice();
		Assert.assertTrue(true);
		System.out.println("Removed Products Price Less Than 15 !!!");

	}

	@Test
	public void verifyUserAbletoCheckOut() {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("standard_user", "secret_sauce");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickonDropDown();
		homepage.sortProductsPriceLowHigh();
		homepage.clickOnAddtoCart();
		CartPage cartpage = new CartPage(webDriver);
		cartpage.clickOncartButton();
		cartpage.removeProductsLessThanPrice();
		cartpage.clickCheckout();
		CheckOutPage1 checkout = new CheckOutPage1(webDriver);
		boolean val = checkout.isCheckoutPage1Loaded();
		Assert.assertTrue(val);
		System.out.println("Check out Button Clicked and navigated to Checkout Page !!!");

	}

}
