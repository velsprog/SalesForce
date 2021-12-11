package com.salesforce.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class VerifyCaseHomePage extends ProjectSpecificMethods {

	public VerifyCaseHomePage verfiyCaseCreated(String Expectedtext) throws InterruptedException {
		
		verifyPartialText(locateElement(Locators.XPATH,"//button[@title='Save']"),Expectedtext);
		return this;
	}
	
	public VerifyCaseHomePage verfiyDeleteCase(String Expectedtext) throws InterruptedException {
		
		verifyPartialText(locateElement(Locators.XPATH,"//span[@class='toastMessage slds-text-heading--small forceActionsText']"),Expectedtext);
		return this;
	}
	
}