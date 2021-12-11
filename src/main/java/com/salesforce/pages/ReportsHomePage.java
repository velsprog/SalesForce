package com.salesforce.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class ReportsHomePage extends ProjectSpecificMethods{
	
	public ClassicReportsHomePage clickNewReportSalesforceClassic() {
		click(locateElement(Locators.XPATH, "//div[@title='New Report (Salesforce Classic)']"));
		reportStep("New Report (Salesforce Classic) buton clicked successfuly.", "Pass");
		return new ClassicReportsHomePage();
	}

}
