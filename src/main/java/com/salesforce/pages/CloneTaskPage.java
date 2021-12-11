package com.salesforce.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class CloneTaskPage extends ProjectSpecificMethods {

	public CloneTaskPage enterListName() {
		clearAndType(locateElement(Locators.XPATH, "//label[text()='List Name']/following-sibling::div/input"), "New open tasks");
		reportStep("Click clone button success", "pass");
		return new CloneTaskPage();
	}
	
	public CloneTaskPage enterListAPIName() {
		clearAndType(locateElement(Locators.XPATH, "//label[text()='List API Name']/following-sibling::div/input"), "New_open_tasks");
		reportStep("Click clone button success", "pass");
		return new CloneTaskPage();
	}
	
	public CloneTaskPage selectAllUsersCanSee() {
		click(Locators.XPATH, "//span[contains(text(),'All users')]/preceding-sibling::span");
		reportStep("click All users can view check box success", "pass");
		return this;
		//h2[text()='Clone List View']/parent::div//following-sibling::div
	}
	
	public CloneTaskPage clickSave() {
		click(Locators.XPATH, "//div[@class='modal-footer slds-modal__footer']//span[text()='Save']");
		reportStep("Click Save Success", "pass");
		return this;
	}
	
}
