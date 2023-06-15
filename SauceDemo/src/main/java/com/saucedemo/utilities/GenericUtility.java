package com.saucedemo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.openqa.selenium.WebElement;

import com.saucedemo.constants.Constants;

public class GenericUtility {

	public String generateTimeStamp() {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		return timeStamp;
	}

	public static String getConfigFileURL() throws IOException {
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream(Constants.configFilePath);
		prop.load(ip);
		String url = prop.getProperty("url");
		return url;
	}

	public static void clickOnElement(WebElement element) {
		element.click();
	}

	public static void sendValues(WebElement element, String key) {
		element.sendKeys(key);
	}
}
