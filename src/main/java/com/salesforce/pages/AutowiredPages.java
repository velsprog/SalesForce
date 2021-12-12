package com.salesforce.pages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import com.framework.selenium.api.base.SeleniumBase;


@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AutowiredPages extends SeleniumBase {
	

	@Autowired
	protected LoginPage loginpage;

	@Autowired
	protected HomePage homepage;
	
	@Autowired
	protected AppLauncherPage applauncherpage;
	
	@Autowired
	protected SalesHomePage saleshomepage;
	
	@Autowired
	protected AccountsPage accountspage;
	
	@Autowired
	protected CreateOrEditAccountsPage createoreditaccountspage;
	
	
	
}
