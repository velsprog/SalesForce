package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.AccountsPage;
import com.salesforce.pages.LoginPage;

public class S0130_EditAccount extends ProjectSpecificMethods {
	
	@BeforeTest
	public void setValues() {
		testcaseName = "Edit Account";
		testDescription ="Verify Existing Account Can be Edited";
		authors="Vels";
		category ="Functional";
		excelFileName="S0130_EditAccount";
	}
	
	@Test(dataProvider = "fetchData")
	public void editAccount(String username, 
			   String password, 
			   String accountName,
			   String type,
			   String industry,
			   String billingAddress,
			   String shippingAddress,
			   String priority,
			   String SLA,
			   String active,
			   String phoneNumber,
			   String oppurtunity) throws InterruptedException {
		
		((AccountsPage) new LoginPage()
		.enterUsername(username)
		.enterPassword(password)
		.clickLogin()
		.clickToggleMenu()
		.clickViewAll()
		.clickSales()
		.clickAccountsTab()
		.entersearchkey(accountName)
		.clickEditForAccount(accountName)
		.selectType(type)
		.selectIndutry(industry)
		.typeBillingAddress(billingAddress)
		.typeShippingAddress(shippingAddress)
		.selectPriority(priority)
		.selectSLA(SLA)
		.selectActive(active)
		.enterPhoneNumber(phoneNumber)
		.selectOpportunity(oppurtunity)
		.clickSave("Accounts"))
		.verifyAccountEdited(accountName)
		.verifyPhoneNumber(phoneNumber);
	}

}
