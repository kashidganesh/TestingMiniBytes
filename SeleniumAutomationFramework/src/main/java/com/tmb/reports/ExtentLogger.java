package com.tmb.reports;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import com.tmb.driver.DriverManager;
import com.tmb.enums.ConfigProperties;
import com.tmb.utils.PropertyUtils;
import com.tmb.utils.ScreenshotUtils;

public class ExtentLogger {

	private ExtentLogger() {
	}

	public static void pass(String message) {
		ExtendManager.getExtentTest().pass(message);
	}

	public static void fail(String message) {
		ExtendManager.getExtentTest().pass(message);
	}

	public static void skip(String message) {
		ExtendManager.getExtentTest().pass(message);
	}

	public static void pass(String massage, boolean isScreenshotNeed) throws Exception {
		if (PropertyUtils.get(ConfigProperties.PASSEDSTEPSSCRENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeed) {
			ExtendManager.getExtentTest().pass(massage,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());

		} else {
			pass(massage);
		}
	}

	public static void fail(String massage, boolean isScreenshotNeed) throws Exception {
		if (PropertyUtils.get(ConfigProperties.FAILEDSTEPSSCRENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeed) {
			ExtendManager.getExtentTest().fail(massage,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());

		} else {
			fail(massage);
		}
	}

	public static void skip(String massage, boolean isScreenshotNeed) throws Exception {
		if (PropertyUtils.get(ConfigProperties.SKIPPEDSTEPSSCRENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeed) {
			ExtendManager.getExtentTest().skip(massage,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());

		} else {
			skip(massage);
		}
	}

	

}
