package com.tmb.constants;

import com.tmb.enums.ConfigProperties;
import com.tmb.utils.PropertyUtils;

public final class FrameworkConstant {

	private FrameworkConstant() {

	}

	private static final String RESOURCESPATH = System.getProperty("user.dir") + "/src/test/resources";
	private static final String CHROMEDRIVERPATH = RESOURCESPATH + "/executables/chromedriver.exe";
	private static final String GECKODRIVERPATH = RESOURCESPATH + "/executables/geckodriver.exe";
	private static final String CONFIGFILEPATH = RESOURCESPATH + "/config/config.properties";
	private static final String EXCELPATH = RESOURCESPATH + "/excel/testdata.xlsx";
	private static final int EXPLICITWAIT = 10;

	private static final String EXTENTREPORTPATH = System.getProperty("user.dir") + "/extent-test-output/";
	private static String extentReportFilePath = "";

	public static String getExtentReportFilePath() throws Exception {
		if (extentReportFilePath.isEmpty()) {
			extentReportFilePath = createReportPath();
		}
		return extentReportFilePath;
	}

	private static String createReportPath() throws Exception {
		if (PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
			return EXTENTREPORTPATH + System.currentTimeMillis() + "/index.html";
		} else {

			return EXTENTREPORTPATH + "/index.html";
		}

	}

	public static String getExtentreportpath() throws Exception {
		if (PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("yes")) {
			return EXTENTREPORTPATH + "/" + System.currentTimeMillis() + "index.html";
		} else {
			return EXTENTREPORTPATH + "/" + "index.html";
		}
	}

	public static String getChromedriverPath() {
		return CHROMEDRIVERPATH;
	}

	public static String getConfigfilePath() {
		return CONFIGFILEPATH;
	}

	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}

	public static String getExcelpath() {
		return EXCELPATH;
	}

	public static String getGeckodriverpath() {
		return GECKODRIVERPATH;
	}

}
