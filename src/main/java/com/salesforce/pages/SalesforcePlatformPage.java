package com.salesforce.pages;

import org.openqa.selenium.WebElement;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class SalesforcePlatformPage extends ProjectSpecificMethods {

	public SalesforcePlatformPage switchSecondWindow() {
		switchToWindow(1);
		switchToWindow("Create and publish custom-branded mobile apps");
		return this;
	}

	public SalesforcePlatformPage chooseResourcesOption() {
		WebElement resource = navigateToShadowRoot("return document.querySelector(\"#c360-hgf-nav\").shadowRoot.querySelector(\"header > div:nth-child(2) > div > div > div > div > div.globalnavbar-header-container > nav > ul > li.nav-item.menu_item_33 > button > span:nth-child(1)\")");
		moveToElement(resource);
		return this;
	}

	public CertificationAdminPage chooseSalesforceCertification() {
		WebElement SFCertificate = navigateToShadowRoot("return document.querySelector(\"#c360-hgf-nav\").shadowRoot.querySelector(\"header > div:nth-child(2) > div > div > div > div > div.globalnavbar-header-container > nav > ul > li.nav-item.menu_item_33 > div > div > div > div:nth-child(2) > ul > li > div.sub-nav > ul > li:nth-child(3) > a > span:nth-child(1)\")");
		moveToElement(SFCertificate);
		clickUsingJs(SFCertificate);
		return new CertificationAdminPage();
	}
}