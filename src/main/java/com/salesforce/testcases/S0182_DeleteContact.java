package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class S0182_DeleteContact extends ProjectSpecificMethods {
	@BeforeTest
	public void setVaues() {
		testcaseName = "Delete Contact";
		testDescription = "Verify Delete Account functionality with Positive Values";
		authors = "Vels";
		category = "Functional";
		excelFileName = "S0182_DeleteContact";
	}
	
	@Test(dataProvider = "fetchData")
	public void editContact(String username
						   ,String password
						   ,String contactName) throws InterruptedException {
		new LoginPage()
		.enterUsername(username)
		.enterPassword(password)
		.clickLogin()
		.clickToggleMenu()
		.clickViewAll()
		.clickContacts()
		.entersearchkey(contactName)
		.clickDeleteForContact(contactName)
		.verifyContactDeleted(contactName);
		
	}

}
