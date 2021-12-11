package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC001_CreateIndividual extends ProjectSpecificMethods{
	@BeforeTest
	public void setValues() {
		testcaseName = "Create Individual";
		testDescription ="Verify the creation of an individual";
		authors="Mahalakshmi";
		category ="Smoke";
		excelFileName="CreateIndi";
	}
	@Test(dataProvider = "fetchData")
	public void createLead(String username, String password,String fn,String ln) {
		new LoginPage()
		.enterUsername(username)
		.enterPassword(password)
		.clickLogin()
		.verifyHomePage()
		.clickToggleMenu()
		.clickViewAll()
		.clickIndividuals()
		.clickNewIndividual()
		.clickSalutationdropdown()
		.clickMr()
		.enterFirstName(fn)
		.enterLastName(ln)
		.clickSave();
	}}