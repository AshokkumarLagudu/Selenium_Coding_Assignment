package com.Selenium_Coding_Assignment.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Selenium_Coding_Assignment.Utils.Util;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	
	
	public BaseClass(){
		prop=new Properties();
		String filePath="C:\\Users\\ASHOK\\workspace\\Selenium_Coding_Assignment\\src\\main\\"
				+ "java\\com\\Selenium_Coding_Assignment\\configuration"
				+ "\\configurations.properties";

		try {
			FileInputStream fis=new FileInputStream(new File(filePath));
			prop.load(fis);
		} catch (FileNotFoundException e) {
			System.out.println("Properties File not found at given location");
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
	}
	public void initialization(){
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverPath"));
			driver=new ChromeDriver();
		}else if(browserName.equals("firefox")){
			System.setProperty("webdriver.chrome.driver", prop.getProperty("firefoxDriverPath"));
			driver=new FirefoxDriver();

		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Util.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Util.webElementTimeOut, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	

	

}
