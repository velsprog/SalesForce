package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;


public class S01_67_AdminCertificates extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testcaseName = "VerifyAdminCertificates";
		testDescription = "Verify Create Task functionality with positive data";
		authors = "Subramanian";
		category = "Functional";
	}
	@Test
	public void testAdminCertificates() {
		new LoginPage().enterUsername("fullstack@testleaf.com").enterPassword("SelBootcamp$123").clickLogin()
		.clickLearnMore().verifyMobileAppHomePage().moveToResourceOption().clickSFCerticate().verifyCertificateHomePage().verifyCertificateNames();
	}
}
