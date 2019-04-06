package com.Selenium_Coding_Assignment.PageClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Selenium_Coding_Assignment.Base.BaseClass;

public class AgentPage extends BaseClass{
	
	@FindBy(xpath="//div[@class='dp-sidebar-wrapper__contact']//div[@class='ui-agent__text']/h4")
	WebElement agentName;

	public AgentPage() {
		PageFactory.initElements(driver, this);
	}
	
	public AgentDetailsPage clickOnAgentName(){
		agentName.click();	
		
		return new AgentDetailsPage();
		
	}
	
	public String getAgentName(){
		String name=agentName.getText();
		return name;
	}
}
