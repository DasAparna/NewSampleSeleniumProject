package com.sampleSelenumProject.utilities;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

/**
 * @Description : This class will read constant parameterized input data from
 *              excel using dataProvider
 */
public class Data_Reader {

	static InputStream inStream;

	@DataProvider
	public static Object[][] ReadAutomation_Data() throws IOException {

		String[][] excel_data = null;
		XSSFWorkbook workBook;
		XSSFSheet sheet;
		try {
			inStream = new BufferedInputStream(new FileInputStream(
					Common_Constants.FILE_PATH));
			workBook = new XSSFWorkbook(inStream);
			sheet = workBook.getSheetAt(0);
			int rows = sheet.getPhysicalNumberOfRows() - 1;
			System.out.println("Rows in given Excel :" + rows);
			excel_data = new String[rows][3];
			for (int i = 1; i <= rows; i++) {
				XSSFRow row = sheet.getRow(i);
				// describe
				for (int j = 0; j < 3; j++) {
					System.out.println("Dyanmic Row Values"
							+ row.getCell(j).toString());
					excel_data[i - 1][j] = row.getCell(j).toString();
				}
			}
		} catch (IOException exp) {
			System.out.println("File Not Found " + exp.getMessage());
		}
		return excel_data;
	}

	/*
	 * @Description : This function will read dynamic data from excel
	 * 
	 * @PAram: String ,int
	 */

	public String getValuesFromExcel(String sheetName, int rowNum, int colNum)
			throws EncryptedDocumentException, InvalidFormatException,
			IOException {
		String value = null;
		String loc;
		try {
			loc = Common_Constants.FILE_PATH;
			FileInputStream fis = new FileInputStream(loc);
			Workbook workBook = WorkbookFactory.create(fis);
			Sheet sh = workBook.getSheet(sheetName);
			Row rw = sh.getRow(rowNum);
			value = rw.getCell(colNum).getStringCellValue();

		} catch (FileNotFoundException e) {
			System.out.println("File Not Found " + e.getMessage());
		}
		return value;
	}
}
