package com.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public abstract class TestBase {
	
	public WebDriver driver;
	DesiredCapabilities capability = null;
	
	public WebDriver getDriver()
	{
		if(driver==null)
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--test-type");
			options.addArguments("start-maximized");
			options.addArguments("--always-authorize-plugins=true");
			options.addArguments("--disable-popup-blocking");
			capability = DesiredCapabilities.chrome();
			capability.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(capability);
		}
		return driver;
	}
	
	public void setproperty()
	{
		Properties props = System.getProperties();
		props.setProperty("gate.home", "http://gate.ac.uk/wiki/code-repository");
	}
	
	@AfterMethod
	public void afterMethod()
	{
		if(getDriver()!=null)
		{
			driver.close();
			driver=null;
		}
	}
	
	@AfterClass
	public void afterClass()
	{
		if(getDriver()!=null)
		{
			driver.quit();
			driver=null;
		}
	}

}
