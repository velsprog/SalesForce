package com.salesforce.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class TaskWindow extends ProjectSpecificMethods {

	public TaskWindow enterSubName(String subjectName) {
		clearAndType(locateElement(Locators.XPATH,"//label[text()='Subject']/following-sibling::div//input"), subjectName);
		return this;
	}
	
	public TaskWindow selectContact() {
		click(Locators.XPATH, "//span[text()='Name']/parent::label/following-sibling::div//input");
		click(Locators.XPATH, "//div[@class='listContent']//img[@title='Contact']");
		reportStep("Contact selected successfully", "pass");
		return this;
	}

	public TaskWindow selectStatus() {
		// Select status as 'Waiting on someone else'
		click(Locators.XPATH, "//span[text()='Status']/parent::span/following-sibling::div");
		click(Locators.XPATH, "//a[text()='Waiting on someone else']");
		reportStep("status selected successfully", "pass");
		return this;
	}

	public TaskWindow clickSave() {
		click(Locators.XPATH, "//button[@title='Save']");
		reportStep("click svae button success", "pass");
		return this;
	}

	public TaskWindow enterDate(String today) {
		clearAndType(locateElement(Locators.XPATH, "//label[text()='Due Date']/parent::div//input"), today);
		reportStep("Enter date successfully", "pass");
		return this;
	}

	public TaskWindow enterPriority() {
		click(Locators.XPATH, "//span[text()='Priority']/parent::span/following-sibling::div");
		click(Locators.XPATH, "//a[text()='Low']");
		reportStep("Select priority as low", "pass");
		return this;
	}

	public TaskWindow enterDescription() {
		clearAndType(locateElement(Locators.XPATH, "//textarea"), "SALES FORCE Automation Using Selenium");
		reportStep("Description entered successfully", "pass");
		return this;
	}

	public HomePage verifyTaskCreated(String subjectName) {
		waitForApperance(locateElement(Locators.XPATH, "//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
		verifyExactText(locateElement(Locators.XPATH, "//span[@class='toastMessage slds-text-heading--small forceActionsText']"), "Task " + subjectName + " was created.");
		reportStep("Verify task created success", "pass");
		return new HomePage();
	}

	public HomePage verifyTaskEdit() {
		String expSuccessMessage = "Task " + '"' + "Bootcamp" + '"' + " was saved.";
		waitForApperance(locateElement(Locators.XPATH, "//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
		verifyExactText(locateElement(Locators.XPATH, "//span[@class='toastMessage slds-text-heading--small forceActionsText']"), expSuccessMessage);
		reportStep("Verify task Edit success", "pass");
		return new HomePage();
	}

	public HomePage verifyTaskDelete() {
		String expSuccessMessage = "Task " + '"' + "Bootcamp" + '"' + " was deleted. Undo";
		waitForApperance(locateElement(Locators.XPATH, "//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
		verifyExactText(locateElement(Locators.XPATH, "//span[@class='toastMessage slds-text-heading--small forceActionsText']"), expSuccessMessage);
		reportStep("Verify task Deleted success", "pass");
		return new HomePage();
	}

	public TaskWindow verifyMandatoryAlert() {
		String expectedSuccessMessage = "Complete this field.";
		waitForApperance(locateElement(Locators.XPATH, "//div[text()='Complete this field.']"));
		verifyExactText(locateElement(Locators.XPATH, "//div[text()='Complete this field.']"), expectedSuccessMessage);
		reportStep("Verify mandatory alert success", "pass");
		return this;
	}

}
