package com.salesforce.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.stereotype.Component;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

import freemarker.template.SimpleDate;

@Component
public class CreateOrEditAccountsPage extends ProjectSpecificMethods {

	public CreateOrEditAccountsPage typeAccountName(String accountName) {
		WebElement el = getDriver().findElement(new ByAll(By.id("acc2"),By.xpath("//input[@name='Name']"),By.xpath("//span[text()='Account Name']/parent::label/following-sibling::input")));
		//waitForApperance(el);
		clearAndType(el, accountName);
		reportStep(accountName + " entered successfully", "pass");
		return this;
	}
	
	public CreateOrEditAccountsPage selectOwnership(String Ownership) {
		WebElement el =locateElement(Locators.XPATH, "//label[text()='Ownership']/parent::lightning-combobox//input");
		scrollIntoView(el);
		clickUsingJs(el);
		el =locateElement(Locators.XPATH, "//span[@title='"+Ownership+"']");
		scrollIntoView(el);
		clickUsingJs(el);
		reportStep("Ownership\""+Ownership + "\" selected Successfully.", "pass");
		return this;
	}
	
	public CreateOrEditAccountsPage selectType(String type) {
		WebElement el =locateElement(Locators.XPATH, "//label[text()='Type']/parent::lightning-combobox//input");
		scrollIntoView(el);
		clickUsingJs(el);
		el =locateElement(Locators.XPATH, "//span[@title='"+type+"']");
		scrollIntoView(el);
		clickUsingJs(el);
		reportStep("Type\""+type + "\" selected Successfully.", "pass");
		return this;
	}
	
	public CreateOrEditAccountsPage selectIndutry(String industry) {
		WebElement el =locateElement(Locators.XPATH, "//label[text()='Industry']/parent::lightning-combobox//input");
		scrollIntoView(el);
		clickUsingJs(el);
		el =locateElement(Locators.XPATH, "//span[@title='"+industry+"']");
		scrollIntoView(el);
		clickUsingJs(el);
		reportStep("Industry\""+industry + "\" selected Successfully.", "pass");
		return this;
	}
	
	public CreateOrEditAccountsPage selectPriority(String priority) {
		WebElement el =locateElement(Locators.XPATH, "//label[text()='Customer Priority']/parent::lightning-combobox//input");
		scrollIntoView(el);
		clickUsingJs(el);
		el =locateElement(Locators.XPATH, "//span[@title='"+priority+"']");
		scrollIntoView(el);
		clickUsingJs(el);
		reportStep("Priority\""+priority + "\" selected Successfully.", "pass");
		return this;
	}
	
	public CreateOrEditAccountsPage selectSLA(String SLA) {
		WebElement el =locateElement(Locators.XPATH, "//label[text()='SLA']/parent::lightning-combobox//input");
		scrollIntoView(el);
		clickUsingJs(el);
		el =locateElement(Locators.XPATH, "//span[@title='"+SLA+"']");
		scrollIntoView(el);
		clickUsingJs(el);
		reportStep("SLA\""+SLA + "\" selected Successfully.", "pass");
		return this;
	}
	
	public CreateOrEditAccountsPage selectActive(String active) {
		WebElement el =locateElement(Locators.XPATH, "//label[text()='Active']/parent::lightning-combobox//input");
		scrollIntoView(el);
		clickUsingJs(el);
		el =locateElement(Locators.XPATH, "//span[@title='"+active+"']");
		scrollIntoView(el);
		clickUsingJs(el);
		reportStep("Active\""+active + "\" selected Successfully.", "pass");
		return this;
	}
	
	public CreateOrEditAccountsPage enterPhoneNumber(String phoneNum) {
		clearAndType(locateElement(Locators.XPATH, "//input[@name='Phone']"), phoneNum);
		reportStep("Phone Number\""+phoneNum + "\" entered Successfully.", "pass");
		return this;
	}
	
	public CreateOrEditAccountsPage selectOpportunity(String opportunity) {
		WebElement el =locateElement(Locators.XPATH, "//label[text()='Upsell Opportunity']/parent::lightning-combobox//input");
		scrollIntoView(el);
		clickUsingJs(el);
		el =locateElement(Locators.XPATH, "//span[@title='"+opportunity+"']");
		scrollIntoView(el);
		clickUsingJs(el);
		reportStep("Opportunity\""+opportunity + "\" selected Successfully.", "pass");
		return this;
	}
	
	public CreateOrEditAccountsPage typeBillingAddress(String billAddress) {
		WebElement el = getDriver().findElement(new ByAll(By.id("acc17street"),By.xpath("//label[text()='Billing Street']/parent::lightning-textarea//textarea[@name='street']")));
		clearAndType(el, billAddress.split(",")[0]);
		el = getDriver().findElement(new ByAll(By.id("acc17city"),By.xpath("//label[text()='Billing City']/parent::lightning-input//input[@name='city']")));
		clearAndType(el, billAddress.split(",")[1]);
		el = getDriver().findElement(new ByAll(By.id("acc17state"),By.xpath("//label[text()='Billing State/Province']/parent::lightning-input//input[@name='province']")));
		clearAndType(el, billAddress.split(",")[2]);
		el = getDriver().findElement(new ByAll(By.id("acc17zip"),By.xpath("//label[text()='Billing Zip/Postal Code']/parent::lightning-input//input[@name='postalCode']")));
		clearAndType(el, billAddress.split(",")[3]);
		el = getDriver().findElement(new ByAll(By.id("acc17country"),By.xpath("//label[text()='Billing Country']/parent::lightning-input//input[@name='country']")));
		clearAndType(el,billAddress.split(",")[4]);
		reportStep("Billing Address entered Successfully.", "pass");
		return this;
	}
	
	public CreateOrEditAccountsPage clickCopyBillingAddrToShippingAddr() {
		click(locateElement(Locators.LINK_TEXT,"Copy Billing Address to Shipping Address"));
		reportStep("Copy Billing Address to Shipping Address Link Clicked Successfully.", "pass");
		return this;
	}
	
	public CreateOrEditAccountsPage typeShippingAddress(String shipAddress) {
		clearAndType(locateElement(Locators.XPATH,"//label[text()='Shipping Street']/parent::lightning-textarea//textarea[@name='street']"), shipAddress.split(",")[0]);
		clearAndType(locateElement(Locators.XPATH,"//label[text()='Shipping City']/parent::lightning-input//input[@name='city']"), shipAddress.split(",")[1]);
		clearAndType(locateElement(Locators.XPATH,"//label[text()='Shipping State/Province']/parent::lightning-input//input[@name='province']"), shipAddress.split(",")[2]);
		clearAndType(locateElement(Locators.XPATH,"//label[text()='Shipping Zip/Postal Code']/parent::lightning-input//input[@name='postalCode']"), shipAddress.split(",")[3]);
		clearAndType(locateElement(Locators.XPATH,"//label[text()='Shipping Country']/parent::lightning-input//input[@name='country']"),shipAddress.split(",")[4]);		
		reportStep("Shipping Address entered Successfully.", "pass");
		return this;
	}
	
	public CreateOrEditAccountsPage selectSLAExpirationDate() {
		Calendar c= Calendar.getInstance();
		c.add(Calendar.DATE, 20); //Current System date + 20 Days
		String date=new SimpleDateFormat("dd/MM/yyyy").format(c.getTime());
		click(locateElement(Locators.XPATH,"//span[contains(@class,'dateInput')]/input"));
		selectDropDownUsingText(locateElement(Locators.ID,"calYearPicker"), date.split("/")[2]);
		int month = Integer.parseInt(date.split("/")[1])-1;
		selectDropDownUsingValue(locateElement(Locators.ID,"calMonthPicker"),String.valueOf(month));
		click(locateElement(Locators.XPATH,"//td[text()='"+date.split("/")[0]+"']"));
		return this;
	}
	
	public Object clickSave(String landingPage) {
		WebElement el = getDriver().findElement(new ByAll(By.xpath("//input[@title='Save']"),By.xpath("//div[contains(@class,'modal-footer')]//button[@title='Save']"),By.xpath("//button[@name='SaveEdit']")));
		click(el);
		reportStep("Account saved successfully.", "pass");
		if(landingPage.contains("Accounts"))
			return accountspage;
		else if(landingPage.contains("Contact"))
			return new CreateOrEditContactsPage();
		else
			return this;
	}
	
	public ClassicHomePage verifyAccountIsCreated(String accountName) {
		verifyExactText(locateElement(Locators.XPATH,"//div[contains(@class,'individualPalette')]/div//span"), accountName);
		verifyPartialText(locateElement(Locators.XPATH,"//table[@class='detailList']//td[text()='Account Name']/following-sibling::td/div"), accountName);
		reportStep("Account Created Successfully.", "pass");
		return new ClassicHomePage();
	}
}
