package com.aconexAutomation.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aconexAutomation.helper.GenericHelper;
import com.aconexAutomation.helper.LoggerHelper;
import com.aconexAutomation.helper.WaitHelper;

public class EmailPage {
	
	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(EmailPage.class);
	WaitHelper waitHelper;
	JavascriptExecutor jexe;
	Select select;

	@FindBy(xpath = "//select[@id='Correspondence_correspondenceTypeID']")
	WebElement emailType;
	
	@FindBy(xpath = "//input[@id='SPEED_ADDRESS_TO']")
	WebElement emailTo;
	
	@FindBy(xpath = "//input[@id='Correspondence_subject']")
	WebElement emailSubject;
	
	@FindBy(xpath = "//button[@id='btnSend']")
	WebElement emailSend;
	
	@FindBy(xpath = "//span[contains(text(),'Sent')]")
	WebElement testemailSend;

	
	public EmailPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
	}
	
	public void enterDetailsEmailandSend(String type,String toName,String subject) {
	log.info("Entering details to send email...");
	driver.switchTo().frame("frameMain");
	waitHelper.setImplicitWait(60, null);
	select = new Select(emailType);
	select.selectByVisibleText(type);
	waitHelper.setImplicitWait(60, null);
	jexe = (JavascriptExecutor) driver;

	jexe.executeScript("arguments[1].value = arguments[0]; ", toName, emailTo);
	waitHelper.setImplicitWait(60, null);
	emailTo.sendKeys(Keys.ENTER);
	emailSubject.click();
	jexe.executeScript("arguments[1].value = arguments[0]; ", subject, emailSubject);
	waitHelper.setImplicitWait(60, null);
	emailSend.click();
	
	}
	
	public boolean verifySendEmailTxt() {
		return new GenericHelper().isDisplayed(testemailSend);
	}

}
