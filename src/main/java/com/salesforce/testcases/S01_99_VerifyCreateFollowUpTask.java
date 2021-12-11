package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class S01_99_VerifyCreateFollowUpTask extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testcaseName = "VerifyFollowUpTask";
		testDescription = "Verify Edit Task functionality with positive data";
		authors = "Subramanian";
		category = "Smoke";
	}

	@Test
	public void runCreateFollowUpTask() throws InterruptedException {
		new LoginPage().enterUsername("fullstack@testleaf.com").enterPassword("SelBootcamp$123").clickLogin()
				.clickToggleMenu().clickViewAll().clickContent().clickViewAllTodaysTask().changeDisplayTypeTable().SearchTask().clickFollowupTaskButton().selectAssigned()
				.selectSubject().selectStatus().selectContactName().selectRelatedTo().clickSave().verifyFollowupTaskCreated();
	}
}