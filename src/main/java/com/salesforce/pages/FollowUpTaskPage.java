package com.salesforce.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class FollowUpTaskPage extends ProjectSpecificMethods {

	public FollowUpTaskPage selectAssigned() {
		click(Locators.XPATH, "//span[contains(text(),'Total Task')]");
		reportStep("Select Account Name in Assigned To field Success", "pass");
		return this;
	}

	public FollowUpTaskPage selectSubject() {
		click(Locators.XPATH, "//label[text()='Subject']/following-sibling::div//input");
		reportStep("Click Subject drop down success", "pass");
		click(Locators.XPATH, "//span[@title='Call']");
		reportStep("Select drop down value success", "pass");
		return this;
	}

	public FollowUpTaskPage selectStatus() {
		click(Locators.XPATH, "//span[text()='Status']/parent::span/following-sibling::div");
		reportStep("Click status drop down success", "pass");
		click(Locators.XPATH, "//a[text()='In Progress']");
		reportStep("select status success", "pass");
		return this;
	}

	public FollowUpTaskPage selectContactName() {
		if(!locateElement(Locators.XPATH, "//img[@title='Contacts']").isEnabled()) {
			click(Locators.XPATH, "//span[text()='Name']/parent::label/following-sibling::div//input");
			reportStep("Click Contact drop down", "pass");
			waitForApperance(locateElement(Locators.XPATH, "//div[@class='listContent']//img[@title='Contact']"));
			click(Locators.XPATH, "//div[@class='listContent']//img[@title='Contact']");
			reportStep("select Contact success", "pass");
			System.out.println("contact selected");
		}
		
		return this;
	}

	public FollowUpTaskPage selectRelatedTo() {
		click(Locators.XPATH, "//span[text()='Related To']/parent::label/following-sibling::div//input");
		reportStep("Click related to drop down", "pass");
		waitForApperance(locateElement(Locators.XPATH, "//div[@class='listContent']//img[@title='Account']"));
		click(Locators.XPATH, "//div[@class='listContent']//img[@title='Account']");
		reportStep("Select related to contact success", "pass");
		System.out.println("related To selected");
		return this;
	}

	public FollowUpTaskPage clickSave() {
		click(Locators.XPATH, "//button[@title='Save']");
		return this;
	}

	public HomePage verifyFollowupTaskCreated() {
		waitForApperance(locateElement(Locators.XPATH, "//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
		verifyExactText(locateElement(Locators.XPATH, "//span[@class='toastMessage slds-text-heading--small forceActionsText']"), "Task Call was created.");
		return new HomePage();
	}
}
