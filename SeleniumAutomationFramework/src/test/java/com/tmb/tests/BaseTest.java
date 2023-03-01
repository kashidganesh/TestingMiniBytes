package com.tmb.tests;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.tmb.driver.Driver;
import com.tmb.reports.ExtentReport;
//Base Test class
public class BaseTest {

	protected BaseTest() {

	}

	/*
	 * private, protected, default --> public
	 */

	 

	@BeforeMethod
	protected void setUp(Object[]data) throws Exception {
		Map<String, String> map=(Map<String, String>)data[0];
		Driver.initDriver(map.get("browser"));
	}

	@AfterMethod
	protected void tearDown( ) {
		Driver.quitDriver();
	}

}
