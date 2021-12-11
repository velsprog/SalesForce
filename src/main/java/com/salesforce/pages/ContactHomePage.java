package com.salesforce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class ContactHomePage extends ProjectSpecificMethods{
	
	public ContactHomePage entersearchkey(String contactName) throws InterruptedException {
		click(Locators.XPATH, "//button[contains(@title,'Display as')]");
		click(Locators.XPATH, "//span[text()='Table']");
		typeAndEnter(locateElement(Locators.XPATH, "//input[contains(@placeholder,'Search this list')]"), contactName);
		reportStep("Search Key Entered.", "pass");
		return this;
	}
	
	public CreateOrEditContactsPage clickEditForContact(String contactName) throws InterruptedException {
		getWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//table[contains(@class,'forceRecordLayout')]/tbody/tr/th//a"), contactName));
		click(Locators.XPATH, "//table[contains(@class,'forceRecordLayout')]/tbody/tr/td[8]//a");
		click(Locators.XPATH, "//a[@title='Edit']");
		reportStep("Edit Button clicked.", "pass");
		return	new CreateOrEditContactsPage();
	}
	
	public ContactHomePage clickDeleteForContact(String contactName) throws InterruptedException {
		getWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//table[contains(@class,'forceRecordLayout')]/tbody/tr/th//a"), contactName));
		click(Locators.XPATH, "//table[contains(@class,'forceRecordLayout')]/tbody/tr/td[8]//a");
		click(Locators.XPATH, "//a[@title='Delete']");
		click(Locators.XPATH, "//button[@title='Delete']");
		reportStep("Delete Button clicked.", "pass");
		return	this;
	}
	
	public void verifyContactIsCreated(String firstName, String lastName) {
		getWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[contains(@class,'toastMessage')]"), firstName));
		verifyExactText(locateElement(Locators.XPATH, "//span[contains(@class,'toastMessage')]"), "Contact \""+firstName+" "+lastName+"\" was created.");
		reportStep("Contact Created Successfully.", "pass");
	}
	
	public void verifyContacEdited(String contactName) {
		getWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[contains(@class,'toastMessage')]"), contactName));
		verifyPartialText(locateElement(Locators.XPATH, "//span[contains(@class,'toastMessage')]"), contactName+"\" was saved.");
		reportStep("Contact Edited Successfully.", "pass");
	}
	
	public void verifyContactDeleted(String contactName) {
		getWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[contains(@class,'toastMessage')]"), contactName));
		verifyExactText(locateElement(Locators.XPATH, "//span[contains(@class,'toastMessage')]"), "Contact \""+contactName+"\" was deleted. Undo");
		reportStep("Account Deleted Successfully.", "pass");
	}

}
