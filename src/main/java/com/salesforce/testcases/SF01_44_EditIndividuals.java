package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class SF01_44_EditIndividuals extends ProjectSpecificMethods {
	@BeforeTest
	public void setValues() {
		testcaseName = "EditIndividual";
		testDescription ="Verify Edit Indivudual functionality with positive data";
		authors="Goutham";
		category ="Functional";
		excelFileName="EditIndividual";
	}
	
	@Test(dataProvider = "fetchData")
	public void runEditIndividual(String username, String password, String searchValue, String fName,String expectedToastText) throws InterruptedException {
		new LoginPage()
		.enterUsername(username)
		.enterPassword(password)
		.clickLogin()
		.verifyHomePage()
		.clickToggleMenu()
		.clickViewAll()
		.clickIndividuals()
		.verifyIndividualsPage()
		.clickSearchListBox()
		.enterSearchField(searchValue)
		.clickActionsDropdown()
		.chooseEditOption()
		.chooseSalutation()
		.enterFirstName(fName)
		.clickSave()
		.verifyIndividualNameIsEdited(expectedToastText);
	}
}