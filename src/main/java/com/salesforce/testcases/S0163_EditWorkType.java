package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class S0163_EditWorkType extends ProjectSpecificMethods {

		@BeforeTest
		public void setValues() {
			testcaseName = "VerifyCreatWorkTypes";
			testDescription ="Verify CreateWorkType";
			authors="Manikandan";
			category ="functional";
			excelFileName="CreateNewWorkType";
		}
		
		@Test(dataProvider = "fetchData")
		public void editWorkType(String username,String password,String timeFrameStart,String timeFrameEnd) {
			new LoginPage()
			.enterUsername(username)
			.enterPassword(password)
			.clickLogin()
			.clickToggleMenu()
			.clickViewAll()
			.clickworkType()
			.editWorkType()
			.changetheStartTime(timeFrameStart)
			.changetheEndTime(timeFrameEnd)
			.clickSave()
			.verifyEditMessage();
		}
}
