package com.qa.StepDefinations;

import com.cucumber.listener.Reporter;

import com.qa.Utilities.TestBase;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooksteps extends TestBase {

	@Before
	public void beforeScenario(Scenario scenario) {
		Reporter.assignAuthor("Sakthivel");
		TestCaseID = scenario.getName().toString().substring(0, scenario.getName().toString().indexOf(":"));

	}

	@After()
	public void teardown() {
		// close browser
		System.out.println("Test Completed");
		driver.quit();
	}

}
