package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.AccountsPage;
import com.salesforce.pages.AutowiredPages;
import com.salesforce.pages.LoginPage;

public class S0129_CreateNewAccount extends ProjectSpecificMethods {
	
	@BeforeTest
	public void setValues() {
		testcaseName = "Create Account";
		testDescription ="Verify New Account Creation Functionality with Posite Data";
		authors="Vels";
		category ="Functional";
		excelFileName="S0129_CreateAccount";
	}
	
	@Test(dataProvider = "fetchData")
	public void createAccount(String username, String password, String accountName, String ownership) {
		
		((AccountsPage) loginpage
		.enterUsername(username)
		.enterPassword(password)
		.clickLogin()
		.clickToggleMenu()
		.clickViewAll()
		.clickSales()
		.clickAccountsTab()
		.clickNewButton()
		.typeAccountName(accountName)
		.selectOwnership(ownership)
		.clickSave("Accounts"))
		.verifyAccountCreated(accountName);
	}

}
