package com.aconexAutomation.testBase;

import java.util.Properties;

public class Config extends TestBase{
	
private Properties OR;
	
	public Config(Properties OR){
		this.OR = OR;
	}
	public String getUserName() {
		return OR.getProperty("username");
	}

	public String getPassword() {
		return OR.getProperty("password");
	}

	public String getWebsite() {
		return OR.getProperty("url");
	}

	public int getPageLoadTimeOut() {
		return Integer.parseInt(OR.getProperty("PageLoadTimeOut"));
	}

	public int getImplicitWait() {
		return Integer.parseInt(OR.getProperty("ImplcitWait"));
	}

	public int getExplicitWait() {
		return Integer.parseInt(OR.getProperty("ExplicitWait"));
	}

	public String getBrowser() {
		return OR.getProperty("Browser");
	}

}
