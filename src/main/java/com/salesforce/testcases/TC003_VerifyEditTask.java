package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC003_VerifyEditTask extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testcaseName = "VerifyEditTask";
		testDescription = "Verify Edit Task functionality with positive data";
		authors = "Subramanian";
		category = "Smoke";
		excelFileName = "EditTask";
	}

	@Test(dataProvider = "fetchData")
	public void runEditTaskf(String today) throws InterruptedException {
		new LoginPage().enterUsername("fullstack@testleaf.com").enterPassword("SelBootcamp$123").clickLogin()
				.clickToggleMenu().clickViewAll().clickSales().clickTaskTab().clickRecentViewedDrop()
				.clickRecentlyViewed().changeDisplayTypeTable().clickEditButton().enterDate(today).enterPriority()
				.clickSave().verifyTaskEdit();

	}
}
