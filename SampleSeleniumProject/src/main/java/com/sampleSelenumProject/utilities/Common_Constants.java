package com.sampleSelenumProject.utilities;

/*
 * @Author: Aparna
 * Description: This class contains all static final values
 */
public class Common_Constants {

	static Reusable_Logic reu = new Reusable_Logic();

	public static final String AUTOMATION_URL = "http://automationpractice.com/index.php";

	public static final String FILE_PATH = "D:\\Workspace\\SampleSeleniumProject\\TestData.xlsx";

	public static String EMAILID = "test" + reu.getTime() + "@test.com";
	public static final String PASSWORD = "sele1234";

	public static final String ADDRESS1 = "AutomationTest";
	public static final String POSTAL_CODE = "TW33AL";
	public static final String PRIMARY_PHONE = "08993993939";
	public static final String F_NAME = "Test First Name";
	public static final String L_NAME = "Test Last Name";
	public static final String ALIAS_NAME = "Test Alias";
	public static String COMPANY_NAME = "Test_Account" + reu.getTime();
}
