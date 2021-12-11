package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.ContactHomePage;
import com.salesforce.pages.CreateOrEditContactsPage;
import com.salesforce.pages.LoginPage;

public class S0180_CreateContact extends ProjectSpecificMethods {
	
	@BeforeTest
	public void setValues() {
		testcaseName = "Create Contact";
		testDescription = "Verify Create Contact Functionality with Postive Values";
		authors = "Vels";
		category = "Functional";
		excelFileName = "S0180_CreateContact";	
	}
	
	@Test(dataProvider = "fetchData")
	public void createContact(String username
							  ,String password
							  ,String salutation
							  ,String firstName
							  ,String lastName
							  ,String email
							  ,String accountName) {
		((CreateOrEditContactsPage) new LoginPage()
		.enterUsername(username)
		.enterPassword(password)
		.clickLogin()
		.clickGloabalAction()
		.clickNewContact()
		.selectSalution(salutation)
		.typeFirstname(firstName)
		.typeLastname(lastName)
		.typeEmail(email)
		.clickNewAccountFromAccountDropDown()
		.typeAccountName(accountName)
		.clickSave("Contact"))
		.clickSave()
		.verifyContactIsCreated(firstName, lastName);
		
	}

}
