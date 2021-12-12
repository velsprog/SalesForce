package com.salesforce.pages;

import org.springframework.stereotype.Component;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

@Component
public class SalesHomePage extends ProjectSpecificMethods {

	public SalesHomePage verifySalesHomePage() {
		verifyDisplayed(locateElement(Locators.XPATH, "//span[@title='Sales']"));
		return this;
	}

	public SalesHomePage clickTaskDropdown() {
		click(locateElement(Locators.XPATH,
				"//a[contains(@title,'Tasks')]/following-sibling::one-app-nav-bar-item-dropdown"));
		return this;
	}

	public TaskWindow clickNewTask() {
		clickUsingJs(locateElement(Locators.XPATH, "//span[text()='New Task']"));
		return new TaskWindow();
	}

	public TaskTab clickTaskTab() {
		// 4. Click on Tasks tab
		clickUsingJs(locateElement(Locators.XPATH, "//span[text()='Tasks']/parent::a"));
		return new TaskTab();
	}

	public OpportunitiesPage clickopporunityPage() {
		clickUsingJs(locateElement(Locators.XPATH, "//span[text()='Opportunities']"));
		return new OpportunitiesPage();
	}

	public AccountsPage clickAccountsTab() {
		clickUsingJs(locateElement(Locators.XPATH, "//span[@class='slds-truncate' and text()='Accounts']"));
		reportStep("Accounts Tabs Clicked.", "pass");
		return accountspage;
	}

	public SalesHomePage clickMoreTab() {
		clickUsingJs(locateElement(Locators.XPATH, "//span[text()='More']"));
		reportStep("More Tabs Clicked.", "pass");
		return this;
	}

	public CreateCasePage navigateToCaseScreen() throws InterruptedException {
		clickUsingJs(locateElement(Locators.XPATH, "//a[@role='menuitem']//span[text()='Cases']"));
		reportStep("Create Case Screen Displayed Successfully", "pass");
		return new CreateCasePage();
	}


	public NewLeadPage clickLeadsTab()
	{
		clickUsingJs(locateElement(Locators.XPATH, "//span[text()='Leads']"));
		reportStep("More Tabs Clicked.", "pass");
		return new NewLeadPage();
	}
	
	public SalesHomePage clickOpportunitiesDropdown() {
		click(locateElement(Locators.XPATH, "//a[contains(@class,'slds-button slds-button_reset')]"));
		return this;
	}

	public SalesHomePage chooseAllOpportunities() {
		clickUsingJs(locateElement(Locators.XPATH, "//span[contains(text(),'All Opportunities')]"));
		return this;
	}
}
