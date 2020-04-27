package com.qa.Runner;

import java.io.File;


import org.junit.AfterClass;

import org.junit.runner.RunWith;


import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)				
@CucumberOptions(features="Features",tags= {"@Regression"},glue={"com\\qa\\StepDefinations"},
plugin={"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},monochrome = true,dryRun=false)

public class TestRunner {

	@AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\ConfigFiles\\report.xml"));
        Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
    
    }
}
