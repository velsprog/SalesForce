package com.salesforce.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class ServiceResourcesPage extends ProjectSpecificMethods {

	public ServiceResourcesPage clickShowOneMoreActionDropDown() {
		click(locateElement(Locators.XPATH,
				"//a[contains(@class,'slds-button slds-button--icon-x-small slds-button--icon-border-filled')]"));
		return this;
	}

	public EditServiceResourcesPage clickEditOption() {
		click(locateElement(Locators.XPATH, "//a[@title='Edit']"));
		return new EditServiceResourcesPage();
	}

	public ServiceResourcesPage verifyEditedName(String name) {
		waitForApperance(locateElement(Locators.XPATH,
				"//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
		verifyExactText(
				locateElement(Locators.XPATH,
						"//span[@class='toastMessage slds-text-heading--small forceActionsText']"),
				"Service Resource " + '"' + name + '"' + " was saved.");
		reportStep("Name Edited Successfully.", "pass");
		return this;
	}
}