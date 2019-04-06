package com.Selenium_Coding_Assignment.PageTestClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Selenium_Coding_Assignment.Base.BaseClass;
import com.Selenium_Coding_Assignment.PageClasses.AgentDetailsPage;
import com.Selenium_Coding_Assignment.PageClasses.AgentPage;
import com.Selenium_Coding_Assignment.PageClasses.PropertySalesPage;
import com.Selenium_Coding_Assignment.PageClasses.ZooplaHomePage;


public class ZooplaHomePageTest extends BaseClass{
   public ZooplaHomePage zooplaHomepage;
   public PropertySalesPage propertySalesPage;
    AgentPage agentPage;
	AgentDetailsPage agentDetailsPage;
	String agentName;
	String agentNameinDetailsPage;
ZooplaHomePageTest() {
	    super();
	}

	@BeforeClass
	public void openBrowser(){
		initialization();
		zooplaHomepage=new ZooplaHomePage();
	}
	
	//Enter location name in SearchBox
	@Test
	public void searchLocationTest() throws InterruptedException{
		String homePageTitle=driver.getTitle();
		
		//validating title of page.
		Assert.assertEquals(homePageTitle,"Zoopla > Search Property to Buy, Rent, House Prices, Estate Agents");
		
		//Enter location name in SearchBox
		propertySalesPage=zooplaHomepage.searchLocation(prop.getProperty("locationName"));
		Thread.sleep(3000);
		
		//validating title of page after click on Search button
		String propertyPageTitle=driver.getTitle();
		Assert.assertEquals(propertyPageTitle, "Property for Sale in London - Buy Properties in London - Zoopla");
		
	}
	
	@AfterClass
	public void closeBrowser(){
		driver.quit();
	}
	
	
}
