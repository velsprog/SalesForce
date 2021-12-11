package com.salesforce.pages;

import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByAll;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class CreateOrEditContactsPage extends ProjectSpecificMethods {
	
	public CreateOrEditContactsPage selectSalution(String salutation) {
		click(locateElement(Locators.XPATH, "//div[contains(@class,'salutation')]//a"));
		click(locateElement(Locators.XPATH,"//a[@title='"+ salutation +"']"));
		reportStep("Salutation \"" + salutation + "\" selected.", "pass");
		return this;
	}
	
	public CreateOrEditContactsPage typeFirstname(String firstname) {
		clearAndType(locateElement(Locators.XPATH, "//input[@placeholder='First Name']"), firstname);
		reportStep(firstname + " entered in firstname field successfully.", "pass");
		return this;
	}
	
	public CreateOrEditContactsPage typeLastname(String lastname) {
		clearAndType(locateElement(Locators.XPATH, "//input[@placeholder='Last Name']"), lastname);
		reportStep(lastname + " entered in lastname field successfully.", "pass");
		return this;
	}
	
	public CreateOrEditContactsPage typeEmail(String email) {
		clearAndType(locateElement(Locators.XPATH, "//input[@inputmode='email']"), email);
		reportStep(email + " entered in email field successfully.", "pass");
		return this;
	}
	
	public CreateOrEditContactsPage typeTitle(String title) {
		clearAndType(locateElement(Locators.XPATH, "//input[@name='Title']"), title);
		reportStep(title + " entered in title field successfully.", "pass");
		return this;
	}
	
	public CreateOrEditContactsPage selectLeadSource(String leadSource) {
		scrollIntoView(locateElement(Locators.XPATH, "//label[text()='Lead Source']/parent::lightning-combobox//input"));
		click(locateElement(Locators.XPATH, "//label[text()='Lead Source']/parent::lightning-combobox//input"));
		click(locateElement(Locators.XPATH,"//lightning-base-combobox-item[@data-value='"+leadSource+"']"));
		reportStep(leadSource + " is selected as Lead Source Successfully.", "pass");
		return this;
	}
	
	public CreateOrEditContactsPage typePhoneNum(String phoneNum) {
		scrollIntoView(locateElement(Locators.XPATH, "//input[@name='Phone']"));
		clearAndType(locateElement(Locators.XPATH, "//input[@name='Phone']"), phoneNum);
		reportStep(phoneNum + " entered in Phone Number field successfully.", "pass");
		return this;
	}
	
	public CreateOrEditContactsPage enterDOB(String dob) {
		String day = dob.split("/")[0];
		int monNum = Integer.parseInt(dob.split("/")[1]);
		String year = dob.split("/")[2];
		String month = null;
		switch (monNum) {
		case 1:
			month = "January";
			break;
		case 2:
			month = "February";
			break;
		case 3:
			month = "March";
			break;
		case 4:
			month = "April";
			break;
		case 5:
			month = "May";
			break;
		case 6:
			month = "June";
			break;
		case 7:
			month = "July";
			break;
		case 8:
			month = "August";
			break;
		case 9:
			month = "September";
			break;
		case 10:
			month = "October";
			break;
		case 11:
			month = "November";
			break;
		case 12:
			month = "December";
			break;
		default:
			break;
		}
		scrollIntoView(locateElement(Locators.XPATH, "//input[@name='Birthdate']"));
		click(locateElement(Locators.XPATH, "//input[@name='Birthdate']"));
		selectDropDownUsingText(locateElement(Locators.XPATH, "//select[contains(@id,'select')]"), year);
		String elementText = getElementText(locateElement(Locators.XPATH, "//div[contains(@class,'datepicker')]//h2"));
		if((monNum < Calendar.getInstance().get(Calendar.MONTH)+1)) {
			while(!(month.equalsIgnoreCase(elementText)) ) {
				click(locateElement(Locators.XPATH,"//button[@title='Previous Month']"));
				elementText = getElementText(locateElement(Locators.XPATH, "//div[contains(@class,'datepicker')]//h2"));
			}
		} else if((monNum > Calendar.getInstance().get(Calendar.MONTH)+1)) {
			while(!(month.equalsIgnoreCase(elementText)) ) {
				click(locateElement(Locators.XPATH,"//button[@title='Next Month']"));
				elementText = getElementText(locateElement(Locators.XPATH, "//div[contains(@class,'datepicker')]//h2"));
			}	
		}
		click(locateElement(Locators.XPATH, "//span[@class='slds-day' and text()='"+day+"']"));
		return this;
	}
	
	public CreateOrEditAccountsPage clickNewAccountFromAccountDropDown() {
		click(locateElement(Locators.XPATH,"//input[@title='Search Accounts']"));
		click(locateElement(Locators.XPATH, "//span[@title='New Account']"));
		reportStep("New Account Button Clicked.","pass");
		return new CreateOrEditAccountsPage();
	}
	
	public ContactHomePage clickSave() {
		WebElement el = getDriver().findElement(new ByAll(By.xpath("//div[contains(@class,'bottomBarRight')]/button"),By.xpath("//button[@name='SaveEdit']")));
		click(el);
		reportStep("Account saved successfully.", "pass");
		return new ContactHomePage();
	}

}
