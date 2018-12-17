package com.aconexAutomation.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aconexAutomation.helper.LoggerHelper;
import com.aconexAutomation.helper.WaitHelper;
import com.aconexAutomation.testBase.Config;
import com.aconexAutomation.testBase.TestBase;

public class HotelVIPResortPage {
	
	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(HotelVIPResortPage.class);
	WaitHelper waitHelper;

	@FindBy(xpath = "//button[@id='nav-bar-DOC']")
	WebElement document;

	@FindBy(xpath = "//div[@id='nav-bar-DOC-DOC-NEW']")
	WebElement uploadDocument;
	
	@FindBy(xpath = "//div[@id='nav-bar-DOC-DOC-SEARCH']")
	WebElement documentRegister;


	public HotelVIPResortPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(driver, document, new Config(TestBase.OR).getExplicitWait());
	}

	public void clickDocument() {
		log.info("click document...");
		document.click();
	}
	
	public void clickUploadDocument() {
		log.info("click upload document menu...");
		uploadDocument.click();
	}
	
	public void clickDocumentRegister() {
		log.info("click on document register...");
		documentRegister.click();
	}
}



