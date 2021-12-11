package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class S01_43_CreateIndividual extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testcaseName = "Verify Create Individual";
		testDescription = "Verify Create Induvidual functionality with positive data";
		authors = "Subramanian";
		category = "Functional";
		excelFileName = "Individual";
	}

	@Test(dataProvider = "fetchData")
	public void testCreateInduvidual(String userName, String password, String individualName) {
		new LoginPage().enterUsername(userName).enterPassword(password).clickLogin().clickToggleMenu().clickViewAll()
				.clickIndividuals().clickIndividualDropdown().clickNewIndividual().enterLastName(individualName)
				.clickSave().verifyCreateInd(individualName);

	}
}
