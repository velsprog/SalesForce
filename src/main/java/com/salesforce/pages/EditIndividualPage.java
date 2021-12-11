package com.salesforce.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class EditIndividualPage extends ProjectSpecificMethods{
	
	public EditIndividualPage chooseSalutation() {
		click(locateElement(Locators.XPATH,"//a[@class='select']"));
		click(locateElement(Locators.XPATH,"//a[@title='Mr.']"));
		return this;
	}
	
	public EditIndividualPage enterFirstName(String fName) {
		clearAndType(locateElement(Locators.XPATH,"//input[@placeholder='First Name']"),fName);
		return this;
	}
	
	public IndividualsPage clickSave() {
		click(locateElement(Locators.XPATH,"(//span[text()='Save'])[2]"));
		return new IndividualsPage();
	}
}