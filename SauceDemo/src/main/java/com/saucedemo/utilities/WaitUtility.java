package com.saucedemo.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	private static WebDriver jsWaitDriver;
	private static WebDriverWait jsWait;
	private static JavascriptExecutor jsExec;
	WebDriver driver;

	public static void sleeps(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void impliciteWait(long timeinmilliseconds, WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(timeinmilliseconds, TimeUnit.MILLISECONDS);
	}

	public void waitForanElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated((By) element));
	}

	public static void waitforElementtoBeClickable(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public boolean waitforElementtoLoad(WebElement element) {
		System.out.println(element.getText());
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
		return true;

	}

	public static void fluentWait(long totaltimeinseconds, long pollingtimeinseconds, WebElement element,
			WebDriver driver) {
		System.out.println("inside fluent wait ....................................");
		FluentWait wait = new FluentWait(driver);
		wait.withTimeout(totaltimeinseconds, TimeUnit.MILLISECONDS);
		wait.pollingEvery(pollingtimeinseconds, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
