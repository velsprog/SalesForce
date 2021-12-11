package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.EditCasePage;
import com.salesforce.pages.LoginPage;

public class S0154_EditCase extends ProjectSpecificMethods{
	
	@BeforeTest
	public void setValues() {
		testcaseName = "Edit Case";
		testDescription ="Verify Edit Case Functionality";
		authors="Rohith";
		category ="Functional";
		excelFileName="EditCase";
	}
	
	@Test(dataProvider = "fetchData")
	public void editCase(String username, String password, String SearchCase, String OrginValue, String StatusDropDown, String Expectedtext) throws InterruptedException {
		EditCasePage  Edit = new EditCasePage();
		new LoginPage()
		.enterUsername(username)
		.enterPassword(password)
		.clickLogin()
		.clickToggleMenu()
		.clickViewAll()
		.clickSales()
		.clickMoreTab()
		.navigateToCaseScreen();
		 Edit.searchCase(SearchCase)
		.toolTipClick()
		.clickMorebutton()
		.clickonEdit()
		.selectCaseOrginDropDown()
		.selectCaseOrginDropDownValue(OrginValue)
		.selectStatusDropDown()
		.selectStatusDropDownValue(StatusDropDown)
		.clickSave()
		.verfiyCaseCreated(Expectedtext);
		
	}
}
