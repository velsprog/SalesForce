package com.salesforce.pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class SalesfoceCompliancePage extends ProjectSpecificMethods {
	
	public SalesfoceCompliancePage clickShowFilters() {
		click(locateElement(Locators.XPATH, "(//button[contains(@class,'slds-button slds-button_neutral')])[2]"));
		return this;
	}
	
	public SalesfoceCompliancePage clickNonProfitUnderIndustires() {
		click(locateElement(Locators.XPATH, "//label[@for='Nonprofit']"));
		return this;
	}
	
	public SalesfoceCompliancePage verifyNumberOfNonProfitCertification() throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> certificateCount = locateElements(Locators.XPATH,"//a[contains(@class,'slds-box_link slds-media slds-card tile mb3')]");
		int totalCount = certificateCount.size();
		System.out.println("Count of Non Profit Certificates are :" +totalCount);
		return this;
	}
	
	public SalesfoceCompliancePage clickClearFilter() {
		WebElement clearFilter = locateElement(Locators.XPATH,"//button[contains(@class,'slds-button slds-button_neutral')]");
		boolean clearFilterOption = clearFilter.isDisplayed();
		System.out.println("Clear Filter Option is displayed: "+clearFilterOption);
		return this;
	}
}