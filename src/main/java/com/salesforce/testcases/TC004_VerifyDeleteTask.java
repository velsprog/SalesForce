package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC004_VerifyDeleteTask extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testcaseName = "VerifyDeleteTask";
		testDescription = "Verify Delete Task functionality with positive data";
		authors = "Subramanian";
		category = "Smoke";
	}

	@Test
	public void runDeleteTask() throws InterruptedException {
		new LoginPage().enterUsername("fullstack@testleaf.com").enterPassword("SelBootcamp$123").clickLogin()
				.clickToggleMenu().clickViewAll().clickSales().clickTaskTab().clickRecentViewedDrop()
				.clickRecentlyViewed().changeDisplayTypeTable().clickDeleteButton().verifyTaskDelete();
	}
}
