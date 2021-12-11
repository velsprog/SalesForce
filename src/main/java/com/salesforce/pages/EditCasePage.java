package com.salesforce.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class EditCasePage extends ProjectSpecificMethods {
	
	public EditCasePage searchCase(String SearchCase) throws InterruptedException {
		clearAndType(locateElement(Locators.XPATH,"//input[@placeholder='Search this list...']"),SearchCase);
		return this;
	}
	
	public EditCasePage toolTipClick() throws InterruptedException {
		click(Locators.XPATH,"//div[@role='tooltip']");
		return this;
	}
	
	public CreateCasePage clickMorebutton() throws InterruptedException {
		click(Locators.XPATH,"//span[@class='slds-icon_container slds-icon-utility-down']");
		return new CreateCasePage();
	}
	
}
