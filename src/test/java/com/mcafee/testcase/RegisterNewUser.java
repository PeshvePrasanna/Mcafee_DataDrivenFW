package com.mcafee.testcase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mcafee.base.TestBase;

public class RegisterNewUser extends TestBase{
	
	@Test
	public void Register_NewUser() throws InterruptedException{
		Thread.sleep(2000);
		logs.debug("Inside Login test page");
		driver.findElement(By.id(OR.getProperty("username"))).sendKeys("Admin");
		Thread.sleep(2000);
		driver.findElement(By.id(OR.getProperty("pwd"))).sendKeys("admin123");
		Thread.sleep(2000);
		driver.findElement(By.id(OR.getProperty("login_btn"))).click();
		Thread.sleep(2000);
		logs.debug("Login Successful!!");
		Assert.assertTrue(isElementPresent(By.id(OR.getProperty("welcome_msg"))),"Login not successful");
		logs.debug("Login validated!!");
//		driver.findElement(By.id(OR.getProperty("welcome_msg"))).click();
//		Thread.sleep(2000);
//		driver.findElement(By.linkText(OR.getProperty("logout_btn"))).click();
	}
}