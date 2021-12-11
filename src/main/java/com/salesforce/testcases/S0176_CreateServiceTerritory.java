package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class S0176_CreateServiceTerritory extends ProjectSpecificMethods {
	@BeforeTest
	public void setValues() {
		testcaseName = "Create Service Territory";
		testDescription = "Create Service Territory functionality with positive values";
		authors = "Vels";
		category = "Functional";
		excelFileName = "S0176_CreateServiceTerritory";
	}
	
	@Test(dataProvider="fetchData")
	public void createServiceTerritory(String username,
									   String password,
									   String name,
									   String city,
									   String state,
									   String country,
									   String zipcode) {
		new LoginPage()
		.enterUsername(username)
		.enterPassword(password)
		.clickLogin()
		.clickToggleMenu()
		.clickViewAll()
		.clickServiceTerritories()
		.clickNew()
		.typeName(name)
		.selectOperatingHours()
		.checkActive()
		.typeCity(city)
		.typeState(state)
		.typeCountry(country)
		.typeZipcode(zipcode)
		.clickSave()
		.verifyServiceTerritoryIsCreated(name);
	}

}
