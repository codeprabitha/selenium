package com.aconexAutomation.pageObjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aconexAutomation.helper.LoggerHelper;
import com.aconexAutomation.helper.WaitHelper;
import com.aconexAutomation.testBase.Config;
import com.aconexAutomation.testBase.TestBase;

public class WorldGamesPage {
	
	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(WorldGamesPage.class);
	WaitHelper waitHelper;
	int rowCount;
	boolean flag = false;

	@FindBy(xpath = "//button[@id='nav-bar-WORKFLOW']")
	WebElement workFlow;

	@FindBy(xpath = "//div[contains(text(),'Assigned to my organization')]")
	WebElement workFlowAssigned;
	
	@FindBy(xpath = "//table[@id='resultTable']")
	WebElement searchTable;
	
	public WorldGamesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(driver, workFlow, new Config(TestBase.OR).getExplicitWait());
	}

	public void clickWorkFlow() {
		log.info("click Work Flow...");
		workFlow.click();
	}
	
	public void clickWorkFlowAssigned() {
		log.info("click Work Flow assigned by organization...");
		workFlowAssigned.click();
	}
	
  public boolean getWorkFlowsfromTable() {
		log.info("Checking workflows count...");
		driver.switchTo().frame("frameMain");
		waitHelper.setImplicitWait(60, null);
		log.info("fetching work flows count from table...");
		List<WebElement> li = searchTable.findElements(By.tagName("tr"));
		rowCount = li.size();
		log.info("Count of work flows in the table..." +rowCount);
		if(rowCount>0) {
			flag = true;
		}
		else
		{
			flag = false;
		}
		return flag;
	}


}



