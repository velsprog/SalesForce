package com.salesforce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class ServiceTerritoriesHomePage extends ProjectSpecificMethods {
	
	public CreateOrEditServiceTerritoriesHomePage clickNew() {
		click(locateElement(Locators.XPATH, "//a[@title='New']"));
		return new CreateOrEditServiceTerritoriesHomePage();
	}
	
	public void verifyServiceTerritoryIsCreated(String name) {
		getWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[contains(@class,'toastMessage')]"), name));
		verifyExactText(locateElement(Locators.XPATH, "//span[contains(@class,'toastMessage')]"), "Service Territory \""+name+"\" was created.");
		reportStep("Service Territory Created Successfully.", "pass");	
	}

}
