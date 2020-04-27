package com.qa.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.google.common.io.Files;

public class TestUtil extends TestBase {
	
public static int implicit_wait=20;
public static int Page_load_timeout=20;
public static Recordset recordset =null;
public static Connection connection=null;
public static int count=1;

	public static String ReadExceldata(String SheetName, String TCID, String ColName) {

		Fillo fillo = new Fillo();
		String TestdataVal = null;
		try {
			if (System.getProperty("user.dir") + testdatapath != null) {

				connection = fillo.getConnection(System.getProperty("user.dir") + testdatapath);
				recordset = connection.executeQuery(" Select * from " + SheetName + " where TestcaseID='" + TCID + "'");
				while (recordset.next()) {
					TestdataVal = recordset.getField(ColName).toString();

				}
				recordset.close();
				connection.close();
			}

		} catch (FilloException e) {
			e.printStackTrace();
		}
		return TestdataVal;

	}

	public static String Screenshot() throws IOException {

		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		DateFormat dateFormat = new SimpleDateFormat("mmss");
		Date date = new Date();

		File DestFile = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + TestCaseID
				+ "_" + count + "_" + dateFormat.format(date).toString() + ".jpeg");
		count = count + 1;

		String destfilename = DestFile.toString();

		Files.copy(SrcFile, DestFile);
		return destfilename;
	}





}
