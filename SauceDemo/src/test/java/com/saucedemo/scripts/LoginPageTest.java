package com.saucedemo.scripts;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.saucedemo.constants.Constants;
import com.saucedemo.listeners.*;
import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.utilities.ExcelUtilities;

@Listeners(TestNGListener.class)
public class LoginPageTest extends TestHelper {

	@Test(dataProvider = "validLogin")
	public void validLoginPageTest(String u, String p) throws IOException {
		LoginPage loginPage = new LoginPage(webDriver);
		HomePage homepage = loginPage.login(u, p);
		Assert.assertTrue(homepage.isHomePageLoaded());
		System.out.println("Logged in Successfully !!!");

	}

	@Test(dataProvider = "inValidLogin")
	public void inValidLoginPageTest(String u, String p) throws IOException {
		LoginPage loginPage = new LoginPage(webDriver);
		HomePage homepage = loginPage.login(u, p);
		boolean val = loginPage.isLoginPageLoaded();
		Assert.assertEquals(true, val);
		System.out.println("Login Failed !!!");

	}

	@Test
	public void verifyLoginWithoutEnteringCredentials() throws IOException, InterruptedException {
		LoginPage loginPage = new LoginPage(webDriver);
		HomePage homepage = loginPage.login("", "");
		boolean val = loginPage.isErrorMessgeLoaded();
		Assert.assertEquals(true, val);
		System.out.println("Login Failed and Enter all Fields !!!");

	}

	@DataProvider(name = "validLogin")
	public Object[][] getValidData() {
		Object[][] data = null;
		String path = Constants.excelPath;
		ExcelUtilities excelu = new ExcelUtilities(path);
		int totalrows;
		try {
			totalrows = excelu.getRowCount("ValidLoginSheet");
			int totalcols = excelu.getCellCount("ValidLoginSheet", 1);
			data = new String[totalrows][totalcols];
			for (int i = 1; i <= totalrows; i++) {
				for (int j = 0; j < totalcols; j++) {
					data[i - 1][j] = excelu.getCellData("ValidLoginSheet", i, j);
				}

			}

		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;

	}

	@DataProvider(name = "inValidLogin")
	public Object[][] getinValidData() {
		Object[][] data = null;
		String path = Constants.excelPath;
		ExcelUtilities excelu = new ExcelUtilities(path);
		int totalrows;
		try {
			totalrows = excelu.getRowCount("InValidLoginSheet");
			int totalcols = excelu.getCellCount("InValidLoginSheet", 1);
			data = new String[totalrows][totalcols];
			for (int i = 1; i <= totalrows; i++) {
				for (int j = 0; j < totalcols; j++) {
					data[i - 1][j] = excelu.getCellData("InValidLoginSheet", i, j);
				}

			}

		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;

	}

}
