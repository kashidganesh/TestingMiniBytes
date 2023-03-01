package com.tmb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tmb.constants.FrameworkConstant;
import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;
import com.tmb.factory.ExplicitWaitFactory;
import com.tmb.reports.ExtentLogger;

public class BasePage {

	protected void click(By by, WaitStrategy waitstrategy, String elementname) {

		WebElement element = ExplicitWaitFactory.perfromExplicitWait(waitstrategy, by);
		element.click();
		try {
			ExtentLogger.pass(elementname+" is clicked", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void sendKeys(By by, String value, WaitStrategy waitstrategy,String elementname) {

		WebElement element = ExplicitWaitFactory.perfromExplicitWait(waitstrategy, by);
		element.sendKeys(value);
		try {
			ExtentLogger.pass(value +"is entered successfully"+elementname, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}

//	private void explicityWaitForElementToBeClickable(By by) {
//		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), FrameworkConstant.getExplicitwait());
//		wait.until(ExpectedConditions.elementToBeClickable(by));
//	}
//
//	private void explicityWaitForElementToBePresent(By by) {
//		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), FrameworkConstant.getExplicitwait());
//		wait.until(ExpectedConditions.presenceOfElementLocated(by));
//	}

}
