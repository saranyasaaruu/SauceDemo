package com.saucedemo.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestNGListener implements ITestListener {
	public ExtentSparkReporter spark;
	public ExtentTest logger;
	public ExtentReports extent;

	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

	@Override
	public void onStart(ITestContext iTestContext) {
		spark = new ExtentSparkReporter("Sparks.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environemnt", "QA");
	}

	@Override
	public void onFinish(ITestContext iTestContext) {
		extent.flush();
	}

	@Override
	public void onTestStart(ITestResult iTestResult) {
		logger = extent.createTest(iTestResult.getName());
		Reporter.log(iTestResult.getName() + " test case started", 2, true);
		System.out.println(iTestResult.getName() + " test case started");
	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		System.out.println("The name of the testcase passed is :" + iTestResult.getName());
		logger.log(Status.PASS, iTestResult.getName() + " has been successfully tested");
	}// logger.pass();}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		System.out.println("The name of the testcase failed is :" + iTestResult.getName());
		logger.log(Status.FAIL, iTestResult.getName() + " validation failed");
	}

	@Override
	public void onTestSkipped(ITestResult iTestResult) {
		System.out.println("The name of the testcase Skipped is :" + iTestResult.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

	}

}
