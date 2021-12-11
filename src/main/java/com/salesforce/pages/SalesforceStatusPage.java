package com.salesforce.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class SalesforceStatusPage extends ProjectSpecificMethods {

	public SalesforceStatusPage switchSFStatusWindow() {
		switchToWindow(1);
		switchToWindow("Trust Status");
		return this;
	}

	public SalesforceStatusPage clickStatusDropDown() {
		click(locateElement(Locators.XPATH, "//div[@id='dropdown-list']"));
		return this;
	}

	public SalesfoceCompliancePage chooseCompliance() {
		click(locateElement(Locators.XPATH, "//p[contains(text(),'  Compliance')]"));
		return new SalesfoceCompliancePage();
	}
}