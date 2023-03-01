package com.tmb.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.tmb.driver.DriverManager;

public final class LoginpageTests extends BaseTest {

	private LoginpageTests() {

	}

	@Test
	public void test1()   {

		DriverManager.getDriver().findElement(By.xpath("//input[@name='q']")).sendKeys("Automation", Keys.ENTER);

	}
	
	@Test
	public void test3()  {

		DriverManager.getDriver().findElement(By.xpath("//input[@name='q']")).sendKeys("Automation2.0", Keys.ENTER);

	}

}
