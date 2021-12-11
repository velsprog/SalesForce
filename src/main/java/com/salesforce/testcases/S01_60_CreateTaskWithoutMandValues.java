package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class S01_60_CreateTaskWithoutMandValues extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testcaseName = "VerifyCreateTask Without mandatory field";
		testDescription = "Verify Create Task functionality without mandatory data";
		authors = "Subramanian";
		category = "Functional";
	}

	@Test
	public void runCreateTaskwithoutManatory() {
		new LoginPage().enterUsername("fullstack@testleaf.com").enterPassword("SelBootcamp$123").clickLogin()
				.clickToggleMenu().clickViewAll().clickSales().clickTaskDropdown().clickNewTask().selectContact().enterDescription()
				.clickSave().verifyMandatoryAlert();
	}
}
