package com.framework.testng.api.base;

import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.framework.selenium.api.base.SeleniumBase;
import com.framework.utils.DataLibrary;
import com.salesforce.pages.AutowiredPages;

public class ProjectSpecificMethods extends AutowiredPages {

	@DataProvider(name = "fetchData", indices = 0)
	public Object[][] fetchData() throws IOException {
		return DataLibrary.readExcelData(excelFileName);
	}
	
	@Parameters("browser")
	@BeforeMethod(alwaysRun = true)
    public void preCondition(String browser) {
		startApp(browser, false, "https://login.salesforce.com/");
		setNode();
	}
	@AfterMethod
	public void postCondition() {
		quit();
	}
}
