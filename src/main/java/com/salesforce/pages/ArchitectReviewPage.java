package com.salesforce.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class ArchitectReviewPage extends ProjectSpecificMethods {
	
	public ArchitectReviewPage verifyArchitectReviewPage() {
		switchToLastOpenWindow();
		verifyTitle("Architect Review Boards");
		reportStep("Architect Review Boards Page loaded Success", "pass");
		return this;
	}
	public ArchitectReviewPage verifyBoarExam() {
		verifyExactText(locateElement(Locators.XPATH, "//div[contains(text(),'Technical Architect Review Board Exam')]"), "Resources : Architect Review Board Evaluation & Technical Architect Review Board Exam");
		reportStep("verify Architect page success", "pass");
		return this;
	}
	
}