package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.EditCasePage;
import com.salesforce.pages.LoginPage;

public class S0155_DeleteCase extends ProjectSpecificMethods{
	
	@BeforeTest
	public void setValues() {
		testcaseName = "Delete Case";
		testDescription ="Verify Delete Case Functionality";
		authors="Rohith";
		category ="Functional";
		excelFileName="DeleteCase";
	}
	
	@Test(dataProvider = "fetchData")
	public void editCase(String username, String password, String SearchCase,String Expectedtext) throws InterruptedException {
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
		.clickDeleteButton()
		.acceptDeleteButton()
		.verfiyDeleteCase(Expectedtext);
		
	}
}
