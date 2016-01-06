package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ManagePage extends PageBase {
	private By portfolioTracker = By.cssSelector(".Manage_lft .Manage_hdr");
	private By goalTracker = By.cssSelector(".Manage_rght .Manage_hdr");
	
	public ManagePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public boolean verifyManagePageDisplay()
	{
		boolean bValue = false;
		bValue = (isElementVisible(driver, 5, portfolioTracker) && isElementVisible(driver, 5, goalTracker));
		return bValue;
	}

}
