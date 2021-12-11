package com.salesforce.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class NewWorkTypePage extends ProjectSpecificMethods {

	static String workTypeName = "Salesforce Project";
	static String actualText;
	static String workTypeText;

	public NewWorkTypePage verifyWorkTypesPage() {
		verifyDisplayed(locateElement(Locators.XPATH, "//span[text()='Work Types']"));
		return this;
	}

	// WorkTypeClickNewButton
	public NewWorkTypePage clickOnNewButton() {
		click(locateElement(Locators.XPATH, "//a[@title='New']"));
		return this;
	}

	// EnterWorkTypeName
	public NewWorkTypePage enterWorkTypeName(String workTypeName) {

		clearAndType(
				locateElement(Locators.XPATH, "//span[text()='Work Type Name']/parent::label/following-sibling::input"),
				workTypeName);
		reportStep(workTypeName + " entered successfully", "pass");
		return this;
	}

	// EnterDescription
	public NewWorkTypePage enterDesriptionName(String description) {

		clearAndType(locateElement(Locators.XPATH, "//textarea[@class=' textarea']"), description);
		reportStep(description + " entered successfully", "pass");

		return this;
	}

	// EnterclickSearchOperatingHours
	public NewWorkTypePage clickSearchOperatingHours() {

		click(locateElement(Locators.XPATH, "//input[@title='Search Operating Hours']"));

		return this;
	}

	// ClickNewOperatingHours
	public NewWorkTypePage clicknewOperatingHours() {

		click(locateElement(Locators.XPATH, "//span[@title='New Operating Hours']"));
		return this;
	}

	// EnterNewOperatingHours
	public NewWorkTypePage enternewOperatingHoursDescription(String operatingHours) {

		clearAndType(locateElement(Locators.XPATH, "//span[text()='Name']/parent::label/following-sibling::input"),
				operatingHours);
		return this;
	}

	// clickNewTimeZone button
	public NewWorkTypePage clicknewTimeZone() {

		click(locateElement(Locators.XPATH, "//span[text()='Time Zone']/parent::span/following-sibling::div//a"));
		return this;
	}

	// SelectTimeZone
	public NewWorkTypePage selectTimeZone()

	{
		click(locateElement(Locators.XPATH, "//div[@class='select-options']/ul/li/a[contains(@title,'London')]"));
		return this;
	}

	// saveNewOperatingHours
	public NewWorkTypePage saveNewOperatingHours()

	{
		click(locateElement(Locators.XPATH,
				"//h2[text()='New Operating Hours']/parent::div/following-sibling::div[contains(@class,'modal-footer')]//button[@title='Save']"));
		return this;
	}

	// EnterEstimatedDuration
	public NewWorkTypePage enterEstimatedDuration(String data)

	{

		typeAndTab(locateElement(Locators.XPATH,
				"//span[text()='Estimated Duration']/parent::label//following-sibling::input[contains(@class,'uiInputSmartNumber')]"),
				data);

		return this;
	}

	// ClickNewWOrkTypeSave
	public NewWorkTypePage clickSave()

	{
		click(locateElement(Locators.XPATH, "//div[contains(@class,'inlineFooter')]//button[@title='Save']"));
		return this;
	}

	// VerifyCreatedMessage
	public void verifyCreatedMessage() {
		getWait().until(ExpectedConditions.textToBePresentInElementLocated(
				By.xpath("//span[contains(@class,'toastMessage') and contains(text(),'Work Type')]"), "Work Type"));
		actualText = getDriver()
				.findElement(By.xpath("//span[contains(@class,'toastMessage') and contains(text(),'Work Type')]"))
				.getText();
		Assert.assertEquals(actualText, "Work Type \"" + workTypeName + "\" was created.");

	}

	// SearchWorkTypeThroughsearch
	public NewWorkTypePage searchWorktype(String SearchInput) {
		clearAndType(locateElement(Locators.XPATH, "//input[@placeholder='Search apps or items...']"));
		reportStep(SearchInput + " entered successfully", "pass");

		return this;

	}

	// selectingwortypefromSearchTable
	public NewWorkTypePage editWorkType() {

		locateElement(Locators.XPATH, "//table/tbody/tr[1]/td").getSize();

		workTypeText = getDriver().findElement(By.xpath("//table/tbody/tr[1]/th//a")).getText();

		System.out.println(workTypeName);
		click(locateElement(Locators.XPATH, "//table/tbody/tr[1]/td[5]//a"));
		
		return this;
	}

	// clickDeleteType
	public NewWorkTypePage clickDeleteinWorkType() {
		click(locateElement(Locators.XPATH, "//following-sibling::button[@title='Delete']"));
		return this;
	}

	public NewWorkTypePage changetheStartTime(String timeFrameStart) {
		clearAndType(locateElement(Locators.XPATH,
				"//span[text()='Timeframe Start']/parent::label//following-sibling::input[contains(@class,'uiInputSmartNumber')]"));
		return this;
	}

	public NewWorkTypePage changetheEndTime(String timeFrameEnd) {
		clearAndType(locateElement(Locators.XPATH,
				"//span[text()='Timeframe End']/parent::label//following-sibling::input[contains(@class,'uiInputSmartNumber')]"));
		return this;

	}
	
	public void verifyEditMessage()
	{
		getWait().until(ExpectedConditions
			.textToBePresentInElementLocated(By.xpath("//span[contains(@class,'toastMessage')]"), workTypeName));
	String strValue = getDriver().findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
	System.out.println(strValue);
	Assert.assertEquals(strValue, "Work Type \"" + workTypeName + "\" was saved.");
	}

}
