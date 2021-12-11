package com.salesforce.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class EditServiceResourcesPage extends ProjectSpecificMethods {
	
	public EditServiceResourcesPage EditName(String name) {
		clearAndType(locateElement(Locators.XPATH,"//input[@class=' input']"), name);
		return this;
	}
	
	public ServiceResourcesPage clickSave() {
		click(locateElement(Locators.XPATH,"(//span[text()='Save'])[2]"));
		return new ServiceResourcesPage();
	}
}