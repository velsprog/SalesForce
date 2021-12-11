package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class S01_23_CreateNewContract extends ProjectSpecificMethods{
	
	@BeforeTest
	public void setValues() {
		testcaseName = "Create new Contract";
		testDescription ="Verify the creation of a new contract";
		authors="Mahalakshmi";
		category ="Smoke";
		excelFileName="CreateContract";
	}
	
	@Test(dataProvider = "fetchData")
	public void createLead(String username, String password,String term) {
		new LoginPage()
		.enterUsername(username)
		.enterPassword(password)
		.clickLogin()
		.verifyHomePage()
		.clickToggleMenu()
		.clickViewAll()
		.clickContracts()
		.clickNewContract()
		.selectAccountName()
		.selectDate()
		.enterContractTerm(term)
		.clickSave()
		.getContractNumber();
}
}
