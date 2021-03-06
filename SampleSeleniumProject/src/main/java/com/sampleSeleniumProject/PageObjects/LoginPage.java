package com.sampleSeleniumProject.PageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sampleSelenumProject.utilities.Common_Constants;
import com.sampleSelenumProject.utilities.Reusable_Logic;

/**
 * @Author : Aparna
 * @Description : This class represents the login functionality and user creation
 */

public class LoginPage extends Reusable_Logic {

	@FindBy(xpath = "//div/a[contains(@class,'login')]")
	private WebElement signin;
	@FindBy(xpath = "//div/form/h3[contains(text(),'Create an account')]")
	private WebElement createAccText;
	@FindBy(xpath = "//div/input[contains(@type,'text')]")
	private WebElement emailAddField;
	@FindBy(xpath = "//button/span/i[contains(@class,'icon-user left')]")
	private WebElement createAnAccBtn;
	@FindBy(xpath = "//div/h3[contains(text(),'Your personal information')]")
	private WebElement personalInfoTxt;
	@FindBy(xpath = "//div/label[contains(@for,'id_gender2')]")
	private WebElement femaleGender;
	@FindBy(xpath = "//div/label[contains(@for,'id_gender1')]")
	private WebElement maleGender;
	@FindBy(xpath = "//div/input[contains(@id,'customer_firstname')]")
	private WebElement firstName;
	@FindBy(xpath = "//div/input[contains(@id,'customer_lastname')]")
	private WebElement lastName;
	@FindBy(xpath = "//div/input[contains(@id,'email')]")
	private WebElement registeredEmail;
	@FindBy(xpath = "//div/input[contains(@id,'passwd')]")
	private WebElement enterPassword;
	@FindBy(xpath = "//select[contains(@id,'days')]")
	private WebElement dateDropDown;
	@FindBy(xpath = "//select[contains(@id,'months')]")
	private WebElement monthDropDown;
	@FindBy(xpath = "//select[contains(@id,'years')]")
	private WebElement yearDropDown;
	@FindBy(xpath = "//p/input[contains(@id,'firstname')]")
	private WebElement addressFirstName;
	@FindBy(xpath = "//p/input[contains(@id,'lastname')]")
	private WebElement addressLastName;
	@FindBy(xpath = "//p/input[contains(@id,'company')]")
	private WebElement companyName;
	@FindBy(xpath = "//p/input[contains(@id,'address1')]")
	private WebElement address1;
	@FindBy(xpath = "//p/input[contains(@id,'address2')]")
	private WebElement address2;
	@FindBy(xpath = "//p/input[contains(@id,'city')]")
	private WebElement addCity;
	@FindBy(xpath = "//select[contains(@id,'id_state')]")
	private WebElement stateDropDown;
	@FindBy(xpath = "//p/input[contains(@id,'postcode')]")
	private WebElement addZip;
	@FindBy(xpath = "//select[contains(@id,'id_country')]")
	private WebElement addCountry;
	@FindBy(xpath = "//p/input[contains(@id,'phone_mobile')]")
	private WebElement phoneNum;
	@FindBy(xpath = "//p/input[contains(@id,'alias')]")
	private WebElement adddressAlias;
	@FindBy(xpath = "//button[contains(@id,'submitAccount')]")
	private WebElement registerBtn;
	@FindBy(xpath = "//div/ol/li | //a/span[contains(text(),' Home')]")
	private WebElement errorMsgOrHomePage;

	/**
	 * @Description : This function will instantiate the class
	 * @Param : WebDriver
	 */
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/**
	 * @Description:This function will create a new user account
	 * 
	 * @Exception: IOException
	 */
	public void newuserAccount() throws IOException {
		loadUrl();
		this.signin.click();
		wait_Till_PageLoad();
		if (createAccText.isDisplayed() && emailAddField.isDisplayed()) {
			this.emailAddField.sendKeys(Common_Constants.EMAILID);
			this.createAnAccBtn.click();
			wait_Till_PageLoad();
		} else {
			System.out.println("fields are not present");
		}
	}

	/**
	 * @Description: This function will update the account details
	 * @param: String
	 */

	public void accountDetails(String date, String month, String year)
			throws IOException {
		String emailid = emailAddField.getText();
		System.out.println("Email id entered as " + emailid);

		if (personalInfoTxt.isDisplayed() && this.femaleGender.isDisplayed()) {

			this.femaleGender.click();
			this.firstName.sendKeys(Common_Constants.F_NAME);
			this.lastName.sendKeys(Common_Constants.L_NAME);
			this.enterPassword.sendKeys(Common_Constants.PASSWORD);

			select_ByValue(dateDropDown, date);
			select_ByValue(monthDropDown, month);
			select_ByValue(yearDropDown, year);
		}
	}

	/**
	 * @Description: This function will update the contact details
	 * @Param:String
	 */

	public void contactDetails(String city, String state, String country) {
		try {
			addressFirstName.sendKeys(Common_Constants.F_NAME);
			addressLastName.sendKeys(Common_Constants.L_NAME);
			companyName.sendKeys(Common_Constants.COMPANY_NAME);
			address1.sendKeys(Common_Constants.ADDRESS1);
			addCity.sendKeys(city);
			WebElement ele4 = stateDropDown;
			Select sl4 = new Select(ele4);
			sl4.selectByValue(state);
			this.addZip.sendKeys(Common_Constants.POSTAL_CODE);
			this.addCountry.sendKeys(country);
			this.phoneNum.sendKeys(Common_Constants.PRIMARY_PHONE);
			this.adddressAlias.clear();
			this.adddressAlias.sendKeys(Common_Constants.ALIAS_NAME);
			this.registerBtn.click();
			wait_Till_PageLoad();
			errorMsgOrHomePage.click();
			wait_Till_PageLoad();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("StakTrace for Contact Details" + ""
					+ e.getMessage());
		}
	}

}
