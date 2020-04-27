package com.qa.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class TestBase {
	

public static WebDriver driver;
public static Properties prop;
private final String propertyFilePath= "\\src\\main\\java\\com\\qa\\ConfigFiles\\ConfigProperties.properties";
public static String Currentdirpath;
public static String testdatapath="\\TestData\\TestData.xlsx";
public static  String TestCaseID;

public TestBase() {
	FileInputStream fis = null;
	prop=new Properties();
	Path currentRelativePath = Paths.get("");
	 Currentdirpath = currentRelativePath.toAbsolutePath().toString();
	try {
		 fis=new FileInputStream(Currentdirpath+propertyFilePath);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} 
	try {
		prop.load(fis);
	} catch (IOException e) {
		e.printStackTrace();
	}
}


public static void initializalation () {
	String browser=prop.getProperty("Browser");
	if(browser.equalsIgnoreCase("Chrome")) {
		System.setProperty("webdriver.chrome.driver",Currentdirpath+"\\Jars\\chromedriver.exe");
		driver=new ChromeDriver();
	}else if(browser.equalsIgnoreCase("Firebox")) {
		System.setProperty("webdriver.gecko.driver",Currentdirpath+"\\Jars\\chromedriver.exe");
		driver=new FirefoxDriver();	
	}else if(browser.equalsIgnoreCase("InternetExplorer")) {
		System.setProperty("webdriver.internetexplorer.driver",Currentdirpath+"\\Jars\\chromedriver.exe");
		driver=new InternetExplorerDriver();	
	}else {
		System.out.println("Browser Name is not provided in Configuration properties file.");
	}
	
	String Env=prop.getProperty("Enviornment");
	if(Env.equalsIgnoreCase("SIT")) {
		driver.get(prop.getProperty("Application_URL_SIT"));
	}else if(Env.equalsIgnoreCase("UAT")) {
		driver.get(prop.getProperty("Application_URL_UAT"));
	}
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_load_timeout, TimeUnit.SECONDS);
}
	
}
