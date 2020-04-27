package com.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Utilities.TestBase;

public class HomePage extends TestBase {

	// Page Factory-OR
	@FindBy(xpath = "//span[contains(text(),'Hello, sakthivel')]")
	WebElement txtloggedinuser;

	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	WebElement txtsearchbox;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement btnclicksearch;

	@FindBy(xpath = "//span[contains(text(),'Samsung Galaxy M20 (Ocean Blue , 4GB RAM, 64GB Storage, 5000mAH Battery)')]")
	WebElement txtproductdisplay;

	// Initializing page objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String getloggedinuser() {

		return txtloggedinuser.getText();

	}

	public boolean EnterText(String searchtext) {
		txtsearchbox.sendKeys(searchtext);
		return true;

	}

	public boolean clicksearch() {
		btnclicksearch.click();
		return true;

	}

	public boolean productdisplayed() {
		boolean status = txtproductdisplay.isDisplayed();
		return status;

	}

}
