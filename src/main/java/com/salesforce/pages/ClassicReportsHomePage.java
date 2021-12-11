package com.salesforce.pages;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.tools.ant.taskdefs.Sleep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class ClassicReportsHomePage extends ProjectSpecificMethods{
	
	public ClassicReportsHomePage clickLeads() throws InterruptedException {
		Thread.sleep(10000);
		switchToLastOpenWindow();
		System.out.println(getDriver().getTitle());
		waitForApperance(locateElement(Locators.XPATH, "//div[contains(@*,'categories')]//span[text()='Leads']"));
		//Thread.sleep(10000);
		click(locateElement(Locators.XPATH, "//div[contains(@*,'categories')]//span[text()='Leads']"));
		reportStep("Leads Button Clicked", "Pass");
		return this;
	}
	
	public ClassicReportsHomePage downloadImage() {
		
		return this;
	}
	
	public ClassicReportsHomePage clickCreateButton() {
		click(locateElement(Locators.XPATH, "//input[contains(@id,'createButton')]"));
		reportStep("Create button clicked Successfully.", "Pass");
		return this;
	}
	
	public ClassicReportsHomePage selectRange(String rangeAs) {
		click(locateElement(Locators.XPATH, "//input[@name='duration']"));
		getDriver().findElement(By.xpath("//div[text()='"+rangeAs+"']")).click();
		return this;
	}

	public ClassicReportsHomePage selectToDate() {
		click(locateElement(Locators.XPATH,"//input[@name='endDate']/following-sibling::img"));
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 5);
		String date = new SimpleDateFormat("dd/MM/yyyy").format(c.getTime());
		click(locateElement(Locators.XPATH, "//span[text()='"+date.split("/")[0]+"']"));
		reportStep("Currentdate +5 days Selected.", "Pass");
		return this;
	}
	
	public ClassicReportsHomePage verifyReportFormat(String format) {
		verifyExactText(locateElement(Locators.XPATH, "//table[@id='reportFormatMink']//td[contains(@class,'mc')]//button"), format);
		return this;
	}
	
	public ClassicReportsHomePage getAndDisplayCompanyList() {
		int noOfRows = locateElements(Locators.XPATH, "//div[@class='x-grid3-body']/div").size();
		List<String> companyList = new ArrayList<String>();
		for(int i=1;i<noOfRows;i++) {
			scrollIntoView(locateElement(Locators.XPATH, "//div[@class='x-grid3-body']/div["+i+"]//td[5]/div"));
			companyList.add(getElementText(locateElement(Locators.XPATH, "//div[@class='x-grid3-body']/div["+i+"]//td[5]/div")));
		}
		System.out.println("Companies List : ");
		for (String company : companyList) {
			System.out.println(company);
		}	
		return this;
	}
	
	public ClassicReportsHomePage getTotalRecords() {
		scrollIntoView(locateElement(Locators.XPATH, "//div[@class='x-grid3-body']/div[last()]//b"));
		String totalRecords = getElementText(locateElement(Locators.XPATH, "//div[@class='x-grid3-body']/div[last()]//b"));
		System.out.println(totalRecords);
		//System.out.println(totalRecords.split("(")[1].split(")")[0]);
		return this;
	}
	
	public ClassicReportsHomePage clickSave() {
		//switchToFrame(locateElement(Locators.XPATH, "(//iframe[contains(@class,'isEdit reportsReportBuilder')])"));
		click(locateElement(Locators.XPATH, "//button[text()='Save']"));
		//getDriver().switchTo().defaultContent();
		reportStep("Save Button Clicked Successfully.", "Pass");
		return this;
	}
	
	public ClassicReportsHomePage enterReportName(String name) {
		clearAndType(locateElement(Locators.XPATH, "//input[@name='reportName']"), name);
		reportStep("Report Name entered Successfully.", "Pass");
		return this;
	}
	
	public ClassicReportsHomePage enterReportUniqueName(String name) {
		clearAndType(locateElement(Locators.XPATH, "//input[@name='reportDevName']"), name+"5124");
		reportStep("Report Unique Name entered Successfully.", "Pass");
		return this;
	}
	
	public ClassicReportsHomePage enterReportDescription(String desc) {
		clearAndType(locateElement(Locators.XPATH, "//textarea[@name='reportDescription']"), desc);
		reportStep("Report Description entered Successfully.", "Pass");
		return this;
	}
	
	public ClassicReportsHomePage selectReportFolder(String reportFolder) {
		click(locateElement(Locators.XPATH, "//input[@id='saveReportDlg_folderFinder']/following-sibling::img"));
		click(locateElement(Locators.XPATH, "//div[text()='"+reportFolder+"']"));
		reportStep("Report folder selected Successfully.", "Pass");
		return this;
	}
	
	public ClassicReportsHomePage clicksaveReport() {
		click(locateElement(Locators.XPATH, "//table[@id='dlgSaveReport']//button[text()='Save']"));
		reportStep("Report Saved Successfuly.", "Pass");
		return this;
	}
	
	public ClassicReportsHomePage verifyReportIsCreated(String name) throws InterruptedException {
		Thread.sleep(5000);
		switchToLastOpenWindow();
		//switchToFrame(locateElement(Locators.XPATH, "(//iframe[contains(@class,'isEdit reportsReportBuilder')])"));
		verifyExactText(locateElement(Locators.XPATH, "//h2[@class='pageDescription']"), name);
		return this;
	}
	
	public ClassicReportsHomePage clickRunReport() {
		click(locateElement(Locators.XPATH, "//button[text()='Run Report']"));
		reportStep("Run Report Clicked Successfully.", "Pass");
		return this;
	}
	
	
	
	
	
	
}
