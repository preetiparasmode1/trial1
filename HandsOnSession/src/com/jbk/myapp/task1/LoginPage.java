package com.jbk.myapp.task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginPage {

	
	WebDriver driver=null;
	
	@BeforeSuite
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("file:///D:/Offline%20Website/index.html");
		
	}
	
	@AfterSuite
	public void tearDown() {
		driver.close();
		
	}
	@Test
	public void testToVeriryLoginPageTItle() {
	  Assert.assertEquals(driver.getTitle(), "JavaByKiran | Log in");
	}
	
	@Test
	public void testToVerifyLoginDetails() {
	 driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
	 driver.findElement(By.id("password")).sendKeys("123456");
	 driver.findElement(By.xpath("//button")).click();
	 Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");	
	}
	
	@Test
	public void testToVerifyIncoorectLoginDetails() throws InterruptedException {
		 driver.findElement(By.id("email")).sendKeys("kiran@dfyrtwgmail.com");
		 driver.findElement(By.id("password")).sendKeys("123656456");
		 driver.findElement(By.xpath("//button")).click();
		 String s=driver.findElement(By.id("email_error")).getText();
		 String a=driver.findElement(By.id("password_error")).getText();
		 Assert.assertEquals(s,"Please enter email as kiran@gmal.com");
		 Assert.assertEquals(a, "Please enter password 123456");
		 
}
	@Test
	public void testToVerifyBlankLoginDetails() throws InterruptedException {
		 driver.findElement(By.id("email")).sendKeys(" ");
		 driver.findElement(By.id("password")).sendKeys(" ");
		 driver.findElement(By.xpath("//button")).click();
		 String s = driver.findElement(By.id("email_error")).getText();
		 String a=driver.findElement(By.id("password_error")).getText();
		 Assert.assertEquals(s,"Please enter email");
		 Assert.assertEquals(a, "Please enter password");
		
		
	}
}