package com.salesforce.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class WorkTypesPage extends ProjectSpecificMethods {
	
	public WorkTypesPage verifyWorkTypesPage() {
		verifyDisplayed(locateElement(Locators.XPATH, "//span[text()='Work Types']"));
		return this;
	}
}