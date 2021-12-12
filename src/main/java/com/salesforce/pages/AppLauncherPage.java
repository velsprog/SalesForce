package com.salesforce.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

@Component
public class AppLauncherPage extends ProjectSpecificMethods {

	public AppLauncherPage verifyAppLauncherPage() {
		verifyDisplayed(locateElement(Locators.XPATH, "//h2[text()='App Launcher']"));
		return this;
	}

	public AppLauncherPage clickSearchAppsTextBox() {
		click(locateElement(Locators.XPATH, "//input[@class='slds-input']"));
		return this;
	}

	public SalesHomePage clickSales() {
		click(locateElement(Locators.XPATH,
				"//p[@title='Manage your sales process with accounts, leads, opportunities, and more']"));
		return saleshomepage;
	}

	public ContentHomePage clickContent() {
		click(locateElement(Locators.XPATH, "//p[text()='Content']"));
		return new ContentHomePage();
	}

	public IndividualsPage clickIndividuals() {
		scrollIntoView(locateElement(Locators.XPATH, "//p[text()='Individuals']"));
		reportStep("Scroll to Individual link Success", "Pass");
		click(Locators.XPATH, "//p[text()='Individuals']");
		reportStep("Click individual page success", "Pass");
		return new IndividualsPage();
	}

	public WorkTypesPage clickWorkTypes() {
		click(locateElement(Locators.XPATH, "(//mark[text()='Work'])[3]"));
		return new WorkTypesPage();
	}

	public NewWorkTypePage clickworkType() {
		WebElement worktypeElement = locateElement(Locators.XPATH,
				"//p[@class='slds-truncate' and text()='Work Types']");
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		executor.executeScript("arguments[0].scrollIntoView();", worktypeElement);
		worktypeElement.click();
		return new NewWorkTypePage();
	}

	public LegalEntityPage clickLegalEntity() {
		scrollIntoView(locateElement(Locators.XPATH, "//p[text()='Legal Entities']"));
		reportStep("Scroll to Legal Entiry Success", "Pass");
		click(Locators.XPATH, "//p[text()='Legal Entities']");
		reportStep("Click Legal Entity page success", "Pass");
		return new LegalEntityPage();
	}

	public ContactHomePage clickContacts() {
		scrollIntoView(locateElement(Locators.XPATH, "//p[text()='Contacts']"));
		click(locateElement(Locators.XPATH, "//p[text()='Contacts']"));
		return new ContactHomePage();
	}
	
	public ServiceTerritoriesHomePage clickServiceTerritories() {
		scrollIntoView(locateElement(Locators.XPATH, "//p[text()='Service Territories']"));
		click(locateElement(Locators.XPATH,"//p[text()='Service Territories']"));
		return new ServiceTerritoriesHomePage();
	}

	public ServiceResourcesPage clickServiceResources() {
		scrollIntoView(locateElement(Locators.XPATH, "//p[text()='Service Resources']"));
		click(locateElement(Locators.XPATH, "//p[text()='Service Resources']"));
		reportStep("Recently Viewed | Service Resources | Salesforce","Pass");
		return new ServiceResourcesPage();
	}
	
	public ContractsPage clickContracts() {
		scrollIntoView(locateElement(Locators.XPATH, "//p[text()='Contracts']"));
		click(locateElement(Locators.XPATH,"//p[text()='Contracts']"));
		return new ContractsPage();
	}
	
	public ServiceHomePage clickService() {
		click(locateElement(Locators.XPATH, "//p[text()='Service']"));
		reportStep("Service Link Clicked Successfully","Pass");
		return new ServiceHomePage();
	}
}