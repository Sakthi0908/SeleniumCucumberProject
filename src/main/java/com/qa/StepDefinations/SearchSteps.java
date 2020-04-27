package com.qa.StepDefinations;

import java.io.IOException;

import org.junit.Assert;


import com.cucumber.listener.Reporter;
import com.qa.Pages.HomePage;
import com.qa.Utilities.TestBase;
import com.qa.Utilities.TestUtil;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchSteps extends TestBase {
	HomePage homepage;
	

	
	@When("^user searches on product using \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_searches_on_product_using_and(String TCNo, String DatasheetName) throws IOException {
		
		HomePage homepage=new HomePage();
		String search_Val=TestUtil.ReadExceldata(DatasheetName, TCNo, "Search_Value");
		System.out.println(search_Val);
		homepage.EnterText(search_Val);
		Reporter.addScreenCaptureFromPath(TestUtil.Screenshot());
		homepage.clicksearch();
		
	  
	}

	@Then("^verify that product page is displayed$")
	public void verify_that_product_page_is_displayed() throws IOException{
		HomePage homepage=new HomePage();
		boolean status=homepage.productdisplayed();
		Reporter.addScreenCaptureFromPath(TestUtil.Screenshot());
		if(status) {
			Assert.assertTrue(status);
			Reporter.addStepLog("Product is displayed");
		}else {
			Assert.assertTrue(status);
			Reporter.addStepLog("Product is not displayed");
		}

	}

}
