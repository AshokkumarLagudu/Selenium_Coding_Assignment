package com.Selenium_Coding_Assignment.PageTestClass;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Selenium_Coding_Assignment.Base.BaseClass;
import com.Selenium_Coding_Assignment.PageClasses.PropertySalesPage;
import com.Selenium_Coding_Assignment.PageClasses.ZooplaHomePage;

public class PropertySalesPageTest extends BaseClass{
	ZooplaHomePage zooplaHomepage;
	PropertySalesPage propertySalesPage;
	public PropertySalesPageTest() {
		super();
	}
	
	@BeforeMethod
	public void openBrowser(){
		initialization();
		zooplaHomepage=new ZooplaHomePage();
		propertySalesPage=zooplaHomepage.searchLocation("London");
	}
	
	@Test
	public void allPropertyPriceTest(){
		String pageTitle=driver.getTitle();
		Assert.assertEquals(pageTitle, "Property for Sale in London - Buy Properties in London - Zoopla");
		propertySalesPage.getAllPropertyPrice();
		propertySalesPage.selectFifthProperty();
	}
	
	
	@AfterMethod
	public void closeBrowser(){
		driver.quit();
	}

}
