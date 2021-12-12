package com.framework.selenium.api.base;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

public class DriverInstance extends AbstractTestNGSpringContextTests  {

	private static final ThreadLocal<RemoteWebDriver> remoteWebdriver = new ThreadLocal<RemoteWebDriver>();
	private static final ThreadLocal<WebDriverWait> wait = new  ThreadLocal<WebDriverWait>();

	public void setWait() {
		wait.set(new WebDriverWait(getDriver(), 10));
	}

	public WebDriverWait getWait() {
		return wait.get();
	}

	public void setDriver(String browser, boolean headless) {		
		switch (browser) {
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized"); 
			options.addArguments("--disable-notifications"); 
			options.addArguments("--incognito");
			remoteWebdriver.set(new ChromeDriver(options));
			break;
		case "firefox":
			remoteWebdriver.set(new FirefoxDriver());
			break;
		case "ie":
			remoteWebdriver.set(new InternetExplorerDriver());
		default:
			break;
		}
	}
	
	public void setRemoteDriver(String browser, boolean headless) {
		DesiredCapabilities cap = new DesiredCapabilities();
		SeleniumBase sb = new SeleniumBase();
		cap.setBrowserName(browser);
		switch (browser) {
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized"); 
			options.addArguments("--disable-notifications"); 
			options.addArguments("--incognito");
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			break;
		case "firefox":
			FirefoxOptions options1 = new FirefoxOptions(cap);
			options1.addPreference("dom.webnotifications.enabled", false);
			options1.addPreference("dom.push.enabled", false);
			options1.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			cap.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options1);
			break;
		case "ie":
			break;
		default:
			break;
		}
		try {
			remoteWebdriver.set(new RemoteWebDriver(new URL(sb.fetchPropertyValue(sb.loadPropFile("config"), "node")), cap));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public RemoteWebDriver getDriver() {
		return remoteWebdriver.get();
	}
	
}
