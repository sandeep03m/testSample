package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage extends PageBase {
	private By userNameTextBox =  By.name("Username");
	private By passwordTextBox =  By.name("Password");
	private By loginBtn =  By.id("loginBtn");

	public Loginpage(WebDriver driver) {
		super(driver);
        this.initPage(userNameTextBox);
	}
	
	public HomePage loginToArthaYantra(String username,String password ){
		enterUserName(username);
		enterPassword(password);
		HomePage homePage = clickLogin();
		return homePage;
	}
	
    public void enterUserName(String username) {
        driver.findElement(userNameTextBox).clear();
        if (username != null && username != "") {
        	 driver.findElement(userNameTextBox).sendKeys(username);
        }
    }

    public void enterPassword(String password) {
        driver.findElement(passwordTextBox).clear();
        if (password != null && password != "") {
            driver.findElement(passwordTextBox).sendKeys(password);
        }
    }
    
    public HomePage clickLogin()
    {
        driver.findElement(loginBtn).click();
        return new HomePage(driver);
    }

}
