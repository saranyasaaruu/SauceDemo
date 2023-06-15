package com.saucedemo.scripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CheckOutCompletePage;
import com.saucedemo.pages.CheckOutPage1;
import com.saucedemo.pages.CheckOutPage2;
import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.utilities.WaitUtility;

public class CheckoutCompletePageTest extends TestHelper {

	@Test
	public void verifyUserAbletoCheckOutComplete() throws IOException {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("standard_user", "secret_sauce");
		HomePage homepage = new HomePage(webDriver);
		homepage.clickonDropDown();
		WaitUtility.sleeps(2000);
		homepage.sortProductsPriceLowHigh();
		homepage.clickOnAddtoCart();
		WaitUtility.sleeps(2000);
		CartPage cartpage = new CartPage(webDriver);
		cartpage.clickOncartButton();
		WaitUtility.sleeps(2000);
		cartpage.removeProductsLessThanPrice();
		cartpage.clickCheckout();
		WaitUtility.sleeps(2000);
		CheckOutPage1 checkoutpage = new CheckOutPage1(webDriver);
		checkoutpage.sendValuesforCheckout();
		WaitUtility.sleeps(2000);
		checkoutpage.clickonContinue();
		WaitUtility.sleeps(2000);
		CheckOutPage2 checkoutpage2 = new CheckOutPage2(webDriver);
		checkoutpage2.clickonFinish();
		WaitUtility.sleeps(2000);
		CheckOutCompletePage checkoutComplete = new CheckOutCompletePage(webDriver);
		checkoutComplete.clickonBacktoHomeButton();
		WaitUtility.sleeps(2000);
		homepage.isHomePageLoaded();
		WaitUtility.sleeps(2000);
		homepage.clickonsideMenu();
		WaitUtility.sleeps(2000);
		homepage.clickonlogOut();
		boolean val = loginPage.isLoginPageLoaded();
		Assert.assertTrue(val);
		System.out.println("Products Purchased and Logged Out Successfully !!!");

	}

}
