package com.mcafee.testcase;

import org.openqa.selenium.By;
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
		driver.findElement(By.id(OR.getProperty("login_btn")));
		Thread.sleep(2000);
		logs.debug("Login Successful!!");
		
	}
}