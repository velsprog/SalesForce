package com.salesforce.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class LegalEntityPage extends ProjectSpecificMethods {
	
	public LegalEntityPage clickLegalEntityDropdown() {
		click(Locators.XPATH, "//a[contains(@title,'Legal')]/following-sibling::one-app-nav-bar-item-dropdown");
		reportStep("Click Legal Entity dropdown success","pass");
		return this;
	}
	
	public LegalEntityPage clickNewLegalEntity() {
		clickUsingJs(locateElement(Locators.XPATH, "//span[text()='New Legal Entity']"));
		reportStep("Click New Legal Entity success","pass");
		return this;
		
	}

	public LegalEntityPage enterLegalEntityName(String legalEntityName) {
		clearAndType(locateElement(Locators.XPATH, "//span[text()='Name']/parent::label/following-sibling::input"),
				legalEntityName);
		reportStep("Entered Legal entity name as "+legalEntityName+" Successfully", "pass");
		return this;
	}

	public LegalEntityPage clickSave() {
		click(Locators.XPATH, "//button[@title='Save']");
		reportStep("Click Save Button Success", "pass");
		return this;
	}

	public HomePage verifyLegalEntityCreated(String legalEntityName) {
		waitForApperance(locateElement(Locators.XPATH,
				"//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
		verifyExactText(
				locateElement(Locators.XPATH,
						"//span[@class='toastMessage slds-text-heading--small forceActionsText']"),
				"Legal Entity " + '"' + legalEntityName + '"' + " was created.");
		reportStep("Legal Entity " + '"' + legalEntityName + '"' + " was created.", "pass");
		return new HomePage();
	}

}
