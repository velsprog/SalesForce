package com.salesforce.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

@Component
public class HomePage extends ProjectSpecificMethods {

	public HomePage verifyHomePage() {
		verifyDisplayed(locateElement(Locators.XPATH, "//span[text()='Home']"));
		reportStep("Homepage is loaded", "pass");
		return this;
	}

	public HomePage clickToggleMenu() {
		click(locateElement(Locators.XPATH, "//div[@class='slds-icon-waffle']"));
		reportStep("Toggle Menu Clicked.", "pass");
		return this;
	}

	public AppLauncherPage clickViewAll() {
		click(locateElement(Locators.XPATH, "//button[text()='View All']"));
		reportStep("ViewAll link clicked.", "pass");
		return applauncherpage;
	}
	
	public SalesforceStatusPage clickSlider() throws InterruptedException {
		List<WebElement> titles = locateElements(Locators.XPATH, "//div[@class='tileTitle']//span");
		for (int i = 0; i < titles.size(); i++) {
			if (titles.get(i).getText().equals("See System Status")) {
				click(locateElement(Locators.XPATH,
						"//span[text()='See System Status']/ancestor::div[@class='tileTitle']/following-sibling::div//span[text()='Get Started']"));
				break;
			}
			if ((i + 1) % 3 == 0) {
				click(locateElement(Locators.XPATH, "//button[contains(@class,'rightArrowButton')]"));
				Thread.sleep(5000);
			}
		}
		return new SalesforceStatusPage();
	}
	
	public MobileAppPage clickLearnMore() {
		waitForApperance(locateElement(Locators.XPATH, "//span[text()='Learn More']"));
		click(Locators.XPATH, "//span[text()='Learn More']");
		reportStep("Click Learn more success", "pass");
		return new MobileAppPage();
	}
	
	public HomePage clickGloabalAction() {
		click(locateElement(Locators.XPATH, "//div[contains(@class,'oneGlobalCreate')]//a"));
		reportStep("Global Action button clicked.", "pass");
		return this;
	}
	
	public CreateOrEditContactsPage  clickNewContact() {
		click(locateElement(Locators.XPATH, "//span[text()='New Contact']"));
		reportStep("New Contact option clicked", "pass");
		return new CreateOrEditContactsPage();
	}
	
	public HomePage clickViewProfile() {
		click(locateElement(Locators.XPATH,"//span[contains(@class,'userProfileCard')]/button"));
		return this;
	}
	
	public ClassicHomePage clickSwitchToClassicLink() {
		click(locateElement(Locators.LINK_TEXT,"Switch to Salesforce Classic"));
		return new ClassicHomePage();
	}
}