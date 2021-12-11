package com.salesforce.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class CreateCasePage extends ProjectSpecificMethods{

	public CreateCasePage verifyCasePage() {
		verifyDisplayed(locateElement(Locators.XPATH, "//li[@class='slds-breadcrumb__item slds-line-height--reset']//span[text()='Cases']"));
		reportStep("CasePage is loaded", "pass");
		return this;
	}
	
	public CreateCasePage clickNewButton() throws InterruptedException {
		click(Locators.XPATH,"//div[@title='New']");
		reportStep("Create Case New Button Clicked Successfully","pass");
		return this;
	}
	
	public CreateCasePage contactNameSearch(String SearchText) throws InterruptedException {
		clearAndType(locateElement(Locators.XPATH,"//div[@class='autocompleteWrapper slds-grow']//input[@placeholder='Search Contacts...']"),SearchText);
		return this;
	}
	
	public CreateCasePage selectContactName(String SelectText) throws InterruptedException {
		click(Locators.XPATH,"//div[@title='"+SelectText+"']");
		return this;
	}
	
	public CreateCasePage selectCaseOrginDropDown() {
		click(Locators.XPATH,"(//span[text()='Case Origin']//following::a[@class='select'])[1]");
		return this;
	}
	public CreateCasePage selectCaseOrginDropDownValue(String OrginValue) {
		click(Locators.XPATH,"//a[text()='"+OrginValue+"']");
		return this;
	}
	public CreateCasePage selectStatusDropDown() {
		click(Locators.XPATH,"//label[text()='Status']//following::div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click']");
		return this;
	}
	
	public CreateCasePage selectStatusDropDownValue(String StatusDropDown) throws InterruptedException {

		click(Locators.XPATH,"//lightning-base-combobox-item[@data-value='"+ StatusDropDown +"']");
		return this;
	}
	
	public VerifyCaseHomePage clickSave() throws InterruptedException {

		click(Locators.XPATH,"//button[@title='Save']");
		return new VerifyCaseHomePage();
	}
	
	public CreateCasePage clickonEdit() throws InterruptedException {
		click(Locators.XPATH,"//a[@title='Edit']");
		reportStep("successfully clicked the Edit button", "pass");
		return this;
	}

	public CreateCasePage clickDeleteButton() throws InterruptedException {
		click(Locators.XPATH,"//a[@title='Delete']");
		return this;
	}
		
	public VerifyCaseHomePage acceptDeleteButton() throws InterruptedException {
		click(Locators.XPATH,"//Span[text()='Delete']");
		return new VerifyCaseHomePage();

}

	public CreateCasePage navigateToCaseScreen() throws InterruptedException {
		locateElement(Locators.XPATH, "//a[@role='menuitem']//span[text()='Cases']");
		reportStep("Create Case Screen Displayed Successfully","pass");
		return this;
	}
	
	public CreateCasePage ClickNewButton() throws InterruptedException {
		locateElement(Locators.XPATH,"//div[@title='New']").click();
		waitForApperance(locateElement(Locators.XPATH,"//div[@title='New']"));
		reportStep("Create Case New Button Clicked Successfully","pass");
		return this;
	}
}
