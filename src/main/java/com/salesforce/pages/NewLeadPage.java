package com.salesforce.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class NewLeadPage extends ProjectSpecificMethods {

	
	  static String leadName = "Mr.Automation"; 
	  static String actualText;
	  static String salutation;
	 
	// LeadsClickNewButton
	  
	  public NewLeadPage clickNewButton() { 
			click(locateElement(Locators.XPATH, "//div[text()='New']"));
			reportStep("Successfully clicked the New button", "pass");
			return this;
		}
	  
	public NewLeadPage selectSalutation(String salutation ) {
		click(locateElement(Locators.XPATH, "//input[@name='salutation']"));
		click(locateElement(Locators.XPATH, "//span[@title='Mr.']"));
		//click(locateElement(Locators.XPATH,"//a[@title='"+ salutation +"']"));
		reportStep("Salutation \"" + salutation + "\" selected.", "pass");
		return this;
	}
	
	//clickandEnterLastName
	public NewLeadPage clickAndEnterlastName(String enterLastName) {
		waitForApperance(locateElement(Locators.XPATH,"//input[@name='lastName']"));
		click(locateElement(Locators.XPATH, "//input[@name='lastName']"));
		type(locateElement(Locators.XPATH, "//input[@name='lastName']"), enterLastName);
		reportStep("clickAndEnterlastName", "pass");

		return this;
	}
	
	public NewLeadPage clickAndEnterCompanyName (String enterCompanyName) {
//		clearAndType(locateElement(Locators.XPATH, "//input[@name='Company']"));
		type(locateElement(Locators.XPATH, "//input[@name='Company']"), enterCompanyName);
		reportStep("clickAndEnterCompanyName", "pass");
		return this;
	}
	
	public NewLeadPage clickSaveNewLead()

	{
		click(locateElement(Locators.XPATH, "//button[@name='SaveEdit']"));
		reportStep("clickSaveNewLead", "pass");
		return this;
	}

	// VerifyCreatedMessage
		public void verifyCreatedMessage() {
			waitForApperance(locateElement(Locators.XPATH, "//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
			verifyExactText(locateElement(Locators.XPATH, "//span[@class='toastMessage slds-text-heading--small forceActionsText']"), "Lead "+'"'+leadName+'"'+" was created.");
			reportStep("click Save button success", "pass");

		}
	

	

	

}
