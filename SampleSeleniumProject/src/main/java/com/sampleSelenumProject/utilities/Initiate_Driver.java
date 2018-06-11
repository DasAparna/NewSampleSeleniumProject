package com.sampleSelenumProject.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * @Author: Aparna
 * @Description: This class will initiate the browser Driver
 */
public class Initiate_Driver {
	public static WebDriver driver;

	/**
	 * @Description: This function will initiate the browser Driver
	 * @Param: String
	 */
	public static void initiate_driver(String browser) {

		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\bijay\\Desktop\\Workspace\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browser.equals("Firefox")) {
			System.setProperty(
					"webdriver.geckodriver.driver",
					"C:\\Users\\bijay\\Desktop\\Workspace\\geckodriver-v0.20.1-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\bijay\\Desktop\\Workspace\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
	}
}
