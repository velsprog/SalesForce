package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;
import com.salesforce.pages.SalesforcePlatformPage;

public class SF01_68_ArchitectCertifications extends ProjectSpecificMethods {
	@BeforeTest
	public void setValues() {
		testcaseName = "Architect Certifications";
		testDescription ="Verify list of Architect Certifications names";
		authors="Goutham";
		category ="Functional";
		excelFileName="Login";
	}
	
	@Test(dataProvider = "fetchData")
	public void runArchitectCertifications(String username, String password) {
		new LoginPage()
		.enterUsername(username)
		.enterPassword(password)
		.clickLogin()
		.verifyHomePage()
		.clickLearnMore();
		new SalesforcePlatformPage()
		.switchSecondWindow()
		.chooseResourcesOption()
		.chooseSalesforceCertification()
		.switchThirdWindow()
		.clickSalesforceArchitect()
		.verifyCertificateNames();
	}
}