package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class SF01_74_NonProfitCertifications extends ProjectSpecificMethods {
	@BeforeTest
	public void setValues() {
		testcaseName = "Non-Profit Certifications";
		testDescription = "Verify total count of Non Profit Certifications";
		authors = "Goutham";
		category = "Functional";
		excelFileName = "Login";
	}
	@Test(dataProvider = "fetchData")
	public void runNonProfitCertifications(String username, String password) throws InterruptedException {
		new LoginPage()
		.enterUsername(username)
		.enterPassword(password)
		.clickLogin()
		.verifyHomePage() 
		.clickSlider()
		.switchSFStatusWindow()
		.clickStatusDropDown()
		.chooseCompliance()
	   .clickShowFilters()
	   .clickNonProfitUnderIndustires()
	   .verifyNumberOfNonProfitCertification()
	   .clickClearFilter();  
	}
}