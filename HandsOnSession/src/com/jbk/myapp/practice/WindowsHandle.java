package com.jbk.myapp.practice;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowsHandle {

	WebDriver driver;
	@Test
	public void windowHandlerUsefulLinks() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("file:///D:/Offline%20Website/index.html");
		driver.manage().window().maximize();
		
	 String mainWindow=driver.getWindowHandle();
	 List<WebElement>listOfGoLink=(List<WebElement>) driver.findElement(By.xpath(""));
	 
	 	
		
	}
}
