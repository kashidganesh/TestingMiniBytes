package com.tmb.reports;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class ExtendManager {

	private ExtendManager() {

	}

	private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();

	  static ExtentTest getExtentTest() { //default --> it can be only accessed within the package -->private packages
		return extTest.get();
	}

	  static void setExtentTest(ExtentTest test) {
		extTest.set(test);
	}

	  static void unload() {
		extTest.remove();
	}

}
