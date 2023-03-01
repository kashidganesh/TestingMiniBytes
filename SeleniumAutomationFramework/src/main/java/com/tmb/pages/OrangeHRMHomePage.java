package com.tmb.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.util.concurrent.Uninterruptibles;
import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;
import com.tmb.reports.ExtendManager;
import com.tmb.reports.ExtentLogger;

public final class OrangeHRMHomePage extends BasePage {

	private final By linkName = By.xpath("//span[@class='oxd-userdropdown-tab']//p");
	private final By linkLogout = By.xpath("//a[text()='Logout']");

	public OrangeHRMHomePage clickWelcome() {
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

		// DriverManager.getDriver().findElement(linkName).click();
		click(linkName, WaitStrategy.PRESENCE,"Welcome links");
	
		return this;
	}

	public OrangeHRMLoginPage clickLogout() {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10);
		wait.until(ExpectedConditions.elementToBeClickable(linkLogout));

		// DriverManager.getDriver().findElement(linkLogout).click();
		click(linkLogout, WaitStrategy.CLICKABLE,"Logout button");
		return new OrangeHRMLoginPage();
	}

}
