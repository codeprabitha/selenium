package com.aconexAutomation.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aconexAutomation.helper.GenericHelper;
import com.aconexAutomation.helper.LoggerHelper;
import com.aconexAutomation.helper.WaitHelper;
import com.aconexAutomation.testBase.Config;
import com.aconexAutomation.testBase.TestBase;

public class LoginPage {

	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(LoginPage.class);
	WaitHelper waitHelper;

	@FindBy(xpath = "//input[@id='userName']")
	WebElement userName;

	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	@FindBy(xpath = "//button[@id='login']")
	WebElement SignIn;

	@FindBy(xpath = "//span[@class='nav-logo']")
	WebElement successMsgObject;
	
	@FindBy(xpath = "//span[@class='projectChanger-arrow']")
	WebElement projectChangerArrow;
	
	@FindBy(xpath = "//div[starts-with(@id,'projectChanger')]//span[contains(text(),'Hotel VIP Resort')]")
	WebElement hotelVIPResort;
	
	@FindBy(xpath = "//span[contains(text(),'Hotel VIP Resort')]")
	WebElement hotelVIPResortSuccessMsg;
	
	@FindBy(xpath = "//div[starts-with(@id,'projectChanger')]//span[contains(text(),'World Games')]")
	WebElement worldGames;
	
	@FindBy(xpath = "//span[contains(text(),'World Games')]")
	WebElement worldGamesSuccessMsg;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(driver, userName, new Config(TestBase.OR).getExplicitWait());
	}

	public void enterUserName(String struserName) {
		log.info("entering username ...." + struserName);
		userName.sendKeys(struserName);

	}

	public void enterPassword(String strpassword) {
		log.info("entering password...." + strpassword);
		password.sendKeys(strpassword);

	}

	public void clickSignInButton() {
		log.info("clicked Sign In...");
		SignIn.click();
	}

	public void loginToAconex(String strUserName, String password) {
		enterUserName(strUserName);
		waitHelper.setImplicitWait(60, null);
		enterPassword(password);
		waitHelper.setImplicitWait(60, null);
		clickSignInButton();
	}

	public boolean verifyLoginPageText() {
		return new GenericHelper().isDisplayed(successMsgObject);
	}
	
	public void clickprojectChangerArrow() {
		log.info("clicked project Changer Arrow...");
		projectChangerArrow.click();
	}
	
	public void clickhotelVIPResort() {
		log.info("clicked project hotel VIP Resort..");
		hotelVIPResort.click();
	}

	public void clickworldGames() {
		log.info("clicked project World games..");
		worldGames.click();
	}
	
	public boolean verifyProjectSelectedPagehotel() {
		return new GenericHelper().isDisplayed(hotelVIPResortSuccessMsg);
	}
	
	public boolean verifyProjectSelectedPageWorldgames() {
		return new GenericHelper().isDisplayed(worldGamesSuccessMsg);
	}

}
