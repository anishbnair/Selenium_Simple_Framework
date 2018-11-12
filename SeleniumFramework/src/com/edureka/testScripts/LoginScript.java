package com.edureka.testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class LoginScript {
	
	public WebDriver driver = null;
	
	@BeforeMethod
	public void openBrowser() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.edureka.co/");
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();		
	}

}
