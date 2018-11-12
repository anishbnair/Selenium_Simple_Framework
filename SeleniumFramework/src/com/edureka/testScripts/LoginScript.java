package com.edureka.testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.edureka.utility.ReadExcel;

public class LoginScript {
	
	public WebDriver driver = null;
	
	@BeforeMethod
	public void openBrowser() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.edureka.co/");
		
	}
	
	@Test
	public void login() {
		try {
			String[][] data = ReadExcel.getData("TestExcel.xlsx", "Sheet1");
			
			for (int i = 0; i < data.length; i++) {
				String username = data[i][0];
				String password = data[i][1];
				
				driver.findElement(By.xpath("//a[text()=\"Log In\"]")).click();
				driver.findElement(By.xpath("//input[@id=\"si_popup_email\"]")).clear();
				driver.findElement(By.xpath("//input[@id=\"si_popup_email\"]")).sendKeys(username);
				driver.findElement(By.xpath("//input[@id=\"si_popup_passwd\"]")).sendKeys(password);
				driver.findElement(By.xpath("//button[@class=\"clik_btn_log btn-block pagesense_en_track\"]")).click();
								
			}
		} catch (Exception e) {		
			
			e.printStackTrace();	
			
		}		
	}
	
	@Test 
	public void blogSearch() {
		
		// Click on Blog
		driver.findElement(By.xpath("(//a[text()=\"Blog\"])[3]")).click();
		// Click on Interview questions
		driver.findElement(By.xpath("//a[text()=\"Interview Questions\"]")).click();
		// Click on Top Selenium Interview Questions...
		driver.findElement(By.xpath("//a[text()=\"Top Selenium Interview Questions And Answers You Must Prepare In 2018\"]")).click();		
	}
	
	@AfterMethod
	public void closeBrowser() {
//		driver.close();		
	}

}
