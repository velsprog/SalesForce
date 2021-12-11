package com.salesforce.pages;

import org.openqa.selenium.WebElement;

import com.framework.testng.api.base.ProjectSpecificMethods;

public class MobileAppPage extends ProjectSpecificMethods{
	
	public MobileAppPage verifyMobileAppHomePage() {
		switchToLastOpenWindow();
		verifyTitle("Create and Publish Custom-Branded Mobile Apps - Salesforce.com");
		reportStep("Mobile Apps Page is loaded", "pass");
		return this;
	}
	
	public MobileAppPage moveToResourceOption() {
		WebElement ele = navigateToShadowRoot("return document.querySelector(\"#c360-hgf-nav\").shadowRoot.querySelector(\"header > div:nth-child(2) > div > div > div > div > div.globalnavbar-header-container > nav > ul > li.nav-item.menu_item_33 > button > span:nth-child(1)\")");
		moveToElement(ele);
		reportStep("Move to Resurce Success", "pass");
		return this;
	}
	
	public CertificationAdminPage clickSFCerticate() {
		WebElement ele = navigateToShadowRoot("return document.querySelector(\"#c360-hgf-nav\").shadowRoot.querySelector(\"header > div:nth-child(2) > div > div > div > div > div.globalnavbar-header-container > nav > ul > li.nav-item.menu_item_33 > div > div > div > div:nth-child(2) > ul > li > div.sub-nav > ul > li:nth-child(3) > a > span:nth-child(1)\")");
		ele.click();
		reportStep("click sales force certificate success", "pass");
		return new CertificationAdminPage();
	}
	
}