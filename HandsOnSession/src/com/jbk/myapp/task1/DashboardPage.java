package com.jbk.myapp.task1;



import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DashboardPage {

	WebDriver driver= null;
	
 @BeforeSuite
 public void setup() {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe") ;
	driver = new ChromeDriver();
	driver.get("file:///D:/Offline%20Website/pages/examples/dashboard.html");
	driver.manage().window().maximize();
 }
 
 @AfterSuite
 public void tearDown() {
	 driver.close();
 }
 @Test
 public void toVerifyHeader() throws InterruptedException {
	// driver.findElement(By.tagName("h1")).getText();
	boolean a= driver.findElement(By.tagName("h1")).isDisplayed();
	Thread.sleep(50000);
	 Assert.assertTrue(a);
 }
 @Test
 public void windowHandle() {
	 String mainwin = driver.getWindowHandle();
	List<WebElement> links = driver.findElements(By.partialLinkText("more"));
	for(WebElement link : links) {
		link.click();
	}
	
	Set<String>allWin= driver.getWindowHandles();
	for(String winId : allWin) {
		if(!winId.equals(mainwin))
		{
		driver.switchTo().window(winId);	
		System.out.println(driver.getCurrentUrl());
		driver.close();
		}
		else {
			System.out.println("currently we are in parent window");
		}
	}
 }
 
}
