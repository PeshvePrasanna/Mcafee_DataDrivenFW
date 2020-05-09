package com.mcafee.rough;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {

		Properties config = new Properties();
		Properties OR = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties");
		config.load(fis);
		fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
		OR.load(fis);
		System.out.println("Browser used: " + config.getProperty("browser"));
		System.out.println("Browser used: " + OR.getProperty("login_btn"));
		
	}

}
