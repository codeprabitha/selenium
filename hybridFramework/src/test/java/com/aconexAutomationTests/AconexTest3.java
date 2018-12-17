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

public class AconexTest3 extends TestBase {

	private final Logger log = LoggerHelper.getLogger(AconexTest3.class);
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
	public void testSendEmail() {
		
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

		log.info(HotelVIPResortPage.class.getName() + " started");
		hotelVIPResortPage = new HotelVIPResortPage(driver);

		hotelVIPResortPage.clickMail();
		hotelVIPResortPage.clickBlankMail();

		log.info(EmailPage.class.getName() + " started");
		emailPage = new EmailPage(driver);

		emailPage.enterDetailsEmailandSend("Transmittal", "lewis", "subject");

		//boolean checkSendEmail = emailPage.verifySendEmailTxt();
        /*
		f (checkSendEmail) {
			log.info("Email send successfully");

		} else {
			Assert.assertTrue(false, "Sending email is not sucessful");
		}
	 */

	}
}
