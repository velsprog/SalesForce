package com.salesforce.pages;

import org.springframework.stereotype.Component;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

@Component
public class LoginPage extends ProjectSpecificMethods{
	
	public LoginPage enterUsername(String data) {
		clearAndType(locateElement(Locators.ID, "username"), data);
		reportStep(data+" entered successfully","pass");
		return this;
	}
	
	public LoginPage enterPassword(String data) {
		clearAndType(locateElement(Locators.ID, "password"), data);
		reportStep(data+" entered successfully","pass");
		return this;
	}
	
	public HomePage clickLogin() {
		click(locateElement(Locators.ID, "Login"));
		reportStep("Login button clicked successfully", "pass");
		return homepage;
	}
}