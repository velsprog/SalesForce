package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC002_VerifyCreateTask extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testcaseName = "VerifyCreateTask";
		testDescription = "Verify Create Task functionality with positive data";
		authors = "Subramanian";
		category = "Smoke";
		excelFileName = "CreateTask";
	}

	@Test(dataProvider = "fetchData")
	public void runCreateTaskf(String subName) {
		new LoginPage().enterUsername("fullstack@testleaf.com").enterPassword("SelBootcamp$123").clickLogin()
				.clickToggleMenu().clickViewAll().clickSales().clickTaskDropdown().clickNewTask().enterSubName(subName)
				.selectContact().selectStatus().clickSave().verifyTaskCreated(subName);

	}
}
