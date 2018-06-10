package com.sampleSelenumProject.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
/*
 * @Author: Aparna
 * @Description: This class contains all reusable logic
 */

public class Reusable_Logic extends Initiate_Driver {
	/*
	 * @Description : This function will load the url and maximize the window
	 * 
	 */
	public void loadUrl() {
		driver.get(Common_Constants.AUTOMATION_URL);
		driver.manage().window().maximize();
		wait_Till_PageLoad();
	}
	/*
	 * @Description : This function will wait for 30 seconds until the page is loaded
	 * 
	 */
	public void wait_Till_PageLoad() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	/*
	 * @Description : This function will wait until the element is visible
	 * 
	 */
	public void wait_Till_ElementisVisible() {
		new WebDriverWait(driver, 30)
				.until(ExpectedConditions.visibilityOfElementLocated((By
						.xpath("//a[contains(@title,'Proceed to checkout')]"))));
	}
	/*
	 * @Description : This function will wait until the input time in miliseconds
	 * @Param: int
	 */
	public void wait(int time) throws InterruptedException {
		Thread.sleep(1000);
	}
	/*
	 * @Description : This function will generate a unique name everytime
	 */
	public String getUniqueName() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH-mm-ss");
		return dateFormat.format(date).toString();
	}
	/*
	 * @Description : This function will generate curent time
	 */

	public String getTime() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("mm_ss");
		return dateFormat.format(date).toString();
	}
	/*
	 * @Description : This function will select from drop down by using Text
	 * @Param: WebElement , String
	 */
	public void select_ByText(WebElement element, String option) {
		Select sel = new Select(element);
		sel.selectByVisibleText(option);

	}
	/*
	 * @Description : This function will select from drop down by using Index
	 * @Param: WebElement , String
	 */

	public void select_ByIndex(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * @Description : This function will select from drop down by using Value
	 * @Param: WebElement , String
	 */

	public void select_ByValue(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	/**
	 * @Description : This function will scroll down the current page
	 */

	public void scrollDown() {
		JavascriptExecutor js1 = ((JavascriptExecutor) driver);
		js1.executeScript("window.scrollBy(0,400)");
	}
	
	/**
	 * @Description : This function will mouse hover on the element
	 */
	public void mouseHover(WebElement itemElement) {
	
	Actions act = new Actions(driver);
	act.moveToElement(itemElement).build().perform();
	}
	/**
	 * @Description : This function will delete cookies
	 */

	public void deleteAllCookies() {
		driver.manage().deleteAllCookies();
	}

}
