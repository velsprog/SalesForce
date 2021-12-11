package com.salesforce.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class OpportunitiesPage extends ProjectSpecificMethods {
	public OpportunitiesPage clickNewButton() { 
		click(locateElement(Locators.XPATH, "//div[text()='New']"));
		reportStep("Successfully clicked the New button", "pass");
		return this;
	}
	
	public OpportunitiesPage enterName(String data) {
		type(locateElement(Locators.XPATH, "//input[@name='Name']"), data);
		reportStep("Successfully enter the text", "pass");
		return this;
	}
	
	public OpportunitiesPage getText() {
		String text=getElementText(locateElement(Locators.XPATH, "//input[@name='Name']"));
		reportStep("Successfully get the text", "pass");
		System.out.println(text);
		return this;
	}
	
	public OpportunitiesPage enterClosedate(String date) {
		type(locateElement(Locators.XPATH, "//input[@name='CloseDate']"), date);
		reportStep("Successfully enter the date", "pass");
		return this;
	}
	
	public OpportunitiesPage enterAmount(String amount) {
		type(locateElement(Locators.XPATH,"//input[@name='Amount']"), amount);
		return this;
	}
		
	public OpportunitiesPage clickStagedropdown() { 
		click(locateElement(Locators.XPATH, "//label[text()='Stage']/following-sibling::div//input"));
		reportStep("Successfully clicked the dropdow", "pass");
		return this;
	}
	
	public OpportunitiesPage clickStage() { 
		click(locateElement(Locators.XPATH, "//lightning-base-combobox-item[@data-value='Needs Analysis']"));
		reportStep("Successfully clicked the Stage as Need Analysis", "pass");
		return this;
	}
	
	public OpportunitiesPage choseType() {
		click(locateElement(Locators.XPATH,"//label[text()='Type']/following-sibling::div//input"));
		click(locateElement(Locators.XPATH,"//lightning-base-combobox-item[@data-value='New Customer']"));
		return this;
	}
	
	public OpportunitiesPage chooseLeadSource() {
		click(locateElement(Locators.XPATH,"//label[text()='Lead Source']/following-sibling::div//input"));
		click(locateElement(Locators.XPATH,"//lightning-base-combobox-item[@data-value='Partner Referral']"));
		return this;
	}

	public OpportunitiesPage choosePrimaryCampaignSource() throws InterruptedException {
		click(locateElement(Locators.XPATH,"//label[text()='Primary Campaign Source']/following-sibling::div//input"));
		click(locateElement(Locators.XPATH,"(//span[@class='slds-listbox__option-text slds-listbox__option-text_entity'])[1]"));		
		return this;
	}
	
	public AccountsPage clickSaveButton() { 
		click(locateElement(Locators.XPATH, "//button[text()='Save']"));
		reportStep("Successfully saved the page", "pass");
		return new AccountsPage();
	}
	
	public OpportunityDetailsPage clickSave() { 
		click(locateElement(Locators.XPATH, "//button[text()='Save']"));
		return new OpportunityDetailsPage();
	}
}