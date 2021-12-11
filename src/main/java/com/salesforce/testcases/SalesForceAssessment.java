package com.salesforce.testcases;

import java.awt.AWTException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.AccountsPage;
import com.salesforce.pages.LoginPage;

public class SalesForceAssessment extends ProjectSpecificMethods {
	
	@BeforeTest
	public void setValues() {
		testcaseName = "New Reports SalesForce Classic";
		testDescription ="Verify leads in SalesForce Classic page";
		authors="Vels";
		category ="Functional";
		excelFileName="SalesForceAssessment";
	}
	
	@Test(dataProvider = "fetchData")
	public void createAccount(String username
							, String password
							, String rangeAs
							, String format
							, String reportName
							,String desc
							,String reportFolder) throws InterruptedException, AWTException {
		
		new LoginPage()
		.enterUsername(username)
		.enterPassword(password)
		.clickLogin()
		.clickToggleMenu()
		.clickViewAll()
		.clickService()
		.clickReports()
		.clickNewReportSalesforceClassic()
		.clickLeads()
		.downloadImage()
		.clickCreateButton()
		.selectRange(rangeAs)
		.selectToDate()
		.verifyReportFormat(format)
		.getAndDisplayCompanyList()
		.getTotalRecords()
		.clickSave()
		.enterReportName(reportName)
		.enterReportUniqueName(reportName)
		.enterReportDescription(desc)
		.selectReportFolder(reportFolder)
		.clicksaveReport()
		.verifyReportIsCreated(reportName)
		.clickRunReport()
		.getTotalRecords()
		.clickClose()
		.getAndVerifyReportName(reportName)
		.getCreatedOnDate();
		
	}

}
