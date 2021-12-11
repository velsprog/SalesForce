package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class S0131_DeleteAccount extends ProjectSpecificMethods {
	
	@BeforeTest
	public void setValues() {
		testcaseName = "Delete Account";
		testDescription ="Verify Existing Account Can be Deleted";
		authors="Vels";
		category ="Functional";
		excelFileName="S0131_DeleteAccount";
	}
	
	@Test(dataProvider = "fetchData")
	public void deleteAccount(String username, 
			   String password, 
			   String accountName) throws InterruptedException {
		
		new LoginPage()
		.enterUsername(username)
		.enterPassword(password)
		.clickLogin()
		.clickToggleMenu()
		.clickViewAll()
		.clickSales()
		.clickAccountsTab()
		.entersearchkey(accountName)
		.clickDeleteForAccount(accountName)
		.verifyDeleteToastMessage(accountName)
		.verifyAccountIsDeleted(accountName);
	}

}
