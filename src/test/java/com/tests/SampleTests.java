package com.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pageObjects.ExecutePage;
import com.pageObjects.HomePage;
import com.pageObjects.Loginpage;
import com.pageObjects.ManagePage;
import com.pageObjects.PlanSection;

public class SampleTests extends TestBase {
	private String username = "sandeep03.m@gmail.com";
	private String password = "Started1!";
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Test(priority=1)
	public void testLogintoArthaYantra()
	{
		logger.debug("testLogintoArthaYantra is being executed");
		Loginpage loginpage = this.launchArthaYatra();
		HomePage homePage = loginpage.loginToArthaYantra(username, password);
		Assert.assertNotNull(homePage,"Home page is not displayed, login is not succesfull");
	}
	
	@Test(priority=2)
	public void testVerifyPlanOptions()
	{
		logger.info("testVerifyPlanOptions is being executed");
		Loginpage loginpage = this.launchArthaYatra();
		HomePage homePage = loginpage.loginToArthaYantra(username, password);
		Assert.assertNotNull(homePage,"Home page is not displayed, login is not succesfull");
		
		PlanSection planSection = homePage.clickPlanSection();
		Assert.assertNotNull(planSection,"Plan Section page is not displayed");
		Assert.assertTrue(planSection.verifyPlanSectionOptions(),"plan section page options are not displayed");
	}
	
	@Test(priority=3)
	public void testVerifyExecuteOptions()
	{
		logger.info("testVerifyExecuteOptions is being executed");
		Loginpage loginpage = this.launchArthaYatra();
		HomePage homePage = loginpage.loginToArthaYantra(username, password);
		Assert.assertNotNull(homePage,"Home page is not displayed, login is not succesfull");
		
		ExecutePage executeSection = homePage.clickExecuteSection();
		Assert.assertNotNull(executeSection,"Plan Section page is not displayed");
		Assert.assertTrue(executeSection.verifyExecutePageDisplay(),"execute section page options are not displayed");
	}
	
	@Test(priority=4)
	public void testVerifyManageOptions()
	{
		logger.info("testVerifyManageOptions is being executed");
		Loginpage loginpage = this.launchArthaYatra();
		HomePage homePage = loginpage.loginToArthaYantra(username, password);
		Assert.assertNotNull(homePage,"Home page is not displayed, login is not succesfull");
		
		ManagePage manageSection = homePage.clickManageSection();
		Assert.assertNotNull(manageSection,"Plan Section page is not displayed");
		Assert.assertTrue(manageSection.verifyManagePageDisplay(),"Manage section page options are not displayed");
	}
	
	private Loginpage launchArthaYatra()
	{
		this.getDriver().get("http://arthos.arthayantra.com/login.html");
		Loginpage loginpage = new Loginpage(this.getDriver());
		Assert.assertNotNull(loginpage,"Login page is not displayed");
		return loginpage;
	}

}
