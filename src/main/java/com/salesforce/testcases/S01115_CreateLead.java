package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class S01115_CreateLead extends  ProjectSpecificMethods{

	@BeforeTest
	public void setValues() {
		testcaseName = "Create Lead";
		testDescription ="Verify Create Lead Functionality";
		authors="Manikandan";
		category ="Functional";
		excelFileName="CreateNewLead";
	}
	
	
	@Test(dataProvider = "fetchData")
	public void createLead(String username,String password,String salutation,String enterLastName,String enterCompanyName) {
		new LoginPage()
		.enterUsername(username)
		.enterPassword(password)
		.clickLogin()
		.clickToggleMenu()
		.clickViewAll()
		.clickSales()
		.clickLeadsTab()
		.clickNewButton()
		.selectSalutation(salutation)
		.clickAndEnterlastName(enterLastName)
		.clickAndEnterCompanyName(enterCompanyName)
		.clickSaveNewLead()
		.verifyCreatedMessage();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

