package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase {
	private By homeIcon =  By.id("homeiconTab");
	private By plan =  By.id("planhover");
	private By execute =  By.id("exhover");
	private By manage =  By.cssSelector(".lcm_manage #mnghover");
	

	public HomePage(WebDriver driver) {
		super(driver);
		this.initPage(homeIcon);
	}
	
	public PlanSection clickPlanSection()
	{
		driver.findElement(plan).click();
		return new PlanSection(driver);
	}
	
	public ExecutePage clickExecuteSection()
	{
		driver.findElement(execute).click();
		return new ExecutePage(driver);
	}
	
	public ManagePage clickManageSection()
	{
		driver.findElement(manage).click();
		return new ManagePage(driver);
	}
	
	

}
