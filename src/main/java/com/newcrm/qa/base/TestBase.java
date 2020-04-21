package com.newcrm.qa.base;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.ie.*;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() 
	{
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("F:\\Selenium Study\\Project\\Maven\\FreeCRMNew\\src\\main\\java\\com\\newcrm\\config\\config.properties");
			prop.load(ip);
		}catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch(NullPointerException e)
		{
			e.printStackTrace();

		} 
	
	}
	
		public static void initialization() {
			String browserName = prop.getProperty("browser");
			if(browserName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver","C:\\Software\\chromedriver.exe");
				driver=new ChromeDriver();
			} else if(browserName.equals("ie")) {
			System.setProperty("webdriver.ie.driver","F:\\Selenium Study\\Software\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			}
			driver.manage().window().maximize();
//			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			driver.get(prop.getProperty("url"));
			
	
}
			
}
