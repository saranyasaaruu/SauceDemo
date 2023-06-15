package com.saucedemo.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CheckOutPage1;
import com.saucedemo.pages.CheckOutPage2;
import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.LoginPage;

public class CheckoutPageTest1 extends TestHelper {

	@Test
	public void verifyUserAbletoCheckOutStep1Process() {
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
		CheckOutPage1 checkoutpage1 = new CheckOutPage1(webDriver);
		checkoutpage1.sendValuesforCheckout();
		checkoutpage1.clickonContinue();
		CheckOutPage2 checkoutpage2 = new CheckOutPage2(webDriver);
		boolean val = checkoutpage2.isCheckoutPage2Loaded();
		Assert.assertEquals(true, val);
		System.out.println("Check out page 2 loaded  !!!");

	}

}
