package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;


public class S01_33_CreateLegalEntity extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testcaseName = "VerifyCreateTask";
		testDescription = "Verify Create Task functionality with positive data";
		authors = "Subramanian";
		category = "Smoke";
		excelFileName = "LegalEntity";
	}
	@Test(dataProvider = "fetchData")
	public void testCreateLegalEntity(String LegaEntityName) {
		new LoginPage().enterUsername("fullstack@testleaf.com").enterPassword("SelBootcamp$123").clickLogin()
		.clickToggleMenu().clickViewAll().clickLegalEntity().clickLegalEntityDropdown().clickNewLegalEntity()
				.enterLegalEntityName(LegaEntityName).clickSave().verifyLegalEntityCreated(LegaEntityName);
	}
}
