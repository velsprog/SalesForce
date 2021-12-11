package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC003_DeleteIndividual extends ProjectSpecificMethods{
	@BeforeTest
	public void setValues() {
		testcaseName = "Delete Individual";
		testDescription ="Verify the delete feature of an individual";
		authors="Mahalakshmi";
		category ="Smoke";
		excelFileName="DeleteIndi";
	}
	@Test(dataProvider = "fetchData")
	public void editIndi(String username, String password,String ln) {
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
		.selectDeleteOption()
		.confirmDelete();
	
	}
}
