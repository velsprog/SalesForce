package com.salesforce.pages;

import org.openqa.selenium.By;
import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class ContentHomePage extends ProjectSpecificMethods {

	public ContentHomePage verifyContentHomePage() {
		verifyDisplayed(locateElement(Locators.XPATH, "//span[@title='Content']"));
		return this;
	}
	
	public TaskTab clickViewAllTodaysTask() {
		getDriver().findElement(By.xpath("//a[@aria-label='View All Tasks']")).click();
		return new TaskTab();
	}
	
	public SalesHomePage clickViewAllKeyDeals() {
		click(Locators.XPATH,"//span[text()='View All Key Deals']");
		return new SalesHomePage();
	}
	
}