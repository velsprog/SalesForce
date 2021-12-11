package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class S0161_CreateNewWorkType extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testcaseName = "VerifyCreatWorkTypes";
		testDescription ="Verify CreateWorkType";
		authors="Manikandan";
		category ="functional";
		excelFileName="CreateNewWorkType";
	}
	
	@Test(dataProvider = "fetchData")
	public void createWorkType(String username,String password,String workTypeName,String description,String operatingHours,String duration) {
		new LoginPage()
		.enterUsername(username)
		.enterPassword(password)
		.clickLogin()
		.clickToggleMenu()
		.clickViewAll()
		.clickworkType()
		.clickOnNewButton()
		.enterWorkTypeName(workTypeName)
		.enterDesriptionName(description)
		.clickSearchOperatingHours()
		.clicknewOperatingHours()
		.enternewOperatingHoursDescription(operatingHours)
		.clicknewTimeZone()
		.selectTimeZone()
		.saveNewOperatingHours()
		.enterEstimatedDuration(duration)
		.clickSave()
		.verifyCreatedMessage();
		
	}
}


