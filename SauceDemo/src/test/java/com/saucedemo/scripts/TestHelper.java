package com.saucedemo.scripts;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.saucedemo.constants.Constants;
import com.saucedemo.utilities.GenericUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestHelper {
	WebDriver webDriver;
	GenericUtility gu = new GenericUtility();

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")

	public void openBrowser(String browsers) throws IOException {
		if (browsers.equalsIgnoreCase("Chrome")) {
			System.out.println("Browser is: Chrome");
			WebDriverManager.chromedriver().setup();
			webDriver = new ChromeDriver();
			webDriver.get(gu.getConfigFileURL());
			System.out.println(gu.getConfigFileURL());
			webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			webDriver.manage().window().maximize();
		}
		if (browsers.equalsIgnoreCase("Firefox")) {
			System.out.println("Browser is: Firefox");
			WebDriverManager.firefoxdriver().setup();
			webDriver = new FirefoxDriver();
			webDriver.get(gu.getConfigFileURL());
			webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			webDriver.manage().window().maximize();

		}
		if (browsers.equalsIgnoreCase("Edge")) {
			System.out.println("Browser is: Edge");
			WebDriverManager.edgedriver().setup();
			webDriver = new EdgeDriver();
			webDriver.get(gu.getConfigFileURL());
			webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			webDriver.manage().window().maximize();

		}

	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult result) throws IOException {

		if (ITestResult.FAILURE == result.getStatus()) {
			try {
				TakesScreenshot screenshot = (TakesScreenshot) webDriver;
				File src = screenshot.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, new File(Constants.screenShotPath + result.getName() + ".png"));
				System.out.println("Successfully captured a screenshot");

			} catch (Exception e) {
				System.out.println("Exception while taking screenshot " + e.getMessage());
			}
		}
		webDriver.close();
	}

}
