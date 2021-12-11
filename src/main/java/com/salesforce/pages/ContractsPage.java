package com.salesforce.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class ContractsPage extends ProjectSpecificMethods {

	public ContractsPage clickdropdown() {
		click(locateElement(Locators.XPATH, "//div[@class='slds-context-bar__label-action slds-p-left--none slds-p-right--x-small']"));
		reportStep("Clicked on the dropdown", "pass");
		return this;
	}

	public ContractsPage clickNewContract() {
		waitForApperance(locateElement(Locators.XPATH, "//a[@title='New']"));
		click(locateElement(Locators.XPATH, "//a[@title='New']"));
		reportStep("Clicked on New Contract", "pass");
		return this;
	}

	public ContractsPage selectAccountName() {
		click(locateElement(Locators.XPATH, "//input[@title='Search Accounts']"));
		click(locateElement(Locators.XPATH, "//div[@title='Credit2']"));
		reportStep("Selected account name", "pass");
		return this;
	}

	public ContractsPage selectDate() {
		click(locateElement(Locators.XPATH, "//a[@class='datePicker-openIcon display']"));
		click(locateElement(Locators.XPATH, "//button[text()='Today']"));
		reportStep("Selected date", "pass");
		return this;
	}

	public ContractsPage enterContractTerm(String term) {
		type(locateElement(Locators.XPATH,"//input[@class='input uiInputSmartNumber']"),term);
		reportStep("Entered Contract Term", "pass");
		return this;
	}
	public ContractsPage clickSave() {
		click(locateElement(Locators.XPATH, "(//span[text()='Save'])[2]"));
		reportStep("Clicked Save", "pass");
		return this;
	}
	
	public ContractsPage getContractNumber() {
		getElementText(locateElement(Locators.XPATH, "//span[@class='uiOutputText']"));
		reportStep("Get Contract Number", "pass");
		return this;
	}



}
