package com.salesforce.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class CreateOrEditServiceTerritoriesHomePage extends ProjectSpecificMethods {
	
	public CreateOrEditServiceTerritoriesHomePage typeName(String name) {
		clearAndType(locateElement(Locators.XPATH, "//span[text()='Name']/parent::label/following-sibling::input"), name);
		reportStep(name + " entered in Name Field Successfully.", "pass");
		return this;
	}

	public CreateOrEditServiceTerritoriesHomePage selectOperatingHours() {
		click(locateElement(Locators.XPATH, "//input[contains(@placeholder,\"Search Operating Hours\")]"));
		click(locateElement(Locators.XPATH,"//div[contains(@class,'uiAbstractList')]//li/a"));
		reportStep("Operating Hours Selected Successfully,", "pass");
		return this;
	}
	
	public CreateOrEditServiceTerritoriesHomePage checkActive() {
		click(locateElement(Locators.XPATH,"//span[text()='Active']/parent::label/following-sibling::input[@type='checkbox']"));
		reportStep("Active checkbox Checked.", "pass");
		return this;
	}
	
	public CreateOrEditServiceTerritoriesHomePage typeCity(String city) {
		clearAndType(locateElement(Locators.XPATH, "//input[@placeholder='City']"), city);
		reportStep(city + " entered in City Field Successfully.", "pass");
		return this;
	}
	
	public CreateOrEditServiceTerritoriesHomePage typeState(String state) {
		clearAndType(locateElement(Locators.XPATH, "//input[@placeholder='State/Province']"), state);
		reportStep(state + " entered in State Field Successfully.", "pass");
		return this;
	}
	
	public CreateOrEditServiceTerritoriesHomePage typeCountry(String country) {
		clearAndType(locateElement(Locators.XPATH, "//input[@placeholder='Country']"), country);
		reportStep(country + " entered in Country Field Successfully.", "pass");
		return this;
	}
	
	public CreateOrEditServiceTerritoriesHomePage typeZipcode(String zipcode) {
		clearAndType(locateElement(Locators.XPATH, "//input[contains(@placeholder,'Postal Code')]"), zipcode);
		reportStep(zipcode + " entered in Postal Code Field Successfully.", "pass");
		return this;
	}
	
	public ServiceTerritoriesHomePage clickSave() {
		click(locateElement(Locators.XPATH,"//button[@title='Save']"));
		reportStep("Page Saved Successfully.", "pass");
		return new ServiceTerritoriesHomePage();
	}	
}
