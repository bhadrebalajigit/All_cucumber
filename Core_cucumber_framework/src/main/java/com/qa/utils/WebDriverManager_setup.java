package com.qa.utils;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;	
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.cucumber.listener.Reporter;


public class WebDriverManager_setup {
	
	public WebDriver driver;

	
	public WebDriver getDriver(String browserName)
	{
		
	
	if (driver == null) {
		switch (browserName) {
		case "FireFox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			Reporter.addStepLog("Running test on Firefox");
			break;

		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			Reporter.addStepLog("Running test on Chrome");
			break;
		case "IE":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();	
			Reporter.addStepLog("Running test on IE");
			break;
		case "Headless":
			WebDriverManager.phantomjs().setup();
			//driver = new ChromeDriver();	
			//driver = new PhantomJSDriver();
			Reporter.addStepLog("Running test on Headless browser");
			break;
				
		default:
			Reporter.addStepLog(""+browserName+" is not valid");
			throw new IllegalArgumentException(
					String.format("%s browser is not valid please provide valid browserName", browserName));
			
					
		}
	}
	driver.manage().window().maximize();
	return driver;
}

public  void quitDriver() {
	if (driver != null) {
		driver.quit();
		driver=null;

	}
}
}
