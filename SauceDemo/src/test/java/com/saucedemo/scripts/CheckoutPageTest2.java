package com.saucedemo.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CheckOutCompletePage;
import com.saucedemo.pages.CheckOutPage1;
import com.saucedemo.pages.CheckOutPage2;
import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.LoginPage;

public class CheckoutPageTest2 extends TestHelper {

	@Test
	public void verifyUserAbletoCheckOutStep2Process() {
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
		CheckOutPage1 checkoutpage = new CheckOutPage1(webDriver);
		checkoutpage.sendValuesforCheckout();
		checkoutpage.clickonContinue();
		CheckOutPage2 checkoutpage2 = new CheckOutPage2(webDriver);
		checkoutpage2.clickonFinish();
		CheckOutCompletePage checkoutComplete = new CheckOutCompletePage(webDriver);
		boolean val = checkoutComplete.isCheckoutPageCompleteLoaded();
		Assert.assertTrue(val);
		System.out.println("Check Out Completed !!!");

	}

}
