package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class S0132_SortAccount extends ProjectSpecificMethods {
	
	@BeforeTest
	public void setValues() {
		testcaseName = "Sort Account";
		testDescription ="Verify Accounts are sorted correctly";
		authors="Vels";
		category ="Functional";
		excelFileName="Login";
	}
	
	@Test(dataProvider = "fetchData")
	public void sortAccount(String username, 
			   String password) throws InterruptedException {
		
		new LoginPage()
		.enterUsername(username)
		.enterPassword(password)
		.clickLogin()
		.clickToggleMenu()
		.clickViewAll()
		.clickSales()
		.clickAccountsTab()
		.clickSort()
		.verifySortOrder();
	}

}
