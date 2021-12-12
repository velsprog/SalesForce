package com.salesforce.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

@Component
public class AccountsPage extends ProjectSpecificMethods {
	List<String> expectedList = new ArrayList<>();
	List<String> actualList = new ArrayList<>();
	int rowCount;

	public CreateOrEditAccountsPage clickNewButton() {
		WebElement el = getDriver().findElement(new ByAll(By.xpath("//div[@title='New']/parent::a"),By.xpath("//input[@name='new']")));
		click(el);
		reportStep("Add New Account Button Clicked.", "pass");
		return createoreditaccountspage;
	}
	
	public AccountsPage entersearchkey(String accountName) throws InterruptedException {
		try {
			click(Locators.XPATH, "//button[contains(@title,'Display as')]");
			click(Locators.XPATH, "//span[text()='Table']");
		} catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		WebElement el = getDriver().findElement(By.xpath("//input[contains(@placeholder,'Search this list')]"));
		typeAndEnter(el, accountName);
		reportStep("Search Key Entered.", "pass");
		return this;
	}
	
	public CreateOrEditAccountsPage clickEditForAccount(String accountName) throws InterruptedException {
		getWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//table[contains(@class,'forceRecordLayout')]/tbody/tr/th//a"), accountName));
		click(Locators.XPATH, "//table[contains(@class,'forceRecordLayout')]/tbody/tr/td[6]//a");
		click(Locators.XPATH, "//a[@title='Edit']");
		reportStep("Edit Button clicked.", "pass");
		return	createoreditaccountspage;
	}
	
	public AccountsPage clickDeleteForAccount(String accountName) throws InterruptedException {
		getWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//table[contains(@class,'forceRecordLayout')]/tbody/tr/th//a"), accountName));
		click(Locators.XPATH, "//table[contains(@class,'forceRecordLayout')]/tbody/tr/td[6]//a");
		click(Locators.XPATH, "//a[@title='Delete']");
		click(Locators.XPATH, "//button[@title='Delete']");
		reportStep("Delete Button clicked.", "pass");
		return	this;
	}
	
	public void verifyAccountCreated(String accountName) {
		getWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[contains(@title,'"+accountName+"')]"), accountName));
		verifyPartialText(locateElement(Locators.XPATH, "//div[contains(@title,'"+accountName+"')]"), accountName);
		reportStep("Account Created Successfully.", "pass");
	}
	
	public AccountsPage verifyAccountEdited(String accountName) {
		getWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[contains(@class,'toastMessage')]"), accountName));
		verifyExactText(locateElement(Locators.XPATH, "//span[contains(@class,'toastMessage')]"), "Account \""+accountName+"\" was saved.");
		reportStep("Account Edited Successfully.", "pass");
		return this;
	}
	
	public AccountsPage verifyDeleteToastMessage(String accountName) {
		getWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[contains(@class,'toastMessage')]"), accountName));
		verifyExactText(locateElement(Locators.XPATH, "//span[contains(@class,'toastMessage')]"), "Account \""+accountName+"\" was deleted. Undo");
		reportStep("Account Deleted Successfully.", "pass");
		return this;
	}
	
	public void verifyPhoneNumber(String phoneNum) {
		getWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//table[contains(@class,'forceRecordLayout')]/tbody/tr[1]/td[4]//span[contains(@class,'forceOutputPhone')]"), phoneNum));
		verifyExactText(locateElement(Locators.XPATH, "//table[contains(@class,'forceRecordLayout')]/tbody/tr[1]/td[4]//span[contains(@class,'forceOutputPhone')]"), phoneNum);
		reportStep("Phone Number displayed Correctly.", "pass");
	}
	
	public void verifyAccountIsDeleted(String accountName) throws InterruptedException {
		clear(locateElement(Locators.XPATH, "//input[contains(@placeholder,'Search this list')]"));
		typeAndEnter(locateElement(Locators.XPATH, "//input[contains(@placeholder,'Search this list')]"), accountName);
		getWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//p/*[contains(@class,'rich-text-editor')]/span"), "No items to display."));
		verifyExactText(locateElement(Locators.XPATH, "//p/*[contains(@class,'rich-text-editor')]/span"), "No items to display.");
		reportStep("Deleted Account not retrived as expected.", "pass");
	}
	
	public AccountsPage clickSort() {
		getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@class='countSortedByFilteredBy']")));
		rowCount = Integer.parseInt(getElementText(locateElement(Locators.XPATH, "//span[@class='countSortedByFilteredBy']")).substring(0, 2));
		System.out.println(rowCount);
		for(int i=1;i<=rowCount;i++) {
			scrollIntoView(locateElement(Locators.XPATH, "//table[contains(@class,'forceRecordLayout')]/tbody/tr["+i+"]/th//a"));
			expectedList.add(getElementText(locateElement(Locators.XPATH, "//table[contains(@class,'forceRecordLayout')]/tbody/tr["+i+"]/th//a")).toLowerCase());
			if(i==rowCount) {
				rowCount = Integer.parseInt(getElementText(locateElement(Locators.XPATH, "//span[@class='countSortedByFilteredBy']")).substring(0, 2));
			}
		}
		reportStep("Accounts List Sorted", "pass");
		return this;
	} 
	
	public void verifySortOrder() throws InterruptedException {
//		System.out.println(rowCount);
		Thread.sleep(1000);
		for(int i=1;i<=rowCount;i++) {
			scrollIntoView(locateElement(Locators.XPATH, "//table[contains(@class,'forceRecordLayout')]/tbody/tr["+i+"]/th//a"));
			actualList.add(getElementText(locateElement(Locators.XPATH, "//table[contains(@class,'forceRecordLayout')]/tbody/tr["+i+"]/th//a")).toLowerCase());
			if(i==rowCount) {
				rowCount = Integer.parseInt(getElementText(locateElement(Locators.XPATH, "//span[@class='countSortedByFilteredBy']")).substring(0, 2));
			}
		}
		Assert.assertEquals(actualList,expectedList);
		reportStep("Sorting Verified and Matched", "pass");
	}
	
	public AccountsPage verifyAccountIsCreatedInAccountsTab(String accountName) {
		getWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//table[@class='list']//tr[contains(@class,'dataRow even first')]/th/a"), accountName));
		verifyPartialText(locateElement(Locators.XPATH, "//table[@class='list']//tr[contains(@class,'dataRow even first')]/th/a"), accountName);
		reportStep("Account Name verified in Account Tab", "pass");
		return this;
	}
	
	public void switchToLightningExperience() {
		try {
			click(locateElement(Locators.XPATH,"//a[@class='switch-to-lightning']"));
		} catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		
	}
}
