package com.saucedemo.scripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.EndtoEndPage;
import com.saucedemo.pages.CheckOutPage1;
import com.saucedemo.pages.CheckOutPage2;
import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.utilities.WaitUtility;

public class EndtoEndTestSoftAssert extends TestHelper {

	@Test(priority = 1)
	public void verifyUserAbletoCheckOutComplete() throws IOException {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.login("standard_user", "secret_sauce");
		HomePage homepage = new HomePage(webDriver);
		SoftAssert softAssert = new SoftAssert();
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
		EndtoEndPage checkoutComplete = new EndtoEndPage(webDriver);
		checkoutComplete.clickonBacktoHomeButton();
		homepage.isHomePageLoaded();
		homepage.clickonsideMenu();
		homepage.clickonlogOut();
		boolean val = loginPage.isLoginPageLoaded();
		softAssert.assertEquals(true, val, "https://www.saucedemo.com/");
		softAssert.assertAll();
		System.out.println("Products Purchased and Logged Out Successfully !!!");

	}

}
