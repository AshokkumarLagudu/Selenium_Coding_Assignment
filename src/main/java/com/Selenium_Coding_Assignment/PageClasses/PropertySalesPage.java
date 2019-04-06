package com.Selenium_Coding_Assignment.PageClasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Selenium_Coding_Assignment.Base.BaseClass;
import com.Selenium_Coding_Assignment.Utils.Util;

public class PropertySalesPage extends BaseClass {
	
	@FindBy(xpath="//h3[@class='listing-results-attr']//preceding-sibling::a[@class='listing-results-price text-price']")
	List<WebElement> allProperties;
	
	public PropertySalesPage() {
		PageFactory.initElements(driver, this);
	}
	public String fifthProperty="";
	public void getAllPropertyPrice(){
		
		List<Integer> allPrice=new ArrayList<Integer>();
		
		for(WebElement price:allProperties){
			
			String priceValue=price.getText().replaceAll("[^0-9]", "");
			String[] pValue=priceValue.split("[^0-9]");
			for(int i=0;i<pValue.length;i++){
				if(!pValue[i].equals("")){
					int intPrice=Integer.parseInt(pValue[i]);
					allPrice.add(intPrice);
				}
				
			}
			
			
		}
		Collections.sort(allPrice,Collections.reverseOrder());
		
		for(Integer pr:allPrice){
			System.out.println("£"+pr);
		}
	}
	
	public AgentPage selectFifthProperty(){
		int count=0;
		for(WebElement propElement:allProperties){
			if(count==5){
				propElement.click();
				break;
			}
			count++;
		}
		
		return new AgentPage();
	}
	

}
