package com.jbk.myapp.practice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArrayListEx {
     WebDriver driver;
	@Test
	public void verifyCources() {
		System.setProperty("webdiver.chrome.driver", "chromrdriver.exe");
		driver= new ChromeDriver();
		driver.get("file:///D:/Offline%20Website/pages/examples/dashboard.html");
		driver.manage().window().maximize();
		ArrayList<String>expectedCourses=new ArrayList<String>();
		ArrayList<String>actCourses=new ArrayList<String>();
		expectedCourses.add("Selenium");
		expectedCourses.add("Java / J2EE");
		expectedCourses.add("Python");
		expectedCourses.add("Php");
		List<WebElement>listOfCourses=driver.findElements(By.xpath("//h3"));
		for(WebElement courseName: listOfCourses) {
			String courseNameEach=courseName.getText();
			//actCourses.add(courseName.getText());
			actCourses.add(courseNameEach);
			
		}
		System.out.println(actCourses);
		Assert.assertEquals(actCourses,expectedCourses);
	}
	}
