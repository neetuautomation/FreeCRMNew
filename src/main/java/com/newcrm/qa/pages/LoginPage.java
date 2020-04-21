package com.newcrm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.newcrm.qa.base.*;


public class LoginPage extends TestBase {
	@FindBy(xpath="/html/body/div[1]/header/div/nav/div[2]/div/div[2]/ul/a/span[2]")	         
	WebElement loginbtn;
	
	@FindBy(name = "email")
	WebElement email;
	
	@FindBy(name = "password")
	WebElement pwd;
	
	@FindBy(xpath = "//*[@id=\"ui\"]/div/div/form/div/div[3]")
	WebElement submit;
	
	@FindBy(xpath = "/html/body/div[1]/header/div/nav/div[2]/div/div[1]/div/a/svg/image")
	WebElement logo;
		//Initializing the Page Objects 
	public void LoginTest() {
		PageFactory.initElements(driver, this);
	}
		//Actions
		public String  validateTitle() {
			return driver.getTitle();
		}
		
		public boolean validateLogo() {
			return logo.isDisplayed();
		}
					
		public HomePage validateLogin(String username, String password) {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			System.out.println("driver=" + driver);
			loginbtn.click();
			email.sendKeys(username);
			pwd.sendKeys(password);
			submit.click();
			return new HomePage();
			
		}
	

}
