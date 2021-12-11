package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class S0153_CreateCasePage extends ProjectSpecificMethods{
	
	@BeforeTest
	public void setValues() {
		testcaseName = "Create Case";
		testDescription ="Verify Creation Of New Case Functionality";
		authors="Rohith";
		category ="Functional";
		excelFileName="CreateCase";
	}
	
	@Test(dataProvider = "fetchData")
	public void createNewCase(String username, String password, String SearchText, String SelectText, String OrginValue, String StatusDropDown, String Expectedtext ) throws InterruptedException {
		
		new LoginPage()
		.enterUsername(username)
		.enterPassword(password)
		.clickLogin()
		.clickToggleMenu()
		.clickViewAll()
		.clickSales()
		.clickMoreTab()
		.navigateToCaseScreen()
		.verifyCasePage()
		.clickNewButton()
		.contactNameSearch(SearchText)
		.selectContactName(SelectText)
		.selectCaseOrginDropDown()
		.selectCaseOrginDropDownValue(OrginValue)
		.selectStatusDropDown()
		.selectStatusDropDownValue(StatusDropDown)
		.clickSave()
		.verfiyCaseCreated(Expectedtext);
	}
}
