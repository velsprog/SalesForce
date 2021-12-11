package com.salesforce.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class OpportunityDetailsPage extends ProjectSpecificMethods {

	public void verifyOpportunityCreated(String opportunityName) {
		verifyPartialText(locateElement(Locators.XPATH,
				"//span[@class='toastMessage slds-text-heading--small forceActionsText']"), opportunityName);
		reportStep("Opportunity was created", "pass");
	}
}