package com.mcafee.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.mcafee.base.TestBase;

public class RegisterNewUser extends TestBase{
	
	@Test
	public void Register_NewUser() throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(By.xpath(OR.getProperty("login_btn"))).click();
		Thread.sleep(2000);
		driver.switchTo().frame(0).findElement(By.xpath(OR.getProperty("NewUser_RegisterNow"))).click();
		Thread.sleep(2000);
		
	}
}