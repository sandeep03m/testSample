package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PlanSection extends PageBase {
	private By myProfile = By.cssSelector("div.Fmlylan_profile a.newstyle");
	private By familyProfile = By.cssSelector("div.Fmlylan_profile li:nth-of-type(2) div.newstyle");
	private By assumptions = By.cssSelector("div.Fmlylan_profile li:nth-of-type(3) div.newstyle");

	public PlanSection(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public boolean verifyPlanSectionOptions()
	{
		boolean bValue = false;
		bValue = (isElementVisible(driver, 5, myProfile) && isElementVisible(driver, 5, familyProfile) && isElementVisible(driver, 5, assumptions));
		return bValue;
	}
	
	

}
