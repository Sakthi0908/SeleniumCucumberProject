package com.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Utilities.TestBase;

public class AmazonMainPage extends TestBase {

	// Page Factory-OR
	@FindBy(xpath = "//a[@id='nav-link-accountList']")
	WebElement Hellosignin;

	// Initializing page objects
	public AmazonMainPage() {
		PageFactory.initElements(driver, this);
	}
//clicksignmethod
	public boolean clicksignin() {
		Hellosignin.click();
		return true;
	}

	public String verifyPageTitle() {
		return driver.getTitle();

	}

}
