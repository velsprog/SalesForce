package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.framework.testng.api.base.RetryEngine;
import com.salesforce.pages.CreateOrEditAccountsPage;
import com.salesforce.pages.LoginPage;

public class S01111_SalesForceClassicNewAccount extends ProjectSpecificMethods {
	@BeforeTest
	public void setValues() {
		testcaseName = "Create SalesForce Classic New Account";
		testDescription = "Create SalesForce Classic New Account functionality validation with positive values";
		authors = "Vels";
		category = "Functional";
		excelFileName = "S01111_SalesForceClassicNewAccount";
	}
	
	@Test(dataProvider="fetchData", retryAnalyzer = RetryEngine.class)
	public void createSalesForceClassicNewAccount(String username,
									   String password,
									   String accountName,
									   String billingAddress) {
		((CreateOrEditAccountsPage)new LoginPage()
		.enterUsername(username)
		.enterPassword(password)
		.clickLogin()
		.clickViewProfile()
		.clickSwitchToClassicLink()
		.clickAllTabs()
		.clickAccountsTab()
		.clickNewButton()
		.typeAccountName(accountName)
		.typeBillingAddress(billingAddress)
		.clickCopyBillingAddrToShippingAddr()
		.selectSLAExpirationDate()
		.clickSave(""))
		.verifyAccountIsCreated(accountName)
		.clickAllTabs()
		.clickAccountsTab()
		.verifyAccountIsCreatedInAccountsTab(accountName)
		.switchToLightningExperience();
		
		
		
	}

}
