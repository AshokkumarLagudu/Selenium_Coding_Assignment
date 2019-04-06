package com.Selenium_Coding_Assignment.PageTestClass;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Selenium_Coding_Assignment.Base.BaseClass;
import com.Selenium_Coding_Assignment.PageClasses.AgentDetailsPage;
import com.Selenium_Coding_Assignment.PageClasses.AgentPage;
import com.Selenium_Coding_Assignment.PageClasses.PropertySalesPage;
import com.Selenium_Coding_Assignment.PageClasses.ZooplaHomePage;

public class AgentPageTest extends BaseClass{
	ZooplaHomePage zooplaHomepage;
	PropertySalesPage propertySalesPage;
	AgentPage agentPage;
	AgentDetailsPage agentDetailsPage;
	String agentName;
	String agentNameinDetailsPage;
	public AgentPageTest() {
		super();
	}

	@BeforeClass
	public void openBrowser(){
		initialization();
		zooplaHomepage=new ZooplaHomePage();
		propertySalesPage=zooplaHomepage.searchLocation("London");
		agentPage=propertySalesPage.selectFifthProperty();
	}
	
	
	//Validating agent details	
	@Test
	public void clickOnAgentTest() throws InterruptedException{
		
		//Get agent name in agentpage
	    agentName=agentPage.getAgentName();
		agentDetailsPage=agentPage.clickOnAgentName();
		Thread.sleep(2000);
		
		//Get agent name in agent details page
        agentNameinDetailsPage=agentDetailsPage.getAgentNameInDetailsPage();
		
		if(agentName.equals(agentNameinDetailsPage)){
			System.out.println("Agent name is equals");
		}else{
			System.out.println("Agent name is not equals");
		}
		
		
	}
	
	@AfterClass
	public void closeBrowser(){
		driver.quit();
	}
	
	
}
