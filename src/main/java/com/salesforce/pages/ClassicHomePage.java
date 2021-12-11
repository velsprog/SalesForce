package com.salesforce.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class ClassicHomePage extends ProjectSpecificMethods {
	
	public ClassicHomePage clickAllTabs() {
		click(locateElement(Locators.ID,"AllTab_Tab"));
		return this;
	}
	
	public AccountsPage clickAccountsTab() {
		click(locateElement(Locators.XPATH,"//a[contains(@class,'accountBlock')]"));
		return new AccountsPage();
	}
}
