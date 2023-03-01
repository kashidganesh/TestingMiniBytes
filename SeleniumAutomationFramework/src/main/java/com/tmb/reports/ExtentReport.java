package com.tmb.reports;

import java.awt.Desktop;
import java.io.File;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tmb.constants.FrameworkConstant;

public final class ExtentReport {

	private ExtentReport() {

	}

	private static ExtentReports extent;

	public static void initReports() throws Exception {
		// setup
		if (Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstant.getExtentReportFilePath());
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle("Automation Report");
			spark.config().setReportName("Automation Training");
		}
	}

	public static void flushReports() throws Exception {
		// tearDown
		if (Objects.nonNull(extent)) {
			extent.flush();
		}
		ExtendManager.unload();
		// opan the file in the desktop default browser.
		// Desktop.getDesktop().browse(new
		// File(FrameworkConstant.getExtentreportpath()).toURI());
		Desktop.getDesktop().browse(new File(FrameworkConstant.getExtentReportFilePath()).toURI());
	}

	public static void createTest(String testcasename) {
		ExtentTest test = extent.createTest(testcasename);
		ExtendManager.setExtentTest(test);
	}

}
