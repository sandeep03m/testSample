package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageBase {
	protected WebDriver driver;
	
	public PageBase(WebDriver driver) {
		this.driver = driver;
	}
	
	protected static final int pageTimeoutTime = 15;
	
	public void initPage(By initialElement, By... initialElements) {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, pageTimeoutTime), this);
		if (initialElement != null) {
			waitForElementVisibility(driver, 15, initialElement);
			for (By element : initialElements) {
				waitForElementVisibility(driver, 15, element);
			}
		}
	}
	
	public void waitForElementVisibility(WebDriver driver, int timeout,By by) {
		try {
			new WebDriverWait(driver, timeout).until(ExpectedConditions
					.visibilityOfElementLocated(by));
		} catch (TimeoutException e) {
			throw e;
		} catch (NoSuchElementException e) {
			throw e;
		}
	}
	

	public boolean isElementVisible(WebDriver driver, int timeout, By by) {
		try {
			new WebDriverWait(driver, timeout).until(ExpectedConditions
					.visibilityOfElementLocated(by));
			return true;
		} catch (TimeoutException e) {
			return false;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}
