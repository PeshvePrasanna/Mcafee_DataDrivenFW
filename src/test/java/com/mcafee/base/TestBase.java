package com.mcafee.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	/*
	 * initialize the following WebDriver - done Properties - done Logs WebDriver
	 * ExtentReport DB Excel Mail
	 * 
	 */
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Actions actions;
	public static WebElement ele;
	public static Logger logs = Logger.getLogger("devpinoyLogger");

	@BeforeSuite
	public void setUp() {

		if (driver == null) {

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
				logs.debug("Config file loaded !!!");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
				logs.debug("OR file loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("requireWindowFocus", true);
			if (config.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
				// WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				logs.debug("Chrome is launched !!!");
			}
			if (config.getProperty("browser").equals("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe");
				// WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			if (config.getProperty("browser").equals("ie")) {
				// System.setProperty("webdriver.ie.driver",
				// System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\IEDriver.exe");
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			}

			driver.get(config.getProperty("testsiteurl"));
			logs.debug("Navigated to url = " + config.getProperty("testsiteurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("ImplicitWait")),
					TimeUnit.SECONDS);
			actions = new Actions(driver);

		}

	}

	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
		logs.debug("Test executed succesfully");
	}

}
