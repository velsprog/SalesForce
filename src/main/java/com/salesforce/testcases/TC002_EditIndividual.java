package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC002_EditIndividual extends ProjectSpecificMethods {
	@BeforeTest
	public void setValues() {
		testcaseName = "Edit Individual";
		testDescription ="Verify the edit feature of an individual";
		authors="Mahalakshmi";
		category ="Smoke";
		excelFileName="EditDeleteIndi";
	}
	@Test(dataProvider = "fetchData")
	public void editIndi(String username, String password,String ln,String fn) {
		new LoginPage()
		.enterUsername(username)
		.enterPassword(password)
		.clickLogin()
		.verifyHomePage()
		.clickToggleMenu()
		.clickViewAll()
		.clickIndividuals()
		.searchAnIndividual(ln)
		.clickOptions()
		.selectEditOption()
		.enterFirstName(fn)
		.clickSave();
	}
}
