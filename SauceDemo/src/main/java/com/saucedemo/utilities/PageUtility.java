package com.saucedemo.utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	WebDriver driver;
	public static XSSFWorkbook w;
	public static XSSFSheet sh;

	public static String getCurrentUrlOfPage(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public void getTitle() {
		driver.getTitle();
	}

	public static void selectBoxByVisibleText(WebElement selectBox, String data) {
		Select sel = new Select(selectBox);
		sel.selectByVisibleText(data);
	}

}
