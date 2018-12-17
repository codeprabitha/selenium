package com.aconexAutomationTests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aconexAutomation.helper.LoggerHelper;
import com.aconexAutomation.helper.WaitHelper;
import com.aconexAutomation.pageObjects.DocumentRegisterPage;
import com.aconexAutomation.pageObjects.EmailPage;
import com.aconexAutomation.pageObjects.HotelVIPResortPage;
import com.aconexAutomation.pageObjects.LoginPage;
import com.aconexAutomation.pageObjects.UploadDocumentPage;
import com.aconexAutomation.pageObjects.WorldGamesPage;
import com.aconexAutomation.testBase.Config;
import com.aconexAutomation.testBase.TestBase;

public class AconexTest2 extends TestBase {

	private final Logger log = LoggerHelper.getLogger(AconexTest2.class);
	WaitHelper wait;
	LoginPage loginPage;
	HotelVIPResortPage hotelVIPResortPage;
	DocumentRegisterPage DocumentRegisterPage;
	UploadDocumentPage uploadDocumentPage;
	WorldGamesPage worldGamesPage;
	EmailPage emailPage;
	long docNum;
	boolean actualCountval;

	@Test(enabled = true)
	public void testWordGames() {

		log.info(LoginPage.class.getName() + " started");
		Config config = new Config(OR);

		driver.get(config.getWebsite());
		
		driver.manage().window().maximize();

		loginPage = new LoginPage(driver);

		loginPage.loginToAconex(config.getUserName(), config.getPassword());

		boolean status = loginPage.verifyLoginPageText();
		if (status) {
			log.info("login is sucessful");

		} else {
			Assert.assertTrue(false, "login is not sucessful");
		}
		loginPage.clickprojectChangerArrow();

		loginPage.clickworldGames();

		boolean projectselstatus = loginPage.verifyProjectSelectedPageWorldgames();
		if (projectselstatus) {
			log.info("World games is clicked successfully");

		} else {
			Assert.assertTrue(false, "clicking World games is not sucessful");
		}

		log.info(WorldGamesPage.class.getName() + " started");
		worldGamesPage = new WorldGamesPage(driver);

		worldGamesPage.clickWorkFlow();

		worldGamesPage.clickWorkFlowAssigned();

		actualCountval = worldGamesPage.getWorkFlowsfromTable();
		if (actualCountval) {
			log.info("World games is clicked successfully");

		} else {
			Assert.assertTrue(false, "World games is not sucessful");
		}

	}

	
}
