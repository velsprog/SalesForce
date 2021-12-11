package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class S0181_EditContact extends ProjectSpecificMethods {
	@BeforeTest
	public void setVaues() {
		testcaseName = "Edit Contact";
		testDescription = "Verify Edit Account functionality with Positive Values";
		authors = "Vels";
		category = "Functional";
		excelFileName = "S0181_EditContact";
	}
	
	@Test(dataProvider = "fetchData")
	public void editContact(String username
						   ,String password
						   ,String contactName
						   ,String title
						   ,String dob
						   ,String leadSource
						   ,String phoneNum) throws InterruptedException {
		new LoginPage()
		.enterUsername(username)
		.enterPassword(password)
		.clickLogin()
		.clickToggleMenu()
		.clickViewAll()
		.clickContacts()
		.entersearchkey(contactName)
		.clickEditForContact(contactName)
		.typeTitle(title)
		.enterDOB(dob)
		.selectLeadSource(leadSource)
		.typePhoneNum(phoneNum)
		.clickSave()
		.verifyContacEdited(contactName);
		
	}

}
