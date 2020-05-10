package com.mcafee.testcase;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mcafee.base.TestBase;

public class AddEmployee extends TestBase {
	
@Test(dataProvider="getData")
public void addEmp(String empName, String userName, String pwd, String confirmpwd) {
	
	driver.findElement(By.id(OR.getProperty("admin_tab"))).click();
}

@DataProvider
public Object[][] getData(){
	return null;
	
}
}
