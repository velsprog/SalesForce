package com.salesforce.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class ServiceHomePage extends ProjectSpecificMethods {
	
	public ReportsHomePage clickReports() {
		clickUsingJs(locateElement(Locators.XPATH, "//span[text()='Reports']"));
		reportStep("Report menu clicked successfully.", "Pass");
		return new ReportsHomePage();
	}

}
