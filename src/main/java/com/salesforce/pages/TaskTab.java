package com.salesforce.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class TaskTab extends ProjectSpecificMethods {

	public TaskTab clickRecentViewedDrop() {
		// 5.Click on Dropdown icon available under tasks and select value as Recently
		click(Locators.XPATH, "//button[@title='Select List View']");
		reportStep("Diplay view changed to list successfully", "pass");
		return this;
	}

	public TaskTab clickRecentlyViewed() {
		click(Locators.XPATH, "//div[@class='listContent']//span[text()='Recently Viewed']");
		reportStep("click recently viewed success", "pass");
		return this;
	}

	public TaskTab changeDisplayTypeTable() throws InterruptedException {
		click(Locators.XPATH, "//button[contains(@title,'Display')]");
		reportStep("click display type button success", "pass");
		click(Locators.XPATH, "//li[@title='Table']");
		reportStep("Display type changed success", "pass");
		Thread.sleep(3000);
		return this;
	}

	public TaskTab SearchTask() throws InterruptedException {
		typeAndEnter(locateElement(Locators.XPATH, "//input[@name='Task-search-input']"), "Bootcamp");
		reportStep("Search task success", "pass");
		Thread.sleep(3000);
		return this;
	}

	public TaskWindow clickEditButton() {
		click(Locators.XPATH, "//div[contains(@class,'forceVirtualActionMarker')]");
		reportStep("click Edit Dropdown success", "pass");
		click(Locators.XPATH, "//a[@title='Edit']");
		reportStep("click Edit button success", "pass");
		return new TaskWindow();
	}

	public TaskWindow clickDeleteButton() {
		click(Locators.XPATH, "//div[contains(@class,'forceVirtualActionMarker')]");
		reportStep("click Delete dropdown success", "pass");
		click(Locators.XPATH, "//a[@title='Delete']");
		reportStep("Click Delete button success", "pass");
		click(Locators.XPATH, "//span[text()='Delete']");
		reportStep("click Delete confirm success", "pass");
		return new TaskWindow();
	}
	
	public FollowUpTaskPage clickFollowupTaskButton() throws InterruptedException {
		click(Locators.XPATH, "//div[contains(@class,'forceVirtualActionMarker')]");
		reportStep("Click follow-up Task drop down success", "pass");
		Thread.sleep(3000);
		waitForApperance(locateElement(Locators.XPATH, "//ul[@role='presentation']//a[@title='Create Follow-Up Task']"));
		click(Locators.XPATH, "//ul[@role='presentation']//a[@title='Create Follow-Up Task']");
		reportStep("click Follow-up task button succcess", "pass");
		return new FollowUpTaskPage();
	}
	
	public TaskTab clickOpenTask() {
		click(Locators.XPATH, "//div[@class='listContent']//span[text()='Open Tasks']");
		reportStep("click Open Tasks success", "pass");
		return this;
	}
	
	public TaskTab clickSettings() {
		click(Locators.XPATH, "//button[@title = 'List View Controls']");
		reportStep("click settings button success", "pass");
		return this;
	}
	public CloneTaskPage clickClone() {
		click(Locators.XPATH, "//span[text()='Clone']");
		reportStep("Click clone button success", "pass");
		return new CloneTaskPage();
	}
	
}
