package com.Selenium_Coding_Assignment.PageClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Selenium_Coding_Assignment.Base.BaseClass;

public class AgentDetailsPage extends BaseClass {
	@FindBy(xpath="//h1[@class='bottom-half']/b[1]")
	WebElement agentNameInDetailsPage;
	
	public AgentDetailsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getAgentNameInDetailsPage(){
		String name=agentNameInDetailsPage.getText();
		
		return name;
	}

}
