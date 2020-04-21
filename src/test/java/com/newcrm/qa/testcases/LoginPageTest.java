package com.newcrm.qa.testcases;
import org.testng.*;
import org.testng.annotations.*;
import com.newcrm.qa.base.*;
import com.newcrm.qa.pages.*;

public class LoginPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	@BeforeMethod
	public void setup() throws Exception{
		initialization();
		loginPage = new LoginPage();
	}
	@Test(priority=1)
	public void loginPageTitleTest() {
		String actualTitle = loginPage.validateTitle();
		Assert.assertEquals(actualTitle, "Free CRM #1 cloud software for any business large or small");
	}
//	@Test(priority=2)
//	public void logoImageTest() {
//		boolean flag = loginPage.validateLogo();
//		Assert.assertTrue(flag);
//	}
	@Test(priority=3)
	public void login() {
		homePage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	@AfterMethod
	public void tearDown() {
	driver.quit();
	}
}
