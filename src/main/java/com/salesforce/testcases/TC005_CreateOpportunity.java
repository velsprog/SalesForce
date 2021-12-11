package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC005_CreateOpportunity extends ProjectSpecificMethods {
	@BeforeTest
	public void setValues() {
		testcaseName = "CreateOpportunity";
		testDescription = "Verify Create Opportunity functionality with positive data";
		authors = "Goutham";
		category = "Functional";
		excelFileName = "CreateOpportunityViaContent";
	}

	@Test(dataProvider = "fetchData")
	public void runCreateOpportunity(String username, String password, String data, String date, String amount) {
		new LoginPage()
		.enterUsername(username)
		.enterPassword(password)
		.clickLogin()
		.verifyHomePage()
		.clickToggleMenu()
		.clickViewAll()
		.clickContent()
		.verifyContentHomePage()
		.clickViewAllKeyDeals()
		.clickOpportunitiesDropdown()
		.chooseAllOpportunities();
	}
}