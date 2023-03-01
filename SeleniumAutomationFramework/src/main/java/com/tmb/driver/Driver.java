package com.tmb.driver;

import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tmb.constants.FrameworkConstant;
import com.tmb.enums.ConfigProperties;
import com.tmb.utils.PropertyUtils;

public final class Driver {

	private Driver() {

	}

	public static void initDriver(String browser) throws Exception {
		// driver == null
		if (Objects.isNull(DriverManager.getDriver())) {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", FrameworkConstant.getChromedriverPath());
				DriverManager.setDriver(new ChromeDriver());
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.chrome.driver", FrameworkConstant.getGeckodriverpath());
				DriverManager.setDriver(new FirefoxDriver());
			}
			DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
		}
	}

	public static void quitDriver() {
		// driver != null
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}

	}

}
