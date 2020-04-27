package com.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Utilities.TestBase;

public class SignPage extends TestBase {

	// Page Factory-OR
	@FindBy(id = "ap_email")
	WebElement txtUserName;

	@FindBy(id = "continue")
	WebElement btnContiue;

	@FindBy(id = "ap_password")
	WebElement txtPwd;

	@FindBy(id = "signInSubmit")
	WebElement btnLogin;

	// Initializing page objects
	public SignPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean EnterUserName() {
		// driver.switchTo().frame("signIn");
		if (prop.getProperty("Enviornment").equalsIgnoreCase("SIT")) {
			txtUserName.sendKeys(prop.getProperty("Username_SIT"));
		} else if (prop.getProperty("Enviornment").equalsIgnoreCase("UAT")) {
			txtUserName.sendKeys(prop.getProperty("Username_UAT"));
		}
		return true;

	}

	public boolean EnterPassword() {
		if (prop.getProperty("Enviornment").equalsIgnoreCase("SIT")) {
			txtPwd.sendKeys(prop.getProperty("Password_SIT"));
		} else if (prop.getProperty("Enviornment").equalsIgnoreCase("UAT")) {
			txtPwd.sendKeys(prop.getProperty("Password_UAT"));
		}
		return true;

	}

	public boolean clickcontinue() {

		btnContiue.click();
		return true;

	}

	public boolean clicklogin() {

		btnLogin.click();
		return true;

	}

}
