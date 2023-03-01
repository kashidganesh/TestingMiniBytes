package com.tmb.tests;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tmb.driver.Driver;
import com.tmb.driver.DriverManager;

public final class HomepageTests extends BaseTest {

	private HomepageTests() {

	}

	@Test
	public void test3() throws Exception {
		//Driver.initDriver();
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Testing mini bytes - YouTube",Keys.ENTER);
				
		String title = DriverManager.getDriver().getTitle();
		
		 assertThat(title)
		.as("Title is actually null").isNotNull()
		 .as("It does not contatins expected text").containsIgnoringCase("Google Search")
		.matches("\\w.*"+"Google Search")
		.hasSizeBetween(15, 100);
		
		 
	    
		
		List<WebElement> elements=DriverManager.getDriver().findElements(By.tagName("h3"));  
	  //  Assert.assertEquals(elements.size(), 10);
	    
	     assertThat(elements)
	    .hasSize(10)
	    .extracting(WebElement :: getText)
	    .contains("Testing Mini Bytes - YouTube");
	    
		/*
		 * boolean isElementPresent = false; for (WebElement element : elements) { if
		 * (element.getText().equalsIgnoreCase("Testing Mini Bytes - YouTube")) {
		 * isElementPresent = true; break; } }
		 * Assert.assertTrue(isElementPresent,"testing mini bytes not found");
		 */
	
	
	}
	
	

}
