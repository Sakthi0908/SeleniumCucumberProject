package com.qa.StepDefinations;

import java.io.IOException;

import org.junit.Assert;

import com.codoid.products.exception.FilloException;
import com.cucumber.listener.Reporter;
import com.qa.Pages.AmazonMainPage;
import com.qa.Pages.HomePage;
import com.qa.Pages.SignPage;
import com.qa.Utilities.TestBase;
import com.qa.Utilities.TestUtil;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginSteps extends TestBase {
	AmazonMainPage mainpage;
	SignPage signpage;
	HomePage homepage;

	@Given("^user is logged into amazon portal$")
	public void user_is_logged_into_amazon_portal() throws IOException {
		TestBase.initializalation();
		AmazonMainPage mainpage = new AmazonMainPage();
		Reporter.addScreenCaptureFromPath(TestUtil.Screenshot());
		mainpage.clicksignin();
		SignPage signpage = new SignPage();
		signpage.EnterUserName();
		Reporter.addScreenCaptureFromPath(TestUtil.Screenshot());
		signpage.clickcontinue();
		signpage.EnterPassword();
		Reporter.addScreenCaptureFromPath(TestUtil.Screenshot());
		signpage.clicklogin();
		Reporter.addScreenCaptureFromPath(TestUtil.Screenshot());

	}

	@Then("^verify home page is displayed$")
	public void verify_home_page_is_displayed() throws FilloException, IOException {
		HomePage homepage = new HomePage();
		String signedinuser = homepage.getloggedinuser();
		Reporter.addScreenCaptureFromPath(TestUtil.Screenshot());
		if (signedinuser.equals("Hello, sakthivel")) {
			Assert.assertTrue(true);
			Reporter.addStepLog("logged in user is correct");
		} else {
			Assert.assertTrue(false);
			Reporter.addStepLog("logged in user is incorrect");
		}

	}

}
