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

public class AconexTest1 extends TestBase {

	private final Logger log = LoggerHelper.getLogger(AconexTest1.class);
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
	public void testHotelVIPResprt() throws InterruptedException, IOException {
		
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

		loginPage.clickhotelVIPResort();

		boolean projectselstatus = loginPage.verifyProjectSelectedPagehotel();
		if (projectselstatus) {
			log.info("Hotel VIP Resort is clicked successfully");

		} else {
			Assert.assertTrue(false, "click Hotel VIP Resort is not sucessful");
		}

		log.info(HotelVIPResortPage.class.getName() + " started");
		hotelVIPResortPage = new HotelVIPResortPage(driver);

		hotelVIPResortPage.clickDocument();
		hotelVIPResortPage.clickUploadDocument();

		log.info(UploadDocumentPage.class.getName() + " started");
		uploadDocumentPage = new UploadDocumentPage(driver);

		docNum = (long) (Math.random() * 100000 + 3333300000L);
		log.info("docNum------------" + docNum);

		uploadDocumentPage.fillDocumentDetails(docNum, "111", "testpro");

		hotelVIPResortPage.clickDocument();
		hotelVIPResortPage.clickDocumentRegister();

		log.info(DocumentRegisterPage.class.getName() + " started");
		DocumentRegisterPage = new DocumentRegisterPage(driver);

		String strdocNum = String.valueOf(docNum);
		DocumentRegisterPage.enterDocumentNumber(strdocNum);

		String actualResult = DocumentRegisterPage.getDocNumberfromSearchTable();
		log.info("actual Document number------------" + actualResult);
		Assert.assertEquals(actualResult, strdocNum);


	}
}
