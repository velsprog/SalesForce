package com.salesforce.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class CertificationAdminPage extends ProjectSpecificMethods {
	
	public CertificationAdminPage switchThirdWindow() {
		switchToWindow(2);
		switchToWindow("Certification - Administrator Overview");
		return this;
	}

	public CertificationAdminPage clickSalesforceArchitect() {
		click(locateElement(Locators.XPATH, "//div[text()='Salesforce Architect']"));
		return this;
	}

	public CertificationAdminPage verifyCertificateNames() {
		List<String> certName = new ArrayList<String>();
		List<WebElement> names = locateElements(Locators.XPATH,
				"(//div[contains(@class,'cs-card tile')]//a[not(contains(@class,'btn-gray'))])");
		names.size();
		for (int i = 0; i < names.size(); i++) {
			String text = names.get(i).getText();
			certName.add(text);
		}
		System.out.println("Certificate Names are:" + certName);
		return this;
	}
	
	public CertificationAdminPage verifyCertificateHomePage() {
		switchToLastOpenWindow();
		verifyTitle("Certification - Administrator Overview");
		reportStep("Certification Page loaded Success", "pass");
		return this;
	}
	public CertificationAdminPage clickArchitect() {
		click(Locators.XPATH, "//div[text()='Salesforce Architect']");
		reportStep("click Architect Success", "pass");
		return this;
	}
	
	public ArchitectReviewPage clickMoredetail() {
		click(Locators.XPATH, "//a[text()='More Details']");
		reportStep("Click More Details success", "pass");
		return new ArchitectReviewPage();
	}
}