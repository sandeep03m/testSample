package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExecutePage extends PageBase {
	private By accountSetUp = By.xpath("//div[contains(text(),'Investment Account Setup')]");

	public ExecutePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public boolean verifyExecutePageDisplay()
	{
		boolean bValue = false;
		bValue = isElementVisible(driver, 5, accountSetUp);
		return bValue;
	}

}
