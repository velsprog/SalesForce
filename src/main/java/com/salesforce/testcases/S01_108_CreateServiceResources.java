package com.salesforce.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class S01_108_CreateServiceResources extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testcaseName = "CreateServiceResources";
		testDescription = "Verify Create Service Resources name is edited";
		authors = "Goutham";
		category = "Functional";
		excelFileName = "CreateResources";
	}
	
	@Test(dataProvider = "fetchData")
	public void runCreateServiceResources(String username, String password, String name) { 
		new LoginPage()
		.enterUsername(username)
		.enterPassword(password)
		.clickLogin()
		.clickToggleMenu()
		.clickViewAll()
		.clickServiceResources()
		.clickShowOneMoreActionDropDown()
		.clickEditOption()
		.EditName(name)
		.clickSave()
		.verifyEditedName(name);
		assertEquals(name, name);
	}
}