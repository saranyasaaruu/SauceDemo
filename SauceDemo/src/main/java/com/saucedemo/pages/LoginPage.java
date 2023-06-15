package com.saucedemo.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.constants.Constants;
import com.saucedemo.utilities.GenericUtility;
import com.saucedemo.utilities.PageUtility;
import com.saucedemo.utilities.WaitUtility;

public class LoginPage {
	public String invalidLogText;
	WebDriver driver;
	@FindBy(xpath = "//input[@id='user-name']")
	WebElement username;

	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	@FindBy(xpath = "//input[@id='login-button']")
	WebElement button;

	@FindBy(xpath = "//strong")
	WebElement invalidLoginData;

	@FindBy(xpath = "//h3[@data-test='error']")
	WebElement errorMessage;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public HomePage login(String user, String passs) {
		GenericUtility.sendValues(username, user);
		GenericUtility.sendValues(password, passs);
		WaitUtility.waitforElementtoBeClickable(button, driver);
		GenericUtility.clickOnElement(button);
		return new HomePage(driver);
	}

	public boolean isLoginPageLoaded() throws IOException {
		String url = PageUtility.getCurrentUrlOfPage(driver);
		return url.equals(GenericUtility.getConfigFileURL());
	}

	public boolean isErrorMessgeLoaded() throws IOException {
		return errorMessage.getText().equals(Constants.errorMessage1);
	}

}
