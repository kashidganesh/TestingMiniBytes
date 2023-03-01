package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.enums.WaitStrategy;
import com.tmb.reports.ExtendManager;
import com.tmb.reports.ExtentLogger;
import com.tmb.reports.ExtentReport;

public final class OrangeHRMLoginPage extends BasePage {

	// Assertion should not be called in page layers
	// All your page method needs to have some return type

	private final By textboxUsername = By.xpath("//input[@name='username']");
	private final By textboxPassword = By.xpath("//input[@name='password' and @type='password']");
	private final By buttonLogin = By.xpath("//button[contains(text(),Login)]");

	public OrangeHRMLoginPage enterUserName(String username) {
		// DriverManager.getDriver().findElement(textboxUsername).sendKeys(username);
		sendKeys(textboxUsername, username, WaitStrategy.PRESENCE, " Username");
		 
		return this;
	}

	public OrangeHRMLoginPage enterPassword(String password) {
		// DriverManager.getDriver().findElement(textboxPassword).sendKeys(password);
		sendKeys(textboxPassword, password, WaitStrategy.PRESENCE," Password");
		 
		return this;
	}

	public OrangeHRMHomePage clickLogin() {
		// DriverManager.getDriver().findElement(buttonLogin).click();
		click(buttonLogin, WaitStrategy.PRESENCE," Login Button");
		return new OrangeHRMHomePage();

	}

	public String getTitle() {
		return getPageTitle();
	}

}
