package com.salesforce.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class IndividualsPage extends ProjectSpecificMethods {

	public IndividualsPage verifyIndividualsPage() {
		verifyDisplayed(locateElement(Locators.XPATH, "//span[text()='Individuals']"));
		return this;
	}

	public IndividualsPage clickSearchListBox() {
		click(locateElement(Locators.XPATH, "//input[@class='slds-input']"));
		return this;
	}

	public IndividualsPage enterSearchField(String searchValue) {
		typeAndEnter(locateElement(Locators.XPATH, "//input[@class='slds-input']"), searchValue);
		return this;
	}

	public IndividualsPage clickActionsDropdown() throws InterruptedException {
		Thread.sleep(3000);
		click(locateElement(Locators.XPATH, "//a[contains(@class,'slds-button slds-button--icon-x-small')]"));
		return this;
	}

	public EditIndividualPage chooseEditOption() {
		click(locateElement(Locators.XPATH, "//a[@title='Edit']"));
		return new EditIndividualPage();
	}

	public IndividualsPage verifyIndividualNameIsEdited(String expectedToastText) {
		verifyPartialText(locateElement(Locators.XPATH,
				"//span[@class='toastMessage slds-text-heading--small forceActionsText']"), expectedToastText);
		reportStep("Individual was saved", "pass");
		return this;
	}

	/**
	 * 4.Click on the Dropdown icon in the Individuals tab
	 * 
	 * @return
	 */
	public IndividualsPage clickIndividualDropdown() {
		click(Locators.XPATH, "//a[contains(@title,'Individuals')]/following-sibling::one-app-nav-bar-item-dropdown");
		reportStep("Click individual dropdown success", "pass");
		return this;
	}

	/**
	 * 5. Click on New Individual
	 * 
	 * @return
	 */
	public IndividualsPage clickNewIndividual() {
		clickUsingJs(locateElement(Locators.XPATH, "//span[text()='New Individual']"));
		reportStep("Click New individual Success", "pass");
		return this;
	}

	/**
	 * //6. Enter the Last Name as 'Kumar'
	 * 
	 * @param indLastName
	 * @return
	 */
	public IndividualsPage enterLastName(String indLastName) {
		clearAndType(locateElement(Locators.XPATH, "//input[@placeholder='Last Name']"), indLastName);
		reportStep("Individual last name entered successfully", "pass");
		return this;
	}

	/**
	 * click Save button in Individual page
	 * 
	 * @return
	 */
	public IndividualsPage clickSave() {
		click(Locators.XPATH, "//button[@title='Save']");
		reportStep("click Save button success", "pass");
		return this;
	}

	/**
	 * Verify individual Created
	 * 
	 * @param individualName
	 * @return
	 */
	public IndividualsPage verifyCreateInd(String individualName) {
		waitForApperance(locateElement(Locators.XPATH,
				"//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
		verifyExactText(
				locateElement(Locators.XPATH,
						"//span[@class='toastMessage slds-text-heading--small forceActionsText']"),
				"Individual " + '"' + individualName + '"' + " was created.");
		reportStep("click Save button success", "pass");
		return this;
	}

	public IndividualsPage searchAnIndividual(String name) {
		typeAndEnter(locateElement(Locators.XPATH, "//input[@class='slds-input' and @name='Individual-search-input']"),
				name);
		reportStep("Individual searched successfully", "pass");
		return this;
	}

	public IndividualsPage selectEditOption() {
		click(locateElement(Locators.XPATH, "//a[@title='Edit']"));
		reportStep("Clicked on Edit individual option", "pass");
		return this;
	}

	public IndividualsPage selectDeleteOption() {
		click(locateElement(Locators.XPATH, "//a[@title='Delete']"));
		reportStep("Clicked on Edit individual option", "pass");
		return this;
	}

	public IndividualsPage clickOptions() {
		click(locateElement(Locators.XPATH, "//span[@class='slds-icon_container slds-icon-utility-down']//span[1]"));
		reportStep("Clicked on options menu in individuals result", "pass");
		return this;
	}

	public IndividualsPage clickSalutationdropdown() {
		click(locateElement(Locators.XPATH, "//a[@class='select']"));
		reportStep("Clicked on salutation dropdown", "pass");
		return this;
	}

	public IndividualsPage clickMr() {
		click(locateElement(Locators.XPATH, "//a[@title='Mr.']"));
		reportStep("Selected the option Mr.", "pass");
		return this;
	}

	public IndividualsPage enterFirstName(String fname) {
		type(locateElement(Locators.XPATH, "//input[contains(@class,'firstName')]"), fname);
		reportStep("Entered firstname in the dailog", "pass");
		return this;
	}

	public IndividualsPage confirmDelete() {
		click(locateElement(Locators.XPATH, "//button[@title='Delete']//span[1]"));
		reportStep("Clicked on Save confirm button", "pass");
		return this;
	}
}