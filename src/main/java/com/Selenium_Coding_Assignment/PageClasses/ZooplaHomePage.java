package com.Selenium_Coding_Assignment.PageClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Selenium_Coding_Assignment.Base.BaseClass;
import com.Selenium_Coding_Assignment.Utils.Util;

public class ZooplaHomePage extends BaseClass{
	
	@FindBy(xpath="//form[@name='search-form']//div[2]//div[@class='search-top']//div[@id='search-input-location-wrapper']//input")
	WebElement Search_Input;
	
	@FindBy(xpath="//button[@id='search-submit']")
	WebElement Search_Submit;
	
	@FindBy(xpath="//div[@class='search-home']//h1")
	WebElement findPerfecthome;
	
	
	public ZooplaHomePage() {
		PageFactory.initElements(driver, this);

	}
	
	public WebElement findHometext(){
		return findPerfecthome;
	}
	
	public PropertySalesPage searchLocation(String locationName){
		/*WebDriverWait wait=new WebDriverWait(driver, Util.webElementTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(Search_Input)).sendKeys(locationName);
		
		wait.until(ExpectedConditions.elementToBeClickable(Search_Submit)).click();*/
		
		Search_Input.sendKeys(locationName);
		Search_Submit.click();
		
		return new PropertySalesPage();
		
	}

}
